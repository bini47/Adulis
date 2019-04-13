package com.example.biniyam.mint;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomnav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        Intent i = new Intent(MainActivity.this, landing.class);
        startActivity(i);


    }



}
