package service;

import dto.WeatherResponseDTO;

public interface WeatherService {

    WeatherResponseDTO getWeatherForecast(double latitude, double longitude);
}
