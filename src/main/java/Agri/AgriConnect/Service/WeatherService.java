package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.DailyForecast;
import Agri.AgriConnect.Dto.HourlyForecast;
import Agri.AgriConnect.Dto.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.objectMapper = new ObjectMapper();
    }
    public WeatherResponse getWeatherData(String state, String city, String village) {

        boolean villageProvided = village != null && !village.isBlank();

        String villageLocation = village + "," + city + "," + state + ",IN";
        String cityLocation = city + "," + state + ",IN";

        try {
            // village (if provided)
            if (villageProvided) {
                return buildWeatherResponse(villageLocation,
                        village + ", " + city + ", " + state);
            }

            // If no village, directly fetch city weather
            return buildWeatherResponse(cityLocation,
                    city + ", " + state);

        } catch (Exception e) {

            //if village failed, try city
            if (villageProvided) {
                try {
                    return buildWeatherResponse(cityLocation,
                            city + ", " + state);
                }catch (Exception ex) {
                    ex.printStackTrace();
                    throw new RuntimeException("Unable to fetch weather data", e);
                }
            }

            throw new RuntimeException("Unable to fetch weather data");
        }
    }

    private WeatherResponse buildWeatherResponse(String locationQuery, String displayLocation) {

        WeatherResponse response = fetchWeatherForLocation(locationQuery);
        response.setLocation(displayLocation);
        return response;
    }
    private WeatherResponse fetchWeatherForLocation(String location)
            throws RestClientException {

        try {

            String currentUrl = buildUrl("weather", location);
            String forecastUrl = buildUrl("forecast", location);

            String currentResponse =
                    restTemplate.getForObject(currentUrl, String.class);

            String forecastResponse =
                    restTemplate.getForObject(forecastUrl, String.class);

            JsonNode currentJson = objectMapper.readTree(currentResponse);
            JsonNode forecastJson = objectMapper.readTree(forecastResponse);

            // Handle 404 properly
            if (currentJson.path("cod").asText().equals("404")) {
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        "Location not found");
            }

            WeatherResponse response = new WeatherResponse();

            // -------- CURRENT WEATHER --------
            JsonNode mainNode = currentJson.path("main");
            JsonNode weatherNode = currentJson.path("weather").get(0);

            response.setLocation(currentJson.path("name").asText()
                    + ", " + currentJson.path("sys").path("country").asText());

            response.setTemperature(mainNode.path("temp").asDouble());
            response.setHumidity(mainNode.path("humidity").asInt());
            response.setPressure(mainNode.path("pressure").asInt());
            response.setWindSpeed(currentJson.path("wind").path("speed").asDouble());
            response.setDescription(weatherNode.path("description").asText());

            // -------- FORECAST DATA --------
            JsonNode forecastList = forecastJson.path("list");

            response.setHourlyForecast(buildTodayHourly(forecastList));
            response.setFiveDayForecast(buildFiveDayForecast(forecastList));

            return response;

        } catch (IOException e) {
            throw new RestClientException("JSON Parsing Failed", e);
        }
    }
    private String buildUrl(String endpoint, String location) {
        return UriComponentsBuilder
                .fromUriString("https://api.openweathermap.org/data/2.5/" + endpoint)
                .queryParam("q", location)
                .queryParam("units", "metric")
                .queryParam("appid", apiKey)
                .toUriString();
    }
    
    private List<HourlyForecast> buildTodayHourly(JsonNode forecastList) {

        List<HourlyForecast> hourlyList = new ArrayList<>();
        String today = getTodayDate();

        for (JsonNode item : forecastList) {

            String dtTxt = item.path("dt_txt").asText();

            if (dtTxt.startsWith(today)) {

                HourlyForecast hourly = new HourlyForecast();
                hourly.setTime(dtTxt.substring(11, 16));
                hourly.setTemperature(item.path("main").path("temp").asDouble());
                hourly.setDescription(
                        item.path("weather").get(0).path("description").asText());

                hourlyList.add(hourly);
            }
        }
        return hourlyList;
    }
    private List<DailyForecast> buildFiveDayForecast(JsonNode forecastList) {

        Map<String, List<Double>> tempMap = new LinkedHashMap<>();
        Map<String, String> descMap = new LinkedHashMap<>();

        for (JsonNode item : forecastList) {

            String dtTxt = item.path("dt_txt").asText();
            String date = dtTxt.substring(0, 10);

            tempMap.computeIfAbsent(date, k -> new ArrayList<>())
                    .add(item.path("main").path("temp").asDouble());

            if (dtTxt.contains("12:00:00") || !descMap.containsKey(date)) {
                descMap.put(date,
                        item.path("weather").get(0).path("description").asText());
            }
        }

        DateTimeFormatter inputFmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFmt =
                DateTimeFormatter.ofPattern("EEE, MMM d", Locale.ENGLISH);

        List<DailyForecast> dailyList = new ArrayList<>();

        for (String dateKey : tempMap.keySet()) {

            List<Double> temps = tempMap.get(dateKey);

            DailyForecast daily = new DailyForecast();
            daily.setDate(LocalDate.parse(dateKey, inputFmt).format(outputFmt));
            daily.setMinTemp(Collections.min(temps));
            daily.setMaxTemp(Collections.max(temps));
            daily.setDescription(descMap.get(dateKey));

            dailyList.add(daily);
        }

        return dailyList;
    }
    private String getTodayDate() { return Instant.now() .atZone(ZoneId.of("Asia/Kolkata")) .toLocalDate() .toString(); }
}
