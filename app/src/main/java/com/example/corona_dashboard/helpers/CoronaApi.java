package com.example.corona_dashboard.helpers;

public class CoronaApi {
    private static String SERVER_URL = "https://disease.sh/v3/covid-19/";

    /**
     * This method generates the URL to receive the worldwide total statistic.
     * @return String URL
     */
    public static String generateAllUrl(){
        return SERVER_URL + "all";
    }

    /**
     * This method generates the URL to receive a continent statistic.
     * @param continentName Name of the continent
     * @return String URL
     */
    public static String generateContinentUrl(String continentName){
        String url = SERVER_URL + "continents/{%s}";
        return String.format(url,continentName);
    }

    /**
     * This method generates the URL to receive a country statistic.
     * @param countryName Name of the country
     * @return String URL
     */
    public static String generateCountryUrl(String countryName){
        String url = SERVER_URL + "countries/%s";
        return String.format(url,countryName);
    }
}
