package com.example.corona_dashboard.service;

public class CoronaApi {
    private static String SERVER_URL = "https://disease.sh/v3/covid-19/";

    public static String all(){
        return SERVER_URL + "all";
    }

    public static String continents(String continentName){
        String url = SERVER_URL + "continents/{%s}";
        return String.format(url,continentName);
    }

    public static String continents(){
        return SERVER_URL + "continents";
    }

    public static String country(String countryName){
        String url = SERVER_URL + "countries/%s";
        return String.format(url,countryName);
    }

    public static String totalCases(){
        return "https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats";
    }
}
