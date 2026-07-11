package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class HourlyForecast {

    private String time;
    private double temperature;
    private String description;

}