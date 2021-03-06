package com.example.corona_dashboard.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.corona_dashboard.helpers.Converter;
import com.example.corona_dashboard.service.CoronaService;

public class DashboardViewModel extends ViewModel {
    private MutableLiveData<String> title, totalCases, totalRecovery, totalDeathCases, totalInfected,
            totalCasesOutcome, totalCasesMildConditions, totalCasesCriticalConditions, totalCasesDeathPercentage,
            totalCasesGeneralDeathRate, totalCasesLastUpdated;

    public DashboardViewModel() {
        totalCases = new MutableLiveData<>();
        totalRecovery = new MutableLiveData<>();
        totalDeathCases = new MutableLiveData<>();
        totalInfected = new MutableLiveData<>();
        totalCasesOutcome = new MutableLiveData<>();
        totalCasesMildConditions = new MutableLiveData<>();
        totalCasesCriticalConditions = new MutableLiveData<>();
        totalCasesDeathPercentage = new MutableLiveData<>();
        totalCasesGeneralDeathRate = new MutableLiveData<>();
        totalCasesLastUpdated = new MutableLiveData<>();
        title = new MutableLiveData<>();
    }

    public void update(){
        CoronaService.getTotalStatistic(response -> {
            title.setValue("Total cases");
            totalCases.setValue(Converter.formatNumberToLocal(response.getCases()));
            totalRecovery.setValue(Converter.formatNumberToLocal(response.getRecovered()));
            totalDeathCases.setValue(Converter.formatNumberToLocal(response.getDeaths()));
            totalInfected.setValue(Converter.formatNumberToLocal(response.getActive()));
        });
    }

    public LiveData<String> getTotalCases() {return totalCases;}
    public LiveData<String> getTotalRecovery() {
        return totalRecovery;
    }
    public LiveData<String> getTotalDeathCases() {
        return totalDeathCases;
    }
    public LiveData<String> getTotalInfected() {
        return totalInfected;
    }
    public LiveData<String> getTotalCasesOutcome() {
        return totalCasesOutcome;
    }
    public LiveData<String> getTotalCasesMildConditions() {
        return totalCasesMildConditions;
    }
    public LiveData<String> getTotalCasesCriticalConditions() {return totalCasesCriticalConditions;}
    public LiveData<String> getTotalCasesDeathPercentage() {
        return totalCasesDeathPercentage;
    }
    public LiveData<String> getTotalCasesGeneralDeathRate() {
        return totalCasesGeneralDeathRate;
    }
    public LiveData<String> getTotalCasesLastUpdate() {
        return totalCasesLastUpdated;
    }
    public LiveData<String> getTotalCasesTitle() {
        return title;
    }
}