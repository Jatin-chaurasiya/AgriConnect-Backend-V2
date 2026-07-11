package Agri.AgriConnect.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequestDto {

    private String serviceName;

    private String category;

    private String description;

    private Double price;

    private String unit;

    private String district;

    private String experience;

    private String imageUrl;

    private Boolean availability;
}