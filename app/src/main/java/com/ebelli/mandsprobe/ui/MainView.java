package com.ebelli.mandsprobe.ui;

/**
 * Created by ebelli on 16/10/15.
 */
public interface MainView {

    void showError(Exception error);
    void showMailError();
    void hideMailError();
}
