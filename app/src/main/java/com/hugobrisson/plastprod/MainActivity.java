package com.hugobrisson.plastprod;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @ViewById(R.id.identifiant)
    EditText email;
    @ViewById(R.id.password)
    EditText password;
    @ViewById(R.id.button_connect)
    com.rey.material.widget.Button connect;

    private String emailText;
    private String passwordText;

    @AfterViews
    void configure() {
        emailText="hugo";
        passwordText="test";

    }

    @Click(R.id.button_connect)
    void click(){
        if(emailText.equals(email.getText().toString()) && passwordText.equals(password.getText().toString())){
            startActivity(new Intent(this,HomeActivity_.class));
            finish();
        }
    }

}
