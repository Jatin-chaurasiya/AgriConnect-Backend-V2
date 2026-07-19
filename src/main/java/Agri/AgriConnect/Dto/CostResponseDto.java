package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class CostResponseDto {

    private Long id;

    private String state;
    private String region;

    private Double seedCost;
    private Double fertilizerCost;
    private Double pesticideCost;
    private Double labourCost;
    private Double irrigationCost;
    private Double harvestingCost;
    private Double miscellaneousCost;

    private Double totalCost;

}