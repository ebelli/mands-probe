package com.ebelli.mandsprobe.adapter;

import com.ebelli.mandsprobe.api.MandsApi;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Create and holds the Retrofit's RestAdapter
 */
public class ApiRestAdapter {
    private static String ENDPOINT = "https://mands-alien-test.herokuapp.com/api/";
    private static RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.FULL;

    @Provides
    @Singleton
    public MandsApi getRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(logLevel);


        //TODO: Add Logging
        //   builder.setLog();

        RestAdapter restAdapter = builder.build();
        return restAdapter.create(MandsApi.class);
    }

}
