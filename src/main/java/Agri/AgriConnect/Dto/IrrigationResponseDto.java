package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class IrrigationResponseDto {

    private Long id;
    private String dayNumber;
    private String stage;
    private String description;

}