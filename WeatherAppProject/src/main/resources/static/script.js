function fetchWeatherForecast() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      const latitude = position.coords.latitude;
      const longitude = position.coords.longitude;
      window.location.href = `/weather/forecast?latitude=${latitude}&longitude=${longitude}`;
    }, function(error) {
      console.error("Geolocation error: ", error);
    });
  } else {
    console.log("Geolocation is not supported by this browser.");
  }
}

document.addEventListener('DOMContentLoaded', fetchWeatherForecast);