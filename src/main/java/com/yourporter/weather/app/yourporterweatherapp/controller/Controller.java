package com.yourporter.weather.app.yourporterweatherapp.controller;

import com.yourporter.weather.app.yourporterweatherapp.model.response.CityCoords;
import com.yourporter.weather.app.yourporterweatherapp.model.googlegeoapi.GoogleGeoAddressModel;
import com.yourporter.weather.app.yourporterweatherapp.model.googlegeoapi.GoogleGeoModel;
import com.yourporter.weather.app.yourporterweatherapp.service.DarkSkyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    DarkSkyService darkSkyService;

    @RequestMapping(value = "/getWeatherInfo/{lat}/{lng}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getWeatherInfo(@PathVariable("lat") String lat, @PathVariable("lng") String lng) {
        return darkSkyService.getWeatherInfo(lat, lng);
    }

    @RequestMapping(value = "/getCityCoord/{cityName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CityCoords getCoordsOfTheCity(@PathVariable("cityName") String cityName) {
        GoogleGeoModel googleGeoModel = darkSkyService.getCoordsOfTheCity(cityName);
        GoogleGeoAddressModel googleGeoAddressModel = googleGeoModel.getResults().get(0);
        return new CityCoords(googleGeoAddressModel.getAddress_components().get(0).getLong_name(),
                googleGeoAddressModel.getGeometry().getLocation().getLat(),
                googleGeoAddressModel.getGeometry().getLocation().getLng());
    }
}
