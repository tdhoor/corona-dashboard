package com.example.corona_dashboard.helpers;

import com.example.corona_dashboard.data.CountryStatistic;
import com.example.corona_dashboard.data.TotalStatistic;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class Converter {
    /**
     * This method parses a json object into a country-statistic object.
     * @param jsonObject Object to parse
     * @return CountryStatistic object
     */
    public static CountryStatistic parseJSONToCountry(JSONObject jsonObject){
        CountryStatistic countryStatistic = new CountryStatistic();

        try {
            countryStatistic.setName(jsonObject.getString("country"));
            countryStatistic.setUpdated(jsonObject.getInt("updated"));
            countryStatistic.setCases(jsonObject.getInt("cases"));
            countryStatistic.setTodayCases(jsonObject.getInt("todayCases"));
            countryStatistic.setDeaths(jsonObject.getInt("deaths"));
            countryStatistic.setTodayDeaths(jsonObject.getInt("todayDeaths"));
            countryStatistic.setRecovered(jsonObject.getInt("recovered"));
            countryStatistic.setTodayRecovered(jsonObject.getInt("todayRecovered"));
            countryStatistic.setActive(jsonObject.getInt("active"));
            countryStatistic.setCritical(jsonObject.getInt("critical"));
            countryStatistic.setCasesPerOneMillion(jsonObject.getInt("casesPerOneMillion"));
            countryStatistic.setDeathsPerOneMillion(jsonObject.getInt("deathsPerOneMillion"));
            countryStatistic.setTests(jsonObject.getInt("tests"));
            countryStatistic.setTestsPerOneMillion(jsonObject.getInt("testsPerOneMillion"));
            countryStatistic.setPopulation(jsonObject.getInt("population"));
            countryStatistic.setOneCasePerPeople(jsonObject.getInt("oneCasePerPeople"));
            countryStatistic.setOneDeathPerPeople(jsonObject.getInt("oneDeathPerPeople"));
            countryStatistic.setOneTestPerPeople(jsonObject.getInt("oneTestPerPeople"));
            countryStatistic.setActivePerOneMillion(jsonObject.getInt("activePerOneMillion"));
            countryStatistic.setRecoveredPerOneMillion(jsonObject.getInt("recoveredPerOneMillion"));
            countryStatistic.setCasesPerOneMillion(jsonObject.getInt("criticalPerOneMillion"));
            countryStatistic.setContinent(jsonObject.getString("continent"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return countryStatistic;
    }

    /**
     * This method parses a json object into a total-statistic object.
     * @param jsonObject Object to parse
     * @return TotalStatistic object
     */
    public static TotalStatistic parseJSONToTotalStatistic(JSONObject jsonObject){
        TotalStatistic totalStatistic = new TotalStatistic();

        try {
            totalStatistic.setUpdated(jsonObject.getInt("updated"));
            totalStatistic.setCases(jsonObject.getInt("cases"));
            totalStatistic.setTodayCases(jsonObject.getInt("todayCases"));
            totalStatistic.setDeaths(jsonObject.getInt("deaths"));
            totalStatistic.setTodayDeaths(jsonObject.getInt("todayDeaths"));
            totalStatistic.setRecovered(jsonObject.getInt("recovered"));
            totalStatistic.setTodayRecovered(jsonObject.getInt("todayRecovered"));
            totalStatistic.setActive(jsonObject.getInt("active"));
            totalStatistic.setCritical(jsonObject.getInt("critical"));
            totalStatistic.setCasesPerOneMillion(jsonObject.getInt("casesPerOneMillion"));
            totalStatistic.setDeathsPerOneMillion(jsonObject.getInt("deathsPerOneMillion"));
            totalStatistic.setTests(jsonObject.getInt("tests"));
            totalStatistic.setPopulation(jsonObject.getInt("population"));
            totalStatistic.setOneCasePerPeople(jsonObject.getInt("oneCasePerPeople"));
            totalStatistic.setOneDeathPerPeople(jsonObject.getInt("oneDeathPerPeople"));
            totalStatistic.setOneTestPerPeople(jsonObject.getInt("oneTestPerPeople"));
            totalStatistic.setActivePerOneMillion(jsonObject.getInt("activePerOneMillion"));
            totalStatistic.setRecoveredPerOneMillion(jsonObject.getInt("recoveredPerOneMillion"));
            totalStatistic.setCasesPerOneMillion(jsonObject.getInt("criticalPerOneMillion"));
            totalStatistic.setAffectedCountries(jsonObject.getInt("affectedCountries"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return totalStatistic;
    }

    /**
     * This method converts a given number into the local language number-dot format.
     * @param number Number to parse
     * @return Formatted number
     */
    public static String formatNumberToLocal(int number){
        DecimalFormat format = new DecimalFormat();
        return format.format(number);
    }

    /**
     * This method converts a formatted string number into a number.
     * @param number String to convert
     * @return Number
     */
    public static int formatLocalToNumber(String number){
        return Integer.parseInt(number.replaceAll("[,.]",""));
    }
}
