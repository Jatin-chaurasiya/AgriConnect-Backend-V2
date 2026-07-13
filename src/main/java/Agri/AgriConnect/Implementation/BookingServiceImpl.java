package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Dto.*;
import Agri.AgriConnect.Entity.Booking;
import Agri.AgriConnect.Entity.ServiceEntity;
import Agri.AgriConnect.Entity.tbl_profiles;
import Agri.AgriConnect.Enum.BookingStatus;
import Agri.AgriConnect.Repository.BookingRepository;
import Agri.AgriConnect.Repository.ProfileRepository;
import Agri.AgriConnect.Repository.ServiceRepository;
import Agri.AgriConnect.Service.BookingService;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final RazorpayClient razorpayClient;
    private final ServiceRepository serviceRepository;
    private final BookingRepository bookingRepository;
    private final ProfileRepository profileRepository;
    private final RazorpaySignatureUtil razorpaySignatureUtil;

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
                .serviceName(booking.getService().getServiceName())
                .providerName(booking.getProvider().getBusinessName())
                .district(booking.getService().getDistrict())
                .price(booking.getService().getPrice())
                .unit(booking.getService().getUnit())
                .bookingDate(booking.getBookingDate().toString())
                .bookingTime(booking.getBookingTime().toString())
                .status(booking.getStatus())
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