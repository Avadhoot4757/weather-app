package org.example.weather_app.ApiController;

import org.example.weather_app.Entity.FavoriteCity;
import org.example.weather_app.Model.CityReceiver;
import org.example.weather_app.Model.WeatherReceiver;
import org.example.weather_app.Model.WeatherSender;
import org.example.weather_app.Repository.FavoriteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiClientController {
    public final RestClient restCLient;

    private final List<String> favoriteCities = new ArrayList<>();

    private final FavoriteRepository favoriteRepository;

    public ApiClientController(RestClient restCLient, FavoriteRepository favoriteRepository) {
        this.restCLient = restCLient;
        this.favoriteRepository = favoriteRepository;
    }


    @GetMapping("/weather/{city}")
    public WeatherSender getWeather(@PathVariable String city) {

        String cityAPIURL = "https://geocoding-api.open-meteo.com/v1/search?name=" + city + "&count=1";

        CityReceiver cityData = restCLient.get()
                .uri(cityAPIURL)
                .retrieve()
                .body(CityReceiver.class);

        if (cityData == null || cityData.getResults() == null || cityData.getResults().isEmpty()) {
            throw new RuntimeException("City not found: " + city);
        }

        double lat = cityData.getResults().get(0).getLatitude();
        double lon = cityData.getResults().get(0).getLongitude();
        long id = cityData.getResults().get(0).getId();

        String weatherURL = "https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lon + "&current=temperature_2m";

        WeatherReceiver wthr = restCLient.get()
                .uri(weatherURL)
                .retrieve()
                .body(WeatherReceiver.class);

        if (wthr == null || wthr.getCurrent() == null) {
            throw new RuntimeException("Weather data unavailable");
        }

        double temp = wthr.getCurrent().getTemperature_2m();
        String time = wthr.getCurrent().getTime();
        boolean alert = temp < 5.0 || temp > 35.0;

        String cityName = cityData.getResults().get(0).getName();

        return new WeatherSender(id, cityName, lat, lon, 5.0, 35.0, temp, alert, time);

    }

    @PostMapping("/favorites/{city}")
    public ResponseEntity<?> addFavorite(@PathVariable String city) {

        city = city.toLowerCase();

        if (favoriteRepository.findByCityName(city).isPresent()) {
            return ResponseEntity.ok(Map.of("message", "City already in favorites"));
        }

        CityReceiver cityData = restCLient.get()
                .uri("https://geocoding-api.open-meteo.com/v1/search?name=" + city + "&count=1")
                .retrieve()
                .body(CityReceiver.class);

        double lat = cityData.getResults().get(0).getLatitude();
        double lon = cityData.getResults().get(0).getLongitude();
        String name = cityData.getResults().get(0).getName();

        favoriteRepository.save(new FavoriteCity(name, lat, lon));

        return ResponseEntity.ok(Map.of("message", name + " added to DB favorites"));
    }


    @GetMapping("/favorites")
    public List<WeatherSender> getFavoritesWeather() {

        List<FavoriteCity> cities = favoriteRepository.findAll();
        List<WeatherSender> response = new ArrayList<>();

        for (FavoriteCity city : cities) {

            String weatherURL = "https://api.open-meteo.com/v1/forecast?latitude=" +
                    city.getLatitude() + "&longitude=" + city.getLongitude() + "&current=temperature_2m";

            WeatherReceiver wthr = restCLient.get().uri(weatherURL).retrieve().body(WeatherReceiver.class);

            double temp = wthr.getCurrent().getTemperature_2m();
            String time = wthr.getCurrent().getTime();
            boolean alert = temp < 5.0 || temp > 35.0;

            response.add(new WeatherSender(
                    city.getId(),
                    city.getCityName(),
                    city.getLatitude(),
                    city.getLongitude(),
                    5.0, 35.0, temp, alert, time
            ));
        }

        return response;
    }
}
