package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.biniyam.mint.ShoppingCartAdapter.MyAdapter;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    ArrayList<String> title= new ArrayList<>();
    ArrayList<String> amount= new ArrayList<>();
    ArrayList<Integer>imageId= new ArrayList<>();
    ArrayList<String>price= new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= (RecyclerView)findViewById(R.id.cart_recycler);

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


        imageId.add(R.drawable.ic_update);
        imageId.add(R.drawable.ic_update);
        imageId.add(R.drawable.ic_update);
        imageId.add(R.drawable.ic_update);
        imageId.add(R.drawable.ic_update);

        price.add("200");
        price.add("1000");
        price.add("2000");
        price.add("60");
        price.add("5000");


        recyclerView.setLayoutManager(new LinearLayoutManager(ShoppingCart.this));
        adapter =new MyAdapter(ShoppingCart.this,title,price,imageId,amount);
        recyclerView.setAdapter(adapter);

    }



}
