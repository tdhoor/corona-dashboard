package com.example.corona_dashboard.ui.countries;

import androidx.lifecycle.ViewModel;

import com.example.corona_dashboard.service.CoronaService;

public class CountriesViewModel extends ViewModel {
    private CountriesAdapter adapter;

    public CountriesViewModel() {
        adapter = new CountriesAdapter();
    }

    public void update(){
        CoronaService.getAllCountriesStatistics(response -> adapter.addCountries(response));
    }

    public CountriesAdapter getAdapter(){
        return adapter;
    }
}