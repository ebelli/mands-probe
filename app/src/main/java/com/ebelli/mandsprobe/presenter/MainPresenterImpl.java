package com.ebelli.mandsprobe.presenter;

import com.ebelli.mandsprobe.interactor.GetData;
import com.ebelli.mandsprobe.interactor.SubmitData;
import com.ebelli.mandsprobe.model.Directions;
import com.ebelli.mandsprobe.model.Message;

import javax.inject.Inject;

import dagger.Module;

/**
 * Presenter for the Main Activity
 */

@Module
public class MainPresenterImpl implements MainPresenter {

    @Inject
    GetData getData;

    @Inject
    SubmitData submitData;

    @Override
    public Directions getData(String email) {
        getData.getData(email);
        return null;
    }

    @Override
    public Message submitData(String email,int x, int y) {
        submitData.submitData(email, x, y);
        return null;
    }
}
