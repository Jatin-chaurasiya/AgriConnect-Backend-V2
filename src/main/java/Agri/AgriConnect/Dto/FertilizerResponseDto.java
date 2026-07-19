package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class FertilizerResponseDto {

    private Long id;
    private String stage;
    private Integer dayNumber;
    private String fertilizerName;
    private Double quantity;
    private String unit;
    private String purpose;

}