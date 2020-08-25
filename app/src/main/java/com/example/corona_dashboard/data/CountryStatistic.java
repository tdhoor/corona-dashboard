package com.example.corona_dashboard.data;

public class CountryStatistic {
    private String name, continent;
    private int updated, cases, todayCases, deaths,todayDeaths, recovered, todayRecovered,
            active, critical, casesPerOneMillion, deathsPerOneMillion, tests, testsPerOneMillion,
            population, oneCasePerPeople, oneDeathPerPeople,oneTestPerPeople, activePerOneMillion,
            recoveredPerOneMillion, criticalPerOneMillion;

    public CountryStatistic() {
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(int todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(int casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public int getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(int deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(int testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(int oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public int getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(int oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public int getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(int oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public int getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(int activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public int getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(int recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public int getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(int criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", cases=" + cases +
                ", todayCases=" + todayCases +
                ", deaths=" + deaths +
                ", todayDeaths=" + todayDeaths +
                ", recovered=" + recovered +
                ", todayRecoverd=" + todayRecovered +
                ", active=" + active +
                ", critical=" + critical +
                ", casesPerOneMillion=" + casesPerOneMillion +
                ", deathsPerOneMillion=" + deathsPerOneMillion +
                ", tests=" + tests +
                ", testsPerOneMillion=" + testsPerOneMillion +
                ", population=" + population +
                ", continent='" + continent + '\'' +
                ", oneCasePerPeople=" + oneCasePerPeople +
                ", oneDeathPerPeople=" + oneDeathPerPeople +
                ", oneTestPerPeople=" + oneTestPerPeople +
                ", activePerOneMillion=" + activePerOneMillion +
                ", recoveredPerOneMillion=" + recoveredPerOneMillion +
                ", criticalPerOneMillion=" + criticalPerOneMillion +
                '}';
    }
}