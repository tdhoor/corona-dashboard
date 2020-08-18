package com.example.corona_dashboard.service;

import com.example.corona_dashboard.data.CountryStatistic;

public interface ResponseCountryStatisticListener {
    void callback(CountryStatistic response);
}