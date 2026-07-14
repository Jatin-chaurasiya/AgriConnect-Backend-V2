package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.*;
import org.springframework.data.domain.Page;

public interface BookingService {

    CreateOrderResponseDto createOrder(CreateOrderRequestDto request);
    VerifyPaymentResponseDto verifyPayment(VerifyPaymentRequestDto request);
    Page<BookingResponseDto> getMyBookings(
            int page,
            int size,
            String keyword
    );
    void cancelBooking(Long bookingId);
    Page<BookingResponseDto> getProviderBookingRequests(
            int page,
            int size
    );
    BookingResponseDto acceptBooking(Long bookingId);
    public BookingResponseDto rejectBooking(
            Long bookingId,
            String reason);
    BookingResponseDto completeBooking(Long bookingId);
    Page<BookingResponseDto> getBookingHistory(
            int page,
            int size
    );
}