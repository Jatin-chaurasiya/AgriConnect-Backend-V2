package Agri.AgriConnect.Dto;

import lombok.Data;

import java.util.List;

@Data
public class CropPlannerResponseDto {

    // Crop Information

    private String cropName;
    private String scientificName;
    private String cropType;
    private String season;
    private Integer durationDays;

    private String idealTemperature;
    private String idealHumidity;
    private String idealPh;
    private String rainfall;
    private String description;

    // Planner Summary

    private Double estimatedCost;
    private Double expectedIncome;
    private Double expectedProfit;

    // Complete Crop Plan

    private List<SeedResponseDto> seeds;

    private List<FertilizerResponseDto> fertilizers;

    private List<IrrigationResponseDto> irrigations;

    private List<DiseaseResponseDto> diseases;

    private List<CalendarActivityResponseDto> calendarActivities;

    private List<CostResponseDto> costs;

    private List<YieldResponseDto> yields;

}