package com.ebelli.mandsprobe.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ebelli.mandsprobe.R;
import com.ebelli.mandsprobe.presenter.MainPresenterImpl;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity implements MainView
{

    @InjectView(R.id.etEmail) EditText etEmail;
    @InjectView(R.id.btnSearchSend) Button btnPay;
    @InjectView(R.id.tilEmail) TextInputLayout tilEmail;

    MainPresenterImpl mMainPresenter;

    @OnClick(R.id.btnSearchSend)
    void searchSend(){
        mMainPresenter.validateEmail(etEmail.getText().toString());
    }

    @OnTextChanged(R.id.etEmail)
    void hideError(){
        hideMailError();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mMainPresenter = new MainPresenterImpl(this);
        tilEmail.setErrorEnabled(true);
    }


    @Override
    public void showError(Exception error) {
        Toast.makeText(getApplicationContext(),
                error.getLocalizedMessage(),
                Toast.LENGTH_LONG
        ).show();
    }

    @Override
    public void showMailError() {
        tilEmail.setError(getResources().getText(R.string.mailerror));
    }

    @Override
    public void hideMailError() {
        tilEmail.setError("");
    }
}
