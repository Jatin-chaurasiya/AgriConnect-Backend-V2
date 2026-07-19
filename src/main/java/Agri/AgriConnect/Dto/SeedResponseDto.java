package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class SeedResponseDto {

    private Long id;
    private String variety;
    private String seedRate;
    private String spacing;
    private String germination;
    private Double approxCost;

}