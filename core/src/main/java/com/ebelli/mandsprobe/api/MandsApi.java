package com.ebelli.mandsprobe.api;

import com.ebelli.mandsprobe.model.Directions;

import retrofit.http.Path;
import rx.Observable;
import retrofit.http.GET;

/**
 * Api Calls for Retrofit
 */
public interface MandsApi {

    @GET("spaceprobe/getdata/{email}")
    Observable<Directions> getData(@Path("email") String email);

    
}
