package Agri.AgriConnect.Dto;

import Agri.AgriConnect.Enum.BookingStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponseDto {

    private Long bookingId;

    private String serviceName;

    private String providerName;

    private String district;

    private Double price;

    private String unit;

    private String bookingDate;

    private String bookingTime;

    private BookingStatus status;
    private String rejectionReason;
    private String paymentStatus;
}