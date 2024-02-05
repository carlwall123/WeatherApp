package service;

import dto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openmeteo.base.url}")
    private String baseUrl;


    @Override
    public WeatherResponseDTO getWeatherForecast(double latitude, double longitude) {
        return null;
    }
}

