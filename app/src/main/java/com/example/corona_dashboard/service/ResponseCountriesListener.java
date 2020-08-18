package com.example.corona_dashboard.service;

import com.example.corona_dashboard.data.Country;

import java.util.ArrayList;

public interface ResponseCountriesListener {
    void callback(ArrayList<Country> response);
}
