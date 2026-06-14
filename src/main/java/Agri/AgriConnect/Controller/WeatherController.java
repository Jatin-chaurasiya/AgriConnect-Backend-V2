package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.WeatherResponse;
import Agri.AgriConnect.Service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<WeatherResponse> getWeather(
            @RequestParam String state,
            @RequestParam String city,
            @RequestParam(required = false) String village) {

        return ResponseEntity.ok(
                weatherService.getWeatherData(state, city, village)
        );
    }
}