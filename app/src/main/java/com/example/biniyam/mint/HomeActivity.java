package com.example.biniyam.mint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.biniyam.mint.CartalogeAdaprter.MyCatalogue;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button comments;
    ImageButton dashboard;
    LinearLayout signup;
    SliderLayout sliderLayout;
    RecyclerView trendingRecycler, recomendedRecycler,featuredRecycler,topProducersresycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        signup= (LinearLayout) findViewById(R.id.toTheSignUp);
        comments= (Button)findViewById(R.id.toTheComments);
        dashboard=(ImageButton) findViewById(R.id.toTheDashboard);
        trendingRecycler=(RecyclerView) findViewById(R.id.trendingRecycler);
        recomendedRecycler=(RecyclerView) findViewById(R.id.recomendedRecycler);
        featuredRecycler=(RecyclerView) findViewById(R.id.featuredRecycler);
        topProducersresycler=(RecyclerView) findViewById(R.id.topproducersRecycler);

        sliderLayout= (SliderLayout)findViewById(R.id.slider);


        TextSliderView textSliderView1= new TextSliderView(this);
        TextSliderView textSliderView2= new TextSliderView(this);
        TextSliderView textSliderView3= new TextSliderView(this);


        textSliderView1.description("im commin").image(R.drawable.banner1).setScaleType(BaseSliderView.ScaleType.Fit);
        textSliderView2.description("no credit cards").image(R.drawable.banner).setScaleType(BaseSliderView.ScaleType.Fit);
        textSliderView3.description("jef bezos nightmare").image(R.drawable.banner3).setScaleType(BaseSliderView.ScaleType.Fit);
        sliderLayout.addSlider(textSliderView1);
        sliderLayout.addSlider(textSliderView2);
        sliderLayout.addSlider(textSliderView3);


        ArrayList<String> pnames= new ArrayList<>();
        ArrayList<String> price= new ArrayList<>();
        ArrayList<Integer> productPics= new ArrayList<>();
        ArrayList<Integer> rating= new ArrayList<>();




        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,login.class);
                startActivity(i);
            }
        });

        comments.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,Comments.class);
                startActivity(i);
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Dashboard.class);
                startActivity(i);
            }
        });

        pnames.add("hert shaped");
        pnames.add("workout tights");
        pnames.add("Mountain high tights");
        pnames.add("adidas shirt");
        pnames.add("coacsian shirt");
        pnames.add("work out tights");


        price.add("256");
        price.add("460");
        price.add("400");
        price.add("260");
        price.add("400");
        price.add("200");

        rating.add(3);
        rating.add(5);
        rating.add(2);
        rating.add(2);
        rating.add(4);
        rating.add(5);

        productPics.add(R.drawable.hert_haped_shirt);
        productPics.add(R.drawable.adidas_tight_with_packout);
        productPics.add(R.drawable.tight);
        productPics.add(R.drawable.packout_with_legs);
        productPics.add(R.drawable.huwaian_shirt);
        productPics.add(R.drawable.tight_);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager3= new LinearLayoutManager(getBaseContext(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.HORIZONTAL,false);
        trendingRecycler.setLayoutManager(linearLayoutManager);
        recomendedRecycler.setLayoutManager(linearLayoutManager2);
        featuredRecycler.setLayoutManager(linearLayoutManager3);
        topProducersresycler.setLayoutManager(linearLayoutManager4);

        MyCatalogue myCatalogue = new MyCatalogue(this,pnames,price,rating,productPics);
        trendingRecycler.setAdapter(myCatalogue);
        recomendedRecycler.setAdapter(myCatalogue);
        featuredRecycler.setAdapter(myCatalogue);
        topProducersresycler.setAdapter(myCatalogue);

        myCatalogue.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
