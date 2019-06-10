package com.example.biniyam.mint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Model.Product.Cart;
import com.example.biniyam.mint.Model.Product.Product;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleProduct extends AppCompatActivity {

    TextView title,price,releseDate,stoke,description,catagory,tags,review;
    AdulisApi adulisApi;

    Common common = new Common();
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    LinearLayout addToCart;//TODO: CHANGE THIS TO MATERIAL LAYOUT

    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adulisApi = Common.getApi();

        //init views

        title= (TextView)findViewById(R.id.title);
        price= (TextView)findViewById(R.id.price);
        releseDate= (TextView)findViewById(R.id.date);
        stoke= (TextView)findViewById(R.id.stoke_status);
        description= (TextView)findViewById(R.id.description);
        catagory= (TextView)findViewById(R.id.category);
        addToCart= (LinearLayout)findViewById(R.id.lyt_add_cart);
        review= (TextView) findViewById(R.id.review);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProductToCart( Common.currentProductId);
            }
        });





        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {/*
                Intent i= new Intent(getBaseContext(), Comments.class);
                startActivity(i);*/
            }
        });
        //TODO: ADD THIS TO SWIPE REFRESH LAYOUT
        fetchProduct(Common.currentProductId);
    }

    private void addProductToCart(String id) {

        compositeDisposable.add(adulisApi.addToCart(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<Cart>() {
                            @Override
                            public void accept(Cart cart) throws Exception {
                                Toast.makeText(SingleProduct.this, "Product added to your cart", Toast.LENGTH_SHORT).show();

                            }

                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Toast.makeText(SingleProduct.this,throwable.getMessage() , Toast.LENGTH_SHORT).show();

                            }
                        }));
    }

    private void fetchProduct(String id) {

        Call<Product> call = adulisApi.getSingleProduct(id);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {


                Common.currentProduct = response.body();
                title.setText(response.body().getPname());
                price.setText(response.body().getPrice());
                description.setText(response.body().getDescription());

                //STOKE LOGIC
                int stokeamount = response.body().getStokeamount();
                if (stokeamount < 10) {
                    stoke.setText("only " + String.valueOf(stokeamount) + " left");
                    //TODO: MAKE THE TEXT orange

                } else if (stokeamount >= 10)
                    stoke.setText("IN STOKE");

                else {
                    //TODO: MAKE THE TEXT RED
                    stoke.setText("Out of stoke STOKE");
                }


            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(SingleProduct.this, t + "Error while loading data", Toast.LENGTH_SHORT).show();

            }

        });

    }
}

