package com.example.corona_dashboard.data;

import org.json.JSONException;
import org.json.JSONObject;

public class Country {
    private String name, alpha2Code, alpha3Code, continent;

    public Country(){}

    public Country(String name, String alpha2Code, String alpha3Code, String continent) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.continent = continent;
    }

    public static Country parseJSONToCountry(JSONObject jsonObject) {
        Country country = new Country();
        try {
            country.setName(jsonObject.getString("name"));
            country.setAlpha2Code(jsonObject.getString("alpha2Code"));
            country.setAlpha3Code(jsonObject.getString("alpha3Code"));
            country.setContinent(jsonObject.getString("region"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
