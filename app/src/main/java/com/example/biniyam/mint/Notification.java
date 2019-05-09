package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Common.CurrentUser;
import com.example.biniyam.mint.Model.Cart.MyCart;
import com.example.biniyam.mint.NotificationAdapter.MyNotifAdapter;
import com.example.biniyam.mint.Retrofit.AdulisApi;
import com.example.biniyam.mint.ShoppingCartAdapter.MyAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Notification extends Fragment {

    RecyclerView notificationHolder;
    MyNotifAdapter myNotifAdapter;
    View rootView;
    AdulisApi adulisApi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    CurrentUser currentUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_notification, container, false);
        notificationHolder=rootView.findViewById(R.id.notification_holder);

        adulisApi = Common.getApi();
        currentUser = new CurrentUser(getContext());
        String token = currentUser.getToken();
        if (token.equals("")) {
            //TODO: SEND ERROR DATA TO LOGIN VIEW
            //fragment.finish()
        }
        notificationHolder.setLayoutManager(new LinearLayoutManager(getContext()));
        getNotif(token);
        return rootView;
    }

    private void getNotif(String token) {
        compositeDisposable.add(adulisApi.getNotification(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<com.example.biniyam.mint.Model.Notification>>() {
                            @Override
                            public void accept(List<com.example.biniyam.mint.Model.Notification> notifications) throws Exception {

                                display(notifications);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable t) throws Exception {
                                Toast.makeText(getContext(),t.getMessage() , Toast.LENGTH_SHORT).show();
                            }
                        }

                ));
    }

    private void display(List<com.example.biniyam.mint.Model.Notification> notifications) {

        MyNotifAdapter  myNotifAdapter = new MyNotifAdapter(getContext(),notifications);
        notificationHolder.setAdapter(myNotifAdapter);

    }
}
