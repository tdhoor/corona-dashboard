package com.example.corona_dashboard.service;

import com.example.corona_dashboard.data.CountryStatistic;
import com.example.corona_dashboard.data.TotalStatistic;
import com.example.corona_dashboard.helpers.Converter;
import com.example.corona_dashboard.helpers.CoronaApi;
import com.example.corona_dashboard.helpers.CoronaHelper;

public class CoronaService {

    /**
     * This method first fetches a single country-statistic from the corona API. Secondly parses
     * it into a country-statistic object and finally returns the parsed statistic by the listener.
     * @param countryName Name of the country
     * @param listener Listener to receive the country-statistic object
     */
    public static void getCountryStatistic(String countryName, ResponseCountryStatisticListener listener){
        NetworkService.getInstance().get(CoronaApi.generateCountryUrl(countryName),(NetworkService.ResponseObjectListener) response -> {
            listener.callback(Converter.parseJSONToCountry(response));
        });
    }

    /**
     * This method first fetches all countries, returned from the corona API. Secondly parses
     * them these countries and finally returns all country-statistics by the listener.
     * @param listener Listener to receive the country-statistic objects
     */
    public static void getAllCountriesStatistics(ResponseCountryStatisticListener listener){
        for(String countryName : CoronaHelper.getCountryCodes()){
            getCountryStatistic(countryName, listener);
        }
    }

    /**
     * This method first fetches the worldwide statistic, returned from the corona API. Secondly parses
     * it into a total-statistic object and finally returns  the parsed statistic by teh listener.
     * by the listener.
     * @param listener Listener to receive the total-statistic object
     */
    public static void getTotalStatistic(ResponseTotalStatisticListener listener){
        NetworkService.getInstance().get(CoronaApi.generateAllUrl(),(NetworkService.ResponseObjectListener) response -> {
            listener.callback(Converter.parseJSONToTotalStatistic(response));
        });
    }

    public interface ResponseCountryStatisticListener {
        void callback(CountryStatistic response);
    }

    public interface ResponseTotalStatisticListener {
        void callback(TotalStatistic response);
    }
}
