package com.example.corona_dashboard.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.corona_dashboard.data.Country;
import com.example.corona_dashboard.data.CountryStatistic;
import com.example.corona_dashboard.data.TotalStatistic;

import org.json.JSONException;

import java.util.ArrayList;

public class NetworkService {
    private static final String TAG = NetworkService.class.getSimpleName();
    private static NetworkService mInstance;
    private static RequestQueue requestQueue;
    private Context context;

    private NetworkService(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        this.context = context;
    }

    public static synchronized NetworkService getInstance(){
        if(mInstance == null){
            throw new IllegalMonitorStateException(TAG + "is not initialized, call NetworkService.getInstance(...) first!");
        }
        requestQueue.start();
        return mInstance;
    }

    public static synchronized NetworkService getInstance(Context context){
        if(mInstance == null){
            mInstance = new NetworkService(context);
        }
        requestQueue.start();
        return mInstance;
    }

    public void getTotalStatistic(ResponseTotalStatisticListener listener){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, CoronaApi.totalCases(), null, response -> {
                    try {
                        listener.callback(TotalStatistic.parseJSONToTotalStatistic(response.getJSONObject("data")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
                    Log.e(TAG,"Error by fetching data. Check NetworkService.getTotalStatistic()");
                    Toast.makeText(context,"Update failed! Try again later.",Toast.LENGTH_LONG).show();
                });
        requestQueue.add(jsonObjectRequest);
    }

    /**
     * This method first fetches a single country from the country API. Secondly parses
     * it into a country object and finally returns the parsed country by the listener.
     * @param countryName Name of the country
     * @param listener Listener to receive the country object
     */
    public void getOneCountry(String countryName, ResponseCountryListener listener){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, CountryApi.country(countryName), null, response -> {
                    listener.callback(Country.parseJSONToCountry(response));
                }, error -> {
                    Log.e(TAG,"Error by fetching data. Check NetworkService.getOneCountry()");
                    Toast.makeText(context,"Update failed! Try again later.",Toast.LENGTH_LONG).show();
                });
        requestQueue.add(jsonObjectRequest);
    }

    /**
     * This method first fetches a single country-statistic from the corona API. Secondly parses
     * it into a country-statistic object and finally returns the parsed statistic by the listener.
     * @param countryName Name of the country
     * @param listener Listener to receive the country-statistic object
     */
    public void getOneCountryStatistic(String countryName, ResponseCountryStatisticListener listener){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, CoronaApi.country(countryName), null, response -> {
                    listener.callback(CountryStatistic.parseJSONToCountry(response));
                }, error -> {
                    Log.e(TAG,"Error by fetching data. Check NetworkService.getOneCountryStatistic()");
                    Toast.makeText(context,"Update failed! Try again later.",Toast.LENGTH_LONG).show();
                });
        requestQueue.add(jsonObjectRequest);
    }

    /**
     * This method first fetches all countries from the country API. Secondly parses them into
     * a List of country-statistics objects and finally returns the list by the listener.
     * @param listener Listener to receive the country-statistic object list
     */
    public void getAllCountries(ResponseCountriesListener listener){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, CountryApi.all(), null, response -> {
                    ArrayList<Country> countries = new ArrayList<>();
                    for(int i = 0; i < response.length(); i++){
                        try {
                            countries.add(Country.parseJSONToCountry(response.getJSONObject(i)));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    listener.callback(countries);
                }, error -> {
                    Log.e(TAG,"Error by fetching data. Check NetworkService.getAllCountries()");
                    Toast.makeText(context,"Update failed! Try again later.",Toast.LENGTH_LONG).show();
                });
        requestQueue.add(jsonArrayRequest);
    }

    /**
     * This method first fetches all countries, returned from the country API. Secondly
     * fetches all statistics from these countries and finally returns all country-statistics
     * by the listener.
     * @param listener Listener to receive the country-statistic objects
     */
    public void getAllCountriesStatistics(ResponseCountryStatisticListener listener){
        getAllCountries(countryResponse -> {
            for (Country c: countryResponse) {
                getOneCountryStatistic(c.getAlpha2Code(), listener::callback);
            }
        });
    }
}


