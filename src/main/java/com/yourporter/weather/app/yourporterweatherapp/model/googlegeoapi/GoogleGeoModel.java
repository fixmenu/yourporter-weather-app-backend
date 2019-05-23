package com.yourporter.weather.app.yourporterweatherapp.model.googlegeoapi;

import java.util.List;

public class GoogleGeoModel {
    public List<GoogleGeoAddressModel> results;

    public List<GoogleGeoAddressModel> getResults() {
        return results;
    }

    public void setResults(List<GoogleGeoAddressModel> results) {
        this.results = results;
    }
}

