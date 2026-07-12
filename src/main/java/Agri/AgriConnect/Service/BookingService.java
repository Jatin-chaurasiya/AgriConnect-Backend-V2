package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.CreateOrderRequestDto;
import Agri.AgriConnect.Dto.CreateOrderResponseDto;
import Agri.AgriConnect.Dto.VerifyPaymentRequestDto;
import Agri.AgriConnect.Dto.VerifyPaymentResponseDto;

public interface BookingService {

    CreateOrderResponseDto createOrder(CreateOrderRequestDto request);
    VerifyPaymentResponseDto verifyPayment(VerifyPaymentRequestDto request);

}