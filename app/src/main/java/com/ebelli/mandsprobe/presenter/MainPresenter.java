package com.ebelli.mandsprobe.presenter;

import com.ebelli.mandsprobe.model.Directions;
import com.ebelli.mandsprobe.model.Message;

/**
 * Created by ebelli on 20/10/15.
 */
public interface MainPresenter {

    Directions getData(String email);
    Message submitData(String email, int x, int y);
}
