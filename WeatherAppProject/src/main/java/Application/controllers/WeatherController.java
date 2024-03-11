package Application.controllers;

import Application.models.dto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Application.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/forecast")
    public String getWeatherForecast(@RequestParam(required = false) Double latitude, @RequestParam(required = false) Double longitude, Model model) {
        if (latitude != null && longitude != null) {

            WeatherResponseDTO weatherData = weatherService.getWeatherForecast(latitude, longitude);
            model.addAttribute("weather", weatherData);
        } else {
            double defaultLatitude = 40.7128;
            double defaultLongitude = -74.0060;
            WeatherResponseDTO weatherData = weatherService.getWeatherForecast(defaultLatitude, defaultLongitude);
            model.addAttribute("weather", weatherData);
            model.addAttribute("message", "Showing NYC location's weather. Please enable location services for your weather.");
        }
        return "weather";
    }

}