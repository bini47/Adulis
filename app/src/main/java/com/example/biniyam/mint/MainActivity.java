package com.example.biniyam.mint;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.biniyam.mint.CartalogeAdaprter.MyCatalogue;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private BottomNavigationView bottomnav;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




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
                    loadFragment(new HomeActivity());
                    return true;
                case R.id.dashboard_nav:

                    loadFragment(new Shop());
                    return true;
                case R.id.order_nav:

                    loadFragment(new Notification());
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
