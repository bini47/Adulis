package com.example.biniyam.mint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


import com.example.biniyam.mint.CartalogeAdaprter.ProdutAdapter;
import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Model.Cart.CartRoot;
import com.example.biniyam.mint.Model.Cart.MyCart;
import com.example.biniyam.mint.Model.Product.Product;
import com.example.biniyam.mint.Model.User.Profile.Profile;
import com.example.biniyam.mint.Retrofit.AdulisApi;
import com.example.biniyam.mint.ShoppingCartAdapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoppingCart extends AppCompatActivity {

    ArrayList<String> title= new ArrayList<>();
    ArrayList<String> amount= new ArrayList<>();
    ArrayList<Integer>imageId= new ArrayList<>();
    ArrayList<String>price= new ArrayList<>();
    AppCompatButton checkout_btn;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    AdulisApi adulisApi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adulisApi = Common.getApi();

        recyclerView= (RecyclerView)findViewById(R.id.cart_recycler);
        checkout_btn = (AppCompatButton)findViewById(R.id.checkout_btn);
        checkout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chechout= new Intent(ShoppingCart.this, Checkout.class);
                startActivity(chechout);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(ShoppingCart.this));


        loadCart();

        title.add("Nike shooes");
        title.add("Majical Clock");
        title.add("High hills");
        title.add("Pan");
        title.add("Habeshan dress");

        amount.add("3 item(s)");
        amount.add("53 item(s)");
        amount.add("7 item(s)");
        amount.add("2 item(s)");
        amount.add("1 item(s)");


        imageId.add(R.drawable.img_plant_6);
        imageId.add(R.drawable.img_plant_6);
        imageId.add(R.drawable.img_plant_6);
        imageId.add(R.drawable.img_plant_6);
        imageId.add(R.drawable.img_plant_6);

        price.add("200");
        price.add("1000");
        price.add("2000");
        price.add("60");
        price.add("5000");



    }

    private void loadCart() {

        compositeDisposable.add(adulisApi.getCart()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<MyCart>>() {
                            @Override
                            public void accept(List<MyCart> myCarts) throws Exception {
                                displayCart(myCarts);
                            }
                        }
                ));

    }

    private void displayCart(List<MyCart> cart) {
        MyAdapter adapter = new MyAdapter(ShoppingCart.this, cart);
        recyclerView.setAdapter(adapter);

    }
}



