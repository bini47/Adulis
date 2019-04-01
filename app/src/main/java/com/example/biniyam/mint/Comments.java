package com.example.biniyam.mint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import  com.example.biniyam.mint.Adapter.*;
import java.util.ArrayList;

public class Comments extends AppCompatActivity {


    ArrayList<String> usenames= new ArrayList<>();
    ArrayList<String> contents= new ArrayList<>();
    ArrayList<Integer> profilePics= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.comment_recycler);


         usenames.add("kidd");
         usenames.add("Enzo");
         usenames.add("mame");

         contents.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras commodo varius vehicula. Mauris porta metus vitae nulla dignissim egestas. Aliquam sed molestie eros, in pharetra purus. Praesent consequat porta ");
         contents.add("viverra. Praesent gravida dapibus condimentum. Vestibulum vel lacus aliquet, laoreet mi eu, tempor est. Quisque volutpat finibus tristique. ");
         contents.add("Duis at nibh eget nulla pretium pretium. Quisque arcu sem, dignissim eu egestas quis, vulputate");

         profilePics.add(R.drawable.user_3);
         profilePics.add(R.drawable.user_5);
         profilePics.add(R.drawable.user_7);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyAdapter adapter =new MyAdapter(this,usenames,contents,profilePics);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
