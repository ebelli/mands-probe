package com.ebelli.mandsprobe.interactor;

import com.ebelli.mandsprobe.adapter.ApiRestAdapter;
import com.ebelli.mandsprobe.api.MandsApi;
import com.ebelli.mandsprobe.model.Directions;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * This class get the last directions of the alien space ship
 *
 */

public class GetData {
    ApiRestAdapter apiRestAdapter;
    Directions mDirections;

    public Directions getData(String email) {


        MandsApi mandsApi = apiRestAdapter.getRestClient();
        mandsApi.getData(email).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Directions>() {
                    @Override
                    public void call(Directions directions) {
                        mDirections = directions;
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });

        return mDirections;
    }
}
