package Agri.AgriConnect.Dto;

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
public class VerifyPaymentRequestDto {

    private Long serviceId;

    private String razorpayOrderId;

    private String razorpayPaymentId;

    private String razorpaySignature;

    private String farmerName;

    private String mobile;

    private String village;

    private String address;

    private String bookingDate;

    private String bookingTime;

    private String note;
}