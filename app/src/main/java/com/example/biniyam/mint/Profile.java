package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.biniyam.mint.NotificationAdapter.MyAdapter;

import java.util.ArrayList;

public class Profile extends Fragment {

    ListView listView;
    ArrayList<String> title= new ArrayList<>();
    ArrayList<String> desc= new ArrayList<>();
    ArrayList<Class>activityClasses= new ArrayList<>();
    ArrayList<Integer>iconsId= new ArrayList<>();
    ArrayList<String>cardBackground= new ArrayList<>();
    ArrayList<String>siteId= new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MyAdapter adapter;
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_profile, container, false);




        return rootView;

    }
}
