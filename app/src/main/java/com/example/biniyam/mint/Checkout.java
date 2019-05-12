package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Common.CurrentUser;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Checkout extends AppCompatActivity {

    EditText firstname,lastname,companyname,city,streetname,housenumber,phone,email,deliverydate,paymentmethod,note,password;
    String transactionmethod="cbe birr";
    int paymentChoice;
    String paymentMethod;
    SliderLayout sliderLayout;
    AdulisApi adulisApi;
    MaterialRippleLayout submitButton;
    CurrentUser currentUser;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    com.example.biniyam.mint.Model.Product.Checkout checkout;
    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adulisApi = Common.getApi();
        initView();
        //get total price

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (paymentChoice==0){
                    transactionmethod= "Cash on delivery";
                    paymentMethod="cash on delivery";
                }
                else if(paymentChoice==1){
                    transactionmethod= "Cbe birr";
                    paymentMethod="ussd";
                }
                else if(paymentChoice==2){
                    transactionmethod= "Oro cash";
                    paymentMethod="ussd";
                }

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
                      paymentMethod,
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

        sliderLayout = (SliderLayout)findViewById(R.id.slider);
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
        password=(EditText)findViewById(R.id.password);


        TextSliderView textSliderView1 = new TextSliderView(Checkout.this);
        TextSliderView textSliderView2 = new TextSliderView(Checkout.this);
        TextSliderView textSliderView3 = new TextSliderView(Checkout.this);

        textSliderView1.description("Cash on delivery").image(R.drawable.banner1).setScaleType(BaseSliderView.ScaleType.Fit);
        textSliderView2.description("CBE Birr").image(R.drawable.banner).setScaleType(BaseSliderView.ScaleType.Fit);
        textSliderView3.description("Oro cash").image(R.drawable.banner3).setScaleType(BaseSliderView.ScaleType.Fit);
        sliderLayout.addSlider(textSliderView1);
        sliderLayout.addSlider(textSliderView2);
        sliderLayout.addSlider(textSliderView3);

        sliderLayout.stopAutoCycle();
        sliderLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                 paymentChoice=sliderLayout.getCurrentPosition();
                 //disable password field for cash on delivery
                if (paymentChoice==1){
                    password.setEnabled(false);
                }
                else{
                    password.setEnabled(true);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
