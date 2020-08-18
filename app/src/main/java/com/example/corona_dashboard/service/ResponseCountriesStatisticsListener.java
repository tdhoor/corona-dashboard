package com.example.corona_dashboard.service;

import com.example.corona_dashboard.data.CountryStatistic;

import java.util.ArrayList;

public interface ResponseCountriesStatisticsListener {
    void callback(ArrayList<CountryStatistic> response);
}
