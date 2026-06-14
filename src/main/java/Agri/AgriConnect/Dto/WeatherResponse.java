package Agri.AgriConnect.Dto;

import lombok.Data;
import java.util.List;

@Data
public class WeatherResponse {

    private String location;
    private double temperature;
    private String description;
    private double windSpeed;
    private int humidity;
    private int pressure;

    private List<HourlyForecast> hourlyForecast;
    private List<DailyForecast> fiveDayForecast;

}