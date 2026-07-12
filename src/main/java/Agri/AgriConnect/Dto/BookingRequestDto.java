package Agri.AgriConnect.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequestDto {

    private Long serviceId;

    private String farmerName;

    private String mobile;

    private String village;

    private String address;

    private String bookingDate;

    private String bookingTime;

    private String note;
}