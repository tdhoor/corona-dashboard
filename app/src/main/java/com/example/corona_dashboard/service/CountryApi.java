package com.example.corona_dashboard.service;

public class CountryApi {
    private static String SERVER_URL = "https://restcountries.eu/rest/v2/";

    public static String all(){
        return SERVER_URL + "all";
    }

    public static String country(String countryName){
        String url = SERVER_URL + "name/%s";
        return String.format(url,countryName);
    }
}
