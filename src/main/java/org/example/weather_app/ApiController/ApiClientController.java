package org.example.weather_app.ApiController;

import org.example.weather_app.Model.WeatherReceiver;
import org.example.weather_app.Model.WeatherSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ApiClientController {

    public final RestClient restCLient;

    public ApiClientController(RestClient restCLient) {
        this.restCLient = restCLient;
    }

//    @GetMapping("/weather/{latitude}&{longitude}")
//    public void getweather(@PathVariable double latitude , @PathVariable double longitude ){
//        String currentTempApiURL = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +"&longitude=" + longitude + "&current=temperature_2m";
/// /        String hourlyTempApiURL = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +"&longitude=" + longitude + "&hourly=temperature_2m";
///
/// @return
//
//
//        ;
//
//    }

    @GetMapping("/weather/{latitude}&{longitude}")
    public WeatherSender getweather(@PathVariable double latitude, @PathVariable double longitude) {
        String currentTempApiURL = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&current=temperature_2m";

        WeatherReceiver wthr = restCLient.get().uri(currentTempApiURL).header("Accep-Encoding", "identiy").retrieve().body(WeatherReceiver.class);
//        WeatherReceiver wthr = restClient.get()
//                .uri(currentTempApiURL)
//                .header("Accept-Encoding", "identity")
//                .retrieve()
//                .bodyToMono(WeatherReciever.class)
//                .subscribe(weather -> {
//                    System.out.println(weather);
//                });
        assert wthr != null;
        double temp = wthr.getCurrent().getTemperature_2m();
        String time = wthr.getCurrent().getTime();
        boolean alert = !(temp > 5.00) || !(temp < 35.00);
        return new WeatherSender(0L, wthr.getLatitude() , wthr.getLongitude() , 5.00 , 35.00 , temp , alert , time);
    }


}
