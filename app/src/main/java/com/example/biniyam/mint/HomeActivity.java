package com.example.biniyam.mint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.biniyam.mint.CartalogeAdaprter.MyCatalogue;

import java.util.ArrayList;

public class HomeActivity extends Fragment {

    Button comments;
    ImageButton dashboard;
    LinearLayout signup;
    SliderLayout sliderLayout;
    RecyclerView trendingRecycler, recomendedRecycler, featuredRecycler, topProducersresycler;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.content_home, container, false);


        signup = (LinearLayout) rootView.findViewById(R.id.toTheSignUp);
        comments = (Button) rootView.findViewById(R.id.toTheComments);
        dashboard = (ImageButton) rootView.findViewById(R.id.toTheDashboard);
        trendingRecycler = (RecyclerView) rootView.findViewById(R.id.trendingRecycler);
        recomendedRecycler = (RecyclerView) rootView.findViewById(R.id.recomendedRecycler);
        featuredRecycler = (RecyclerView) rootView.findViewById(R.id.featuredRecycler);
        topProducersresycler = (RecyclerView) rootView.findViewById(R.id.topproducersRecycler);

        sliderLayout = (SliderLayout) rootView.findViewById(R.id.slider);


        TextSliderView textSliderView1 = new TextSliderView(getContext());
        TextSliderView textSliderView2 = new TextSliderView(getContext());
        TextSliderView textSliderView3 = new TextSliderView(getContext());


        textSliderView1.description("im commin").image(R.drawable.banner1).setScaleType(BaseSliderView.ScaleType.Fit);
        textSliderView2.description("no credit cards").image(R.drawable.banner).setScaleType(BaseSliderView.ScaleType.Fit);
        textSliderView3.description("jef bezos nightmare").image(R.drawable.banner3).setScaleType(BaseSliderView.ScaleType.Fit);
        sliderLayout.addSlider(textSliderView1);
        sliderLayout.addSlider(textSliderView2);
        sliderLayout.addSlider(textSliderView3);


        ArrayList<String> pnames = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();
        ArrayList<Integer> productPics = new ArrayList<>();
        ArrayList<Integer> rating = new ArrayList<>();



        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),login.class);
                startActivity(i);
            }
        });


        comments.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Comments.class);
                startActivity(i);
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Dashboard.class);
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


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        trendingRecycler.setLayoutManager(linearLayoutManager);
        recomendedRecycler.setLayoutManager(linearLayoutManager2);
        featuredRecycler.setLayoutManager(linearLayoutManager3);
        topProducersresycler.setLayoutManager(linearLayoutManager4);

        MyCatalogue myCatalogue = new MyCatalogue(getContext(), pnames, price, rating, productPics);
        trendingRecycler.setAdapter(myCatalogue);
        recomendedRecycler.setAdapter(myCatalogue);
        featuredRecycler.setAdapter(myCatalogue);
        topProducersresycler.setAdapter(myCatalogue);

        myCatalogue.notifyDataSetChanged();

        return rootView;
    }






}
