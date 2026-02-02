package org.example.weather_app.ApiController;

import org.example.weather_app.Model.CityReceiver;
import org.example.weather_app.Model.WeatherReceiver;
import org.example.weather_app.Model.WeatherSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ApiClientController {

    public final RestClient restCLient;

    public ApiClientController(RestClient restCLient) {
        this.restCLient = restCLient;
    }

    @GetMapping("/weather/{city}")
    public WeatherSender getweather(@PathVariable String city) {
        String cityAPIURL = "https://geocoding-api.open-meteo.com/v1/search?name=" + city + "&count=1";
        CityReceiver cityData = restCLient.get().uri(cityAPIURL).header("Accept-Encoding", "identiy").retrieve().body(CityReceiver.class);
//        CityReceiver.City cityName = (CityReceiver.City) cityData.getResults();
        String currentTempApiURL = "https://api.open-meteo.com/v1/forecast?latitude=" + cityData.getResults().get(0).getLatitude() + "&longitude=" + cityData.getResults().get(0).getLongitude() + "&current=temperature_2m";

        WeatherReceiver wthr = restCLient.get().uri(currentTempApiURL).header("Accep-Encoding", "identiy").retrieve().body(WeatherReceiver.class);

        assert wthr != null;
        double temp = wthr.getCurrent().getTemperature_2m();
        String time = wthr.getCurrent().getTime();
        boolean alert = !(temp > 5.00) || !(temp < 35.00);
        return new WeatherSender(0L, wthr.getLatitude() , wthr.getLongitude() , 5.00 , 35.00 , temp , alert , time);
    }

    @PostMapping("/favorites")
    public void postFavorite(){

    }


}
