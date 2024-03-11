package Application.service;

import Application.models.dto.WeatherResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${open-meteo.api.current}")
    private String currentWeatherUrl;

    @Value("${open-meteo.api.forecast.hourly}")
    private String hourlyForecastUrl;

    @Value("${open-meteo.api.forecast.past_days}")
    private String pastDaysForecastUrl;

    @Value("${open-meteo.api.historical}")
    private String historicalWeatherUrl;

    @Override
    public WeatherResponseDTO getWeatherForecast(double latitude, double longitude) {
        // Dynamically build the URL with latitude and longitude for current weather
        String currentApiUrl = String.format(currentWeatherUrl, latitude, longitude);
        WeatherResponseDTO currentWeatherResponse = restTemplate.getForObject(currentApiUrl, WeatherResponseDTO.class);

        // Hourly forecast
        String hourlyApiUrl = String.format(hourlyForecastUrl, latitude, longitude);
        WeatherResponseDTO hourlyForecastResponse = restTemplate.getForObject(hourlyApiUrl, WeatherResponseDTO.class);

        // Past days forecast
        String pastDaysApiUrl = String.format(pastDaysForecastUrl, latitude, longitude);
        WeatherResponseDTO pastDaysForecastResponse = restTemplate.getForObject(pastDaysApiUrl, WeatherResponseDTO.class);

        // Historical weather data
        String historicalApiUrl = String.format(historicalWeatherUrl, latitude, longitude);
        WeatherResponseDTO historicalWeatherResponse = restTemplate.getForObject(historicalApiUrl, WeatherResponseDTO.class);

        // Log fetched data for debugging
        logger.info("Current weather data fetched: {}", currentWeatherResponse);
        logger.info("Hourly forecast data fetched: {}", hourlyForecastResponse);
        logger.info("Past days forecast data fetched: {}", pastDaysForecastResponse);
        logger.info("Historical weather data fetched: {}", historicalWeatherResponse);

        // Assuming you're returning the current weather response here for simplicity
        // Consider combining information from different responses into a single DTO that suits your needs
        return currentWeatherResponse;
    }
}
