package com.example.corona_dashboard.ui.countries;

import androidx.lifecycle.ViewModel;

import com.example.corona_dashboard.service.NetworkService;

public class CountriesViewModel extends ViewModel {
    private CountriesAdapter adapter;

    public CountriesViewModel() {
        adapter = new CountriesAdapter();
    }

    public void update(){
        NetworkService.getInstance().getAllCountriesStatistics(response -> adapter.addCountries(response));
    }

    public CountriesAdapter getAdapter(){
        return adapter;
    }
}