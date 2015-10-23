package com.ebelli.mandsprobe.adapter;

import android.util.Log;

import com.ebelli.mandsprobe.api.MandsApi;
import retrofit.RestAdapter;

/**
 * Create and holds the Retrofit's RestAdapter
 */

public class ApiRestAdapter {
    private static String ENDPOINT = "https://mands-alien-test.herokuapp.com/api";
    private static RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.FULL;


    public static MandsApi getRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(logLevel)
                .setLog(getLog());

        RestAdapter restAdapter = builder.build();
        return restAdapter.create(MandsApi.class);
    }


    private static RestAdapter.Log getLog(){
        return new RestAdapter.Log() {
            @Override
            public void log(String msg) {
                Log.i("HTTP", msg);
            }
        };
    }

}
