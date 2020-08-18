package com.example.corona_dashboard.data;

import org.json.JSONException;
import org.json.JSONObject;

public class TotalStatistic {
    private String totalCases, totalRecovery, totalDeathCases, totalInfected,
            totalCasesOutcome, totalCasesMildConditions, totalCasesCriticalConditions, totalCasesDeathPercentage,
            totalCasesGeneralDeathRate, totalCasesLastUpdated;

    public TotalStatistic(){}

    public static TotalStatistic parseJSONToTotalStatistic(JSONObject jsonObject){
        TotalStatistic totalStatistic = new TotalStatistic();

        try {
            totalStatistic.totalCases = jsonObject.getString("total_cases");
            totalStatistic.totalRecovery = jsonObject.getString("recovery_cases");
            totalStatistic.totalDeathCases = jsonObject.getString("death_cases");
            totalStatistic.totalInfected = jsonObject.getString("currently_infected");
            totalStatistic.totalCasesOutcome = jsonObject.getString("cases_with_outcome");
            totalStatistic.totalCasesMildConditions = jsonObject.getString("mild_condition_active_cases");
            totalStatistic.totalCasesCriticalConditions = jsonObject.getString("critical_condition_active_cases");
            totalStatistic.totalCasesDeathPercentage = jsonObject.getString("closed_cases_death_percentage");
            totalStatistic.totalCasesGeneralDeathRate = jsonObject.getString("general_death_rate");
            totalStatistic.totalCasesLastUpdated = jsonObject.getString("last_update");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return totalStatistic;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getTotalRecovery() {
        return totalRecovery;
    }

    public void setTotalRecovery(String totalRecovery) {
        this.totalRecovery = totalRecovery;
    }

    public String getTotalDeathCases() {
        return totalDeathCases;
    }

    public void setTotalDeathCases(String totalDeathCases) {
        this.totalDeathCases = totalDeathCases;
    }

    public String getTotalInfected() {
        return totalInfected;
    }

    public void setTotalInfected(String totalInfected) {
        this.totalInfected = totalInfected;
    }

    public String getTotalCasesOutcome() {
        return totalCasesOutcome;
    }

    public void setTotalCasesOutcome(String totalCasesOutcome) {
        this.totalCasesOutcome = totalCasesOutcome;
    }

    public String getTotalCasesMildConditions() {
        return totalCasesMildConditions;
    }

    public void setTotalCasesMildConditions(String totalCasesMildConditions) {
        this.totalCasesMildConditions = totalCasesMildConditions;
    }

    public String getTotalCasesCriticalConditions() {
        return totalCasesCriticalConditions;
    }

    public void setTotalCasesCriticalConditions(String totalCasesCriticalConditions) {
        this.totalCasesCriticalConditions = totalCasesCriticalConditions;
    }

    public String getTotalCasesDeathPercentage() {
        return totalCasesDeathPercentage;
    }

    public void setTotalCasesDeathPercentage(String totalCasesDeathPercentage) {
        this.totalCasesDeathPercentage = totalCasesDeathPercentage;
    }

    public String getTotalCasesGeneralDeathRate() {
        return totalCasesGeneralDeathRate;
    }

    public void setTotalCasesGeneralDeathRate(String totalCasesGeneralDeathRate) {
        this.totalCasesGeneralDeathRate = totalCasesGeneralDeathRate;
    }

    public String getTotalCasesLastUpdated() {
        return totalCasesLastUpdated;
    }

    public void setTotalCasesLastUpdated(String totalCasesLastUpdated) {
        this.totalCasesLastUpdated = totalCasesLastUpdated;
    }
}
