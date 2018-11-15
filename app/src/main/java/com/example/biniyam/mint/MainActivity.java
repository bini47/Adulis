package com.example.biniyam.mint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.biniyam.mint.CartalogeAdaprter.MyCatalogue;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button comments;
    ImageButton dashboard;
    LinearLayout signup;
    RecyclerView trendingRecycler, recomendedRecycler,featuredRecycler,topProducersresycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup= (LinearLayout) findViewById(R.id.toTheSignUp);
        comments= (Button)findViewById(R.id.toTheComments);
        dashboard=(ImageButton) findViewById(R.id.toTheDashboard);
        trendingRecycler=(RecyclerView) findViewById(R.id.trendingRecycler);
        recomendedRecycler=(RecyclerView) findViewById(R.id.recomendedRecycler);
        featuredRecycler=(RecyclerView) findViewById(R.id.featuredRecycler);
        topProducersresycler=(RecyclerView) findViewById(R.id.topproducersRecycler);

        ArrayList<String> pnames= new ArrayList<>();
        ArrayList<String> price= new ArrayList<>();
        ArrayList<Integer> productPics= new ArrayList<>();
        ArrayList<Integer> rating= new ArrayList<>();




        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });

        comments.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Comments.class);
                startActivity(i);
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Dashboard.class);
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
}
