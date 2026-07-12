package Agri.AgriConnect.Dto;

import Agri.AgriConnect.Enum.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerifyPaymentResponseDto {

    private Long bookingId;

    private String message;

    private BookingStatus status;

    private String paymentId;

}