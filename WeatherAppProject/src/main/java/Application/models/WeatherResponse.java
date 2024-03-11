package Application.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    private Current current;

    // Getters and setters
    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    static class Current {
        @JsonProperty("temperature_2m")
        private double temperature2m;

        @JsonProperty("wind_speed_10m")
        private double windSpeed10m;

        // Getters and setters
        public double getTemperature2m() {
            return temperature2m;
        }

        public void setTemperature2m(double temperature2m) {
            this.temperature2m = temperature2m;
        }

        public double getWindSpeed10m() {
            return windSpeed10m;
        }

        public void setWindSpeed10m(double windSpeed10m) {
            this.windSpeed10m = windSpeed10m;
        }
    }
}
