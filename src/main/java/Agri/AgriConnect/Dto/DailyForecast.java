package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class DailyForecast {

    private String date;
    private double minTemp;
    private double maxTemp;
    private String description;

}