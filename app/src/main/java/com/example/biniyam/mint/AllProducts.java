package com.example.biniyam.mint;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.biniyam.mint.CartalogeAdaprter.ProdutAdapter;
import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Model.Product.Product;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import java.util.List;

import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AllProducts  extends Fragment {

    View rootView;
    AdulisApi adulisApi;
    RecyclerView product_recycler;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    SwipeRefreshLayout refresh;
     AlertDialog alertDialog;
    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.all_products_layout, container, false);

         adulisApi = Common.getApi();
        //get extra string
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String i = bundle.getString("cata", "");
            Toast.makeText(getContext(), i, Toast.LENGTH_SHORT).show();
        }

            //PRE-LOADER
         alertDialog= new
         SpotsDialog.Builder().setContext(getContext()).build();
         alertDialog.setTitle("Please wait...");


         //init view
         product_recycler = (RecyclerView)rootView.findViewById(R.id.product_recycler);
        product_recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        product_recycler.setHasFixedSize(true);

         refresh= (SwipeRefreshLayout)rootView.findViewById(R.id.refresh);
         refresh.setColorSchemeResources(R.color.colorAccent,
                 android.R.color.holo_green_dark,
                 android.R.color.holo_blue_dark,
                 android.R.color.holo_orange_dark);

         refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
             @Override
             public void onRefresh() {
                 if(Common.isConnectedToInternet(getContext())){
                     fetchProducts();
                 }
                 else{
                     Toast.makeText(getContext(), "cannot connect to internet", Toast.LENGTH_SHORT).show();
                 }
             }
         });

     refresh.post(new Runnable() {
         @Override
         public void run() {
             //TODO: UNCOMENT THIS WHEN YOU UPLAOD IT TO HEROKU
             /*if(Common.isConnectedToInternet(getContext())){*/
                 fetchProducts();
           //  }
            /* else{
                 //TODO: make an individual view for this
                 Toast.makeText(getContext(), "cannot connect to internet", Toast.LENGTH_SHORT).show();
             }*/
         }
     });


        return rootView;

    }

    private void fetchProducts() {

      //  alertDialog.show();
        compositeDisposable.add(adulisApi.getProducts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
                new Consumer<List<Product>>() {
                    @Override
                    public void accept(List<Product> products) throws Exception {
                       refresh.setRefreshing(false);
                       alertDialog.hide();
                        displayProductList(products);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        refresh.setRefreshing(false);
                        //TODO: convert this toa modified view
                        Toast.makeText(getContext(), throwable +" Error while loading products", Toast.LENGTH_SHORT).show();
                    }
                }));




}

    private void displayProductList(List<Product> products) {
        ProdutAdapter adapter = new ProdutAdapter(getContext(), products);
        product_recycler.setAdapter(adapter);
    }
    }