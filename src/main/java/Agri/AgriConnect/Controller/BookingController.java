package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.*;
import Agri.AgriConnect.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create-order")
    public ResponseEntity<CreateOrderResponseDto> createOrder(
            @RequestBody CreateOrderRequestDto request) {

        return ResponseEntity.ok(
                bookingService.createOrder(request)
        );
    }
    @PostMapping("/verify-payment")
    public ResponseEntity<VerifyPaymentResponseDto> verifyPayment(
            @RequestBody VerifyPaymentRequestDto request) {

        return ResponseEntity.ok(
                bookingService.verifyPayment(request)
        );
    }
    @GetMapping("/myBookings")
    public ResponseEntity<Page<BookingResponseDto>> getMyBookings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "") String keyword) {
        return ResponseEntity.ok(
                bookingService.getMyBookings(
                        page,
                        size,
                        keyword
                )
        );
    }
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> cancelBooking(
            @PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(
                "Booking Cancelled Successfully."
        );
    }
}