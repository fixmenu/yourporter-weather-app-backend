package com.yourporter.weather.app.yourporterweatherapp.model.googlegeoapi;

import java.util.List;

public class GoogleGeoAddressModel {
    private List<GoogleComponentsModel> address_components;
    private GoogleGeoGeometryModel geometry;

    public List<GoogleComponentsModel> getAddress_components() {
        return address_components;
    }

    public void setAddress_components(List<GoogleComponentsModel> address_components) {
        this.address_components = address_components;
    }

    public GoogleGeoGeometryModel getGeometry() {
        return geometry;
    }

    public void setGeometry(GoogleGeoGeometryModel geometry) {
        this.geometry = geometry;
    }
}
