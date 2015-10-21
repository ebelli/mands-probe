package com.ebelli.mandsprobe.interactor;

import com.ebelli.mandsprobe.adapter.ApiRestAdapter;
import com.ebelli.mandsprobe.api.MandsApi;
import com.ebelli.mandsprobe.model.Directions;
import com.ebelli.mandsprobe.model.Message;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * This class submit the coordinates to find the alien star ship
 */
@Module
public class SubmitData {

    @Inject
    ApiRestAdapter apiRestAdapter;

    Message mMessage;

    @Provides
    public Message submitData(String email, int x, int y) {


        MandsApi mandsApi = apiRestAdapter.getRestClient();
        mandsApi.submitData(email,x,y).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Message>() {
                    @Override
                    public void call(Message message) {
                        mMessage = message;
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });

        return mMessage;
    }

}
