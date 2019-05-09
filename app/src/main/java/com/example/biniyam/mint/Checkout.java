package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Common.CurrentUser;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Checkout extends AppCompatActivity {

    EditText firstname,lastname,companyname,city,streetname,housenumber,phone,email,deliverydate,paymentmethod,note;
    String transactionmethod="cbe birr";
    AdulisApi adulisApi;
    MaterialRippleLayout submitButton;
    CurrentUser currentUser;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    com.example.biniyam.mint.Model.Product.Checkout checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adulisApi = Common.getApi();
        initView();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: validation
              checkout = new com.example.biniyam.mint.Model.Product.Checkout(
                      firstname.getText().toString(),
                      lastname.getText().toString(),
                      companyname.getText().toString(),
                      city.getText().toString(),
                      streetname.getText().toString(),
                      housenumber.getText().toString(),
                      phone.getText().toString(),
                      email.getText().toString(),
                      "ussd",
                      note.getText().toString(),
                      transactionmethod,
                      deliverydate.getText().toString()
              );
                currentUser = new CurrentUser(Checkout.this);
                String token = currentUser.getToken();
                if (token.equals("")) {
                    //TODO: SEND ERROR DATA TO LOGIN VIEW
                    //fragment.finish()
                }
              setOrder(token,checkout);
            }
        });

    }

    private void setOrder(String token, com.example.biniyam.mint.Model.Product.Checkout checkout) {
        Call<com.example.biniyam.mint.Model.Product.Checkout> call = adulisApi.order(token,checkout);
        call.enqueue(new Callback<com.example.biniyam.mint.Model.Product.Checkout>() {
            @Override
            public void onResponse(Call<com.example.biniyam.mint.Model.Product.Checkout> call, Response<com.example.biniyam.mint.Model.Product.Checkout> response) {
                Toast.makeText(Checkout.this, "order sent", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<com.example.biniyam.mint.Model.Product.Checkout> call, Throwable t) {
                Toast.makeText(Checkout.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
        note=(EditText) findViewById(R.id.note);
        submitButton=(MaterialRippleLayout)findViewById(R.id.submit);
        // paymentmethod=(EditText)findViewById(R.id.);
    }

}
