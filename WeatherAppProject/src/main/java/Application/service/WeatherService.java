package Application.service;

import Application.models.dto.WeatherResponseDTO;

public interface WeatherService {

    WeatherResponseDTO getWeatherForecast(double latitude, double longitude);
}
