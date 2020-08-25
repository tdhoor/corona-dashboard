package com.example.corona_dashboard.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

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
        return mInstance;
    }

    public static synchronized NetworkService getInstance(Context context){
        if(mInstance == null){
            mInstance = new NetworkService(context);
        }
        requestQueue.start();
        return mInstance;
    }

    public void startRequest(){
        requestQueue.start();
    }

    public void stopRequest(){
        requestQueue.stop();
    }

    /**
     * This method fetches data from a given url and parses it into a JSON object.
     * @param url URL
     * @param listener Listener to receive the JSON object.
     */
    public void get(String url, ResponseObjectListener listener){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,url,null, listener::callback, error -> Log.e(TAG,"Error by fetching data. Check NetworkService.get()'JSONObject'")
        );
        requestQueue.add(jsonObjectRequest);
    }

    /**
     * This method fetches data from a given url and parses it into a JSON array.
     * @param url URL
     * @param listener Listener to receive the JSON array.
     */
    public void get(String url, ResponseArrayListener listener){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,url,null, listener::callback, error -> Log.e(TAG,"Error by fetching data. Check NetworkService.get()'JSONArray'")
        );
        requestQueue.add(jsonArrayRequest);
    }

    public interface ResponseObjectListener{
        void callback(JSONObject response);
    }

    public interface ResponseArrayListener{
        void callback(JSONArray response);
    }
}


