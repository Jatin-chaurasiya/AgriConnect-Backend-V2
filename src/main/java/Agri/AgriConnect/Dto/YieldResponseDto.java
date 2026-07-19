package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class YieldResponseDto {

    private Long id;

    private String state;
    private String region;

    private Double expectedYield;
    private String yieldUnit;

    private Double marketPrice;
    private String priceUnit;

    private Double expectedIncome;
    private Double expectedProfit;

}