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

public class Notification extends Fragment {

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

        rootView = inflater.inflate(R.layout.notification_layout, container, false);


        recyclerView= (RecyclerView) rootView.findViewById(R.id.notification_recycler);










        iconsId.add(R.drawable.ic_delete);
        iconsId.add(R.drawable.ic_update);
        iconsId.add(R.drawable.ic_add_image);
        iconsId.add(R.drawable.ic_clerance_sell);
        iconsId.add(R.drawable.ic_update);
        iconsId.add(R.drawable.ic_add_image);
        iconsId.add(R.drawable.ic_clerance_sell);




        cardBackground.add("#1565c0");
        cardBackground.add("#00838F");
        cardBackground.add("#006064");
        cardBackground.add("#3F51B5");
        cardBackground.add("#0277BD");
        cardBackground.add("#607D8B");
        cardBackground.add("#00838F");






        desc.add("this is the discripton part for all orocash agent to provide the user additional information");
        desc.add("You can easily withdraw cash from your oroagent account by contacting yor agent ");
        desc.add("It is a process of buying an air time either for yourself or another phone through USSD/Mobile channel ");
        desc.add("It's a process of paying bill by providing the Bill reference");
        desc.add("this is the discripton part for all orocash agent to provide the user additional information");
        desc.add("You can easily withdraw cash from your oroagent account by contacting yor agent ");
        desc.add("It is a process of buying an air time either for yourself or another phone through USSD/Mobile channel ");



        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter =new MyAdapter(getContext(),desc,iconsId,cardBackground);
        recyclerView.setAdapter(adapter);


        return rootView;

    }
}
