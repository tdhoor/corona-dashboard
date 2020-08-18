package com.example.corona_dashboard.service;


import com.example.corona_dashboard.data.CountryStatistic;

public interface ResponseObjectListener {
    void callback(CountryStatistic response);
}

