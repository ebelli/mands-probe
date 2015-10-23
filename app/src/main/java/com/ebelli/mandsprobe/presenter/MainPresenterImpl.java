package com.ebelli.mandsprobe.presenter;

import com.ebelli.mandsprobe.interactor.GetData;
import com.ebelli.mandsprobe.interactor.SubmitData;
import com.ebelli.mandsprobe.model.Directions;
import com.ebelli.mandsprobe.model.Message;
import com.ebelli.mandsprobe.ui.MainActivity;
import com.ebelli.mandsprobe.util.DataValidator;

/**
 * Presenter for the Main Activity
 */

public class MainPresenterImpl implements MainPresenter {

    private MainActivity mMainActivity;
    private GetData mGetData;
    private SubmitData mSubmitData;



    public MainPresenterImpl(MainActivity mainActivity) {
        mMainActivity = mainActivity;
        mGetData = new GetData();
        mSubmitData = new SubmitData();
    }


    private Directions getData(String email) {
        mGetData.getData(email);
        return null;
    }

    private Message submitData(String email,int x, int y) {
        mSubmitData.submitData(email, x, y);
        return null;
    }

    @Override
    public void validateEmail(String email) {

        if (DataValidator.isValidEmail(email)){
            mMainActivity.hideMailError();
           getData(email);
        } else {
            mMainActivity.showMailError();
        }

    }

}
