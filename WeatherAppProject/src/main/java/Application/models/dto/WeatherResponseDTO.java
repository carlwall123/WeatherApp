package Application.models.dto;
import java.util.List;

public class WeatherResponseDTO {

    private CurrentWeather current;
    private HourlyWeather hourly;
    // Assuming you might also want to include a structure for historical data if needed

    // Getters and Setters

    public static class CurrentWeather {
        private String time;
        private double temperature_2m;
        private double wind_speed_10m;

        // Getters and Setters
    }

    public static class HourlyWeather {
        private List<String> time;
        private List<Double> temperature_2m;
        private List<Double> relative_humidity_2m;
        private List<Double> wind_speed_10m;

        // Getters and Setters
    }

    // Getters and Setters for WeatherResponseDto
    public CurrentWeather getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }

    public HourlyWeather getHourly() {
        return hourly;
    }

    public void setHourly(HourlyWeather hourly) {
        this.hourly = hourly;
    }
}
