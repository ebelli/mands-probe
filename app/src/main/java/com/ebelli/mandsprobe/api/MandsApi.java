package com.ebelli.mandsprobe.api;

import com.ebelli.mandsprobe.model.Directions;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Api Calls for Retrofit
 */
public interface MandsApi {

    @GET("spaceprobe/getdata/{email}")
    Observable<Directions> getData(@Path("email") String email);

    @GET("spaceprobe/submitdata/{email}/{x}/{y}")
    Observable<String> submitData(@Path("email") String email, int x, int y);

}
