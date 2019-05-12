package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Common.CurrentUser;
import com.example.biniyam.mint.Model.Notification;
import com.example.biniyam.mint.OrderAdapter.MyAdapter;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Order extends Fragment {

    ListView listView;
    ArrayList<String> title= new ArrayList<>();
    ArrayList<String> desc= new ArrayList<>();
    ArrayList<Class>activityClasses= new ArrayList<>();
    ArrayList<Integer>iconsId= new ArrayList<>();
    ArrayList<String>cardBackground= new ArrayList<>();
    ArrayList<String>siteId= new ArrayList<>();
    RecyclerView recyclerView;
    CurrentUser currentUser;
    LinearLayoutManager linearLayoutManager;
    MyAdapter adapter;
    AdulisApi adulisApi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    View rootView;
    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.order_layout, container, false);

        adulisApi = Common.getApi();
        recyclerView= (RecyclerView) rootView.findViewById(R.id.notification_recycler);

        currentUser = new CurrentUser(getContext());
        String token = currentUser.getToken();
        if (token.equals("")) {
            //TODO: SEND ERROR DATA TO LOGIN VIEW
            //fragment.finish()
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getOrders(token);





        return rootView;

    }

    private void getOrders(String token) {
        compositeDisposable.add(adulisApi.myOrders(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<com.example.biniyam.mint.Model.Order.Order>>() {
                            @Override
                            public void accept(List<com.example.biniyam.mint.Model.Order.Order> orders) throws Exception {


                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable t) throws Exception {
                                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        )
        );

    }


    private void displayMyOrders(List<com.example.biniyam.mint.Model.Order.Order> orders) {
        adapter =new MyAdapter(getContext(),orders);
        recyclerView.setAdapter(adapter);
    }
}
