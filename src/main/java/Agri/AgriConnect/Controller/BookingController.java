package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.CreateOrderRequestDto;
import Agri.AgriConnect.Dto.CreateOrderResponseDto;
import Agri.AgriConnect.Dto.VerifyPaymentRequestDto;
import Agri.AgriConnect.Dto.VerifyPaymentResponseDto;
import Agri.AgriConnect.Service.BookingService;
import lombok.RequiredArgsConstructor;
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
            @RequestBody VerifyPaymentRequestDto request){

        return ResponseEntity.ok(
                bookingService.verifyPayment(request)
        );
    }
}