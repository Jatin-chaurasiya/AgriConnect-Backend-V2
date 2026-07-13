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
}