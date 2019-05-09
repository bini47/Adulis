package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Checkout extends AppCompatActivity {

    EditText firstname,lastname,companyname,city,streetname,housenumber,phone,email,deliverydate,paymentmethod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();


    }

    private void initView() {
        firstname=(EditText)findViewById(R.id.firstname);
        lastname=(EditText)findViewById(R.id.lastname);
        companyname=(EditText)findViewById(R.id.companyname);
        city=(EditText)findViewById(R.id.city);
        streetname=(EditText)findViewById(R.id.streetname);
        housenumber=(EditText)findViewById(R.id.housenumber);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        deliverydate=(EditText)findViewById(R.id.deliverydate);
        // paymentmethod=(EditText)findViewById(R.id.);
    }

}
