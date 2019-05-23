package com.yourporter.weather.app.yourporterweatherapp.service;

import com.yourporter.weather.app.yourporterweatherapp.model.googlegeoapi.GoogleGeoModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DarkSkyService {
    @Value("${darksky.secretKey}")
    private String darkSkySecretKey;

    @Value("${darksky.url}")
    private String darkSkyUrl;

    @Value("${google.geo.api.url}")
    private String geoApiUrl;

    @Value("${google.geo.api.secretkey}")
    private String geoApiSecretKey;

    private RestTemplate restTemplate;

    public DarkSkyService(){
        this.restTemplate = new RestTemplate();
    }

    public String getWeatherInfo(String lat, String lng){
        return restTemplate.getForObject(darkSkyUrl + "/" + darkSkySecretKey + "/" + lat + "," + lng+"?exclude=[currently,flags]&units=si",String.class);
    }

    public GoogleGeoModel getCoordsOfTheCity(String cityName){
        String url = geoApiUrl + cityName +"&key=" + geoApiSecretKey;
        return restTemplate.getForObject(url, GoogleGeoModel.class);
    }

}
