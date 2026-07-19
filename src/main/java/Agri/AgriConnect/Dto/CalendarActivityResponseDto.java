package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class CalendarActivityResponseDto {

    private Long id;
    private Integer dayNumber;
    private String activity;
    private String description;

}