package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Dto.*;
import Agri.AgriConnect.Entity.Booking;
import Agri.AgriConnect.Entity.ServiceEntity;
import Agri.AgriConnect.Entity.tbl_profiles;
import Agri.AgriConnect.Enum.BookingStatus;
import Agri.AgriConnect.Repository.BookingRepository;
import Agri.AgriConnect.Repository.ProfileRepository;
import Agri.AgriConnect.Repository.ProviderDetailsRepository;
import Agri.AgriConnect.Repository.ServiceRepository;
import Agri.AgriConnect.Service.BookingService;
import Agri.AgriConnect.Service.EmailService;
import Agri.AgriConnect.Util.RazorpaySignatureUtil;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import Agri.AgriConnect.Repository.ProviderDetailsRepository;
import Agri.AgriConnect.Entity.tbl_provider_details;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final EmailService emailService;
    private final RazorpayClient razorpayClient;
    private final ServiceRepository serviceRepository;
    private final BookingRepository bookingRepository;
    private final ProfileRepository profileRepository;
    private final RazorpaySignatureUtil razorpaySignatureUtil;
    private final ProviderDetailsRepository providerDetailsRepository;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    @Value("${razorpay.key.id}")
    private String razorpayKey;

    @Override
    public CreateOrderResponseDto createOrder(CreateOrderRequestDto request) {

        try {

            ServiceEntity service = serviceRepository.findById(request.getServiceId())
                    .orElseThrow(() -> new RuntimeException("Service not found"));

            int amount = (int) (service.getPrice() * 100);

            JSONObject options = new JSONObject();
            options.put("amount", amount);
            options.put("currency", "INR");
            options.put("receipt", "receipt_" + service.getId());
            Order order = razorpayClient.orders.create(options);

            return CreateOrderResponseDto.builder()
                    .orderId(order.get("id"))
                    .amount(amount)
                    .currency(order.get("currency"))
                    .key(razorpayKey)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Failed to create Razorpay Order : " + e.getMessage());
        }
    }
    @Override
    public VerifyPaymentResponseDto verifyPayment(
            VerifyPaymentRequestDto request) {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String email = authentication.getName();

        tbl_profiles farmer = profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        // Service Find
        ServiceEntity service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        boolean isValid = razorpaySignatureUtil.verifySignature(
                request.getRazorpayOrderId(),
                request.getRazorpayPaymentId(),
                request.getRazorpaySignature()
        );
        if (!isValid) {
            throw new RuntimeException("Invalid Razorpay Signature");
        }
        if (!isValid) {
            throw new RuntimeException("Invalid Razorpay Signature");
        }

        Booking booking = convertToBooking(
                request,
                farmer,
                service
        );
        Booking savedBooking = bookingRepository.save(booking);
        emailService.sendBookingReceivedEmail(savedBooking);
        return convertToResponse(savedBooking);
    }
    @Override
    public Page<BookingResponseDto> getMyBookings(
            int page,
            int size,
            String keyword) {

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String email = authentication.getName();

        tbl_profiles farmer = profileRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        Pageable pageable = PageRequest.of(page, size);
        Page<Booking> bookings;
        if (keyword == null || keyword.trim().isEmpty()) {
            bookings = bookingRepository.findByFarmerIdOrderByBookedAtDesc(
                    farmer.getId(),
                    pageable
            );

        } else {
            bookings = bookingRepository
                    .findByFarmerIdAndService_ServiceNameContainingIgnoreCase(
                            farmer.getId(),
                            keyword,
                            pageable
                    );
        }

        return bookings.map(this::convertToBookingResponse);
    }
    @Override
    public void cancelBooking(Long bookingId) {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        String email = authentication.getName();
        tbl_profiles farmer = profileRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Farmer not found"));
        Booking booking = bookingRepository
                .findByIdAndFarmerId(
                        bookingId,
                        farmer.getId()
                )
                .orElseThrow(() ->
                        new RuntimeException("Booking not found"));

        if (booking.getStatus() != BookingStatus.PENDING) {
            throw new RuntimeException(
                    "Only pending booking can be cancelled."
            );
        }
        bookingRepository.delete(booking);
    }
    private tbl_provider_details getCurrentProvider() {

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String email = authentication.getName();

        tbl_profiles profile = profileRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Profile not found"));

        return providerDetailsRepository
                .findByProfile(profile)
                .orElseThrow(() ->
                        new RuntimeException("Provider not found"));
    }
    @Override
    public Page<BookingResponseDto> getProviderBookingRequests(
            int page,
            int size) {

        tbl_provider_details provider = getCurrentProvider();

        Pageable pageable = PageRequest.of(page, size);

        return bookingRepository
                .findByProviderAndStatusInOrderByBookedAtDesc(
                        provider,
                        List.of(
                                BookingStatus.PENDING,
                                BookingStatus.ACCEPTED
                        ),
                        pageable
                )
                .map(this::convertToBookingResponse);
    }
    @Override
    public BookingResponseDto acceptBooking(Long bookingId) {

        tbl_provider_details provider = getCurrentProvider();

        Booking booking = bookingRepository
                .findByIdAndProvider(
                        bookingId,
                        provider
                )
                .orElseThrow(() ->
                        new RuntimeException("Booking not found"));

        if (booking.getStatus() != BookingStatus.PENDING) {
            throw new RuntimeException(
                    "Only pending booking can be accepted."
            );
        }
        booking.setStatus(BookingStatus.ACCEPTED);
        Booking updatedBooking = bookingRepository.save(booking);
        emailService.sendBookingAcceptedEmail(updatedBooking);
        return convertToBookingResponse(updatedBooking);
    }
    @Override
    public BookingResponseDto rejectBooking(
            Long bookingId,
            String reason) {

        tbl_provider_details provider = getCurrentProvider();

        Booking booking = bookingRepository
                .findByIdAndProvider(bookingId, provider)
                .orElseThrow(() ->
                        new RuntimeException("Booking not found"));

        if (booking.getStatus() != BookingStatus.PENDING) {
            throw new RuntimeException(
                    "Only pending booking can be rejected."
            );
        }

        booking.setStatus(BookingStatus.REJECTED);
        booking.setRejectionReason(reason);

        Booking updatedBooking = bookingRepository.save(booking);

        emailService.sendBookingRejectedEmail(
                updatedBooking,
                reason
        );

        return convertToBookingResponse(updatedBooking);
    }
    @Override
    public BookingResponseDto completeBooking(Long bookingId) {

        tbl_provider_details provider = getCurrentProvider();

        Booking booking = bookingRepository
                .findByIdAndProvider(bookingId, provider)
                .orElseThrow(() ->
                        new RuntimeException("Booking not found"));

        if (booking.getStatus() != BookingStatus.ACCEPTED) {
            throw new RuntimeException(
                    "Only accepted booking can be completed."
            );
        }
        booking.setStatus(BookingStatus.COMPLETED);
        Booking updatedBooking = bookingRepository.save(booking);
        emailService.sendBookingCompletedEmail(updatedBooking);
        return convertToBookingResponse(updatedBooking);
    }
    @Override
    public Page<BookingResponseDto> getBookingHistory(
            int page,
            int size) {

        tbl_provider_details provider = getCurrentProvider();

        Pageable pageable = PageRequest.of(page, size);

        return bookingRepository
                .findByProviderAndStatusInOrderByBookedAtDesc(
                        provider,
                        List.of(
                                BookingStatus.COMPLETED,
                                BookingStatus.REJECTED
                        ),
                        pageable
                )
                .map(this::convertToBookingResponse);
    }
    private Booking convertToBooking(
            VerifyPaymentRequestDto request,
            tbl_profiles farmer,
            ServiceEntity service) {

        return Booking.builder()
                .farmer(farmer)
                .provider(service.getProvider())
                .service(service)
                .farmerName(request.getFarmerName())
                .mobile(request.getMobile())
                .village(request.getVillage())
                .address(request.getAddress())
                .bookingDate(LocalDate.parse(request.getBookingDate()))
                .bookingTime(LocalTime.parse(request.getBookingTime()))
                .note(request.getNote())
                .status(BookingStatus.PENDING)
                .paymentStatus("SUCCESS")
                .razorpayOrderId(request.getRazorpayOrderId())
                .razorpayPaymentId(request.getRazorpayPaymentId())
                .bookedAt(LocalDateTime.now())
                .build();
    }
    private BookingResponseDto convertToBookingResponse(
            Booking booking) {

        return BookingResponseDto.builder()
                .bookingId(booking.getId())

                .farmerName(booking.getFarmerName())
                .mobile(booking.getMobile())
                .village(booking.getVillage())
                .address(booking.getAddress())

                .serviceName(booking.getService().getServiceName())
                .providerName(booking.getProvider().getBusinessName())
                .district(booking.getService().getDistrict())
                .price(booking.getService().getPrice())
                .unit(booking.getService().getUnit())

                .bookingDate(booking.getBookingDate().toString())
                .bookingTime(booking.getBookingTime().toString())

                .status(booking.getStatus())
                .rejectionReason(booking.getRejectionReason())
                .paymentStatus(booking.getPaymentStatus())

                .build();
    }
    private VerifyPaymentResponseDto convertToResponse(
            Booking booking) {
        return VerifyPaymentResponseDto.builder()
                .bookingId(booking.getId())
                .message("Payment Verified Successfully. Booking Created.")
                .status(booking.getStatus())
                .paymentId(booking.getRazorpayPaymentId())
                .build();
    }

}