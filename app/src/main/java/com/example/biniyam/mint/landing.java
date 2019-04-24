package com.example.biniyam.mint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import io.reactivex.disposables.CompositeDisposable;

public class landing extends AppCompatActivity {

    Toolbar toolbar;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    AdulisApi adulisApi;

    private BottomNavigationView bottomnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adulisApi = Common.getApi();


        bottomnav = (BottomNavigationView)findViewById(R.id.bottomnavigationview);
        bottomnav.setOnNavigationItemSelectedListener(mOnNavigationSelectedListner);


        loadFragment(new HomeActivity());

    }



    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationSelectedListner
            =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()){
                case R.id.home_nav:
                    getSupportActionBar().show();
                    toolbar.setTitle("Adulis");

                    loadFragment(new HomeActivity());
                    return true;
                case R.id.dashboard_nav:
                    getSupportActionBar().hide();

                    loadFragment(new Shop());
                    return true;
                case R.id.notification:
                    getSupportActionBar().show();
                    toolbar.setTitle("Order");
                    loadFragment(new Notification());

                    return true;
                case R.id.profile_nav:
                    getSupportActionBar().show();
                    toolbar.setTitle("Profile");
                    loadFragment(new Profile());
                    return true;

                case R.id.order_nav:
                    getSupportActionBar().show();
                    toolbar.setTitle("My Orders");
                    loadFragment(new Order());
                    return true;

            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.cart,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.cart:
                Intent i= new Intent(getBaseContext(),ShoppingCart.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
