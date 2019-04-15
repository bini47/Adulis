package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Model.Product.Cart;
import com.example.biniyam.mint.Model.Product.Product;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleProduct extends AppCompatActivity {

    TextView title,price,releseDate,stoke,description,catagory,tags;
    AdulisApi adulisApi;
    SliderLayout slider;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    LinearLayout addToCart;//TODO: CHANGE THIS TO MATERIAL LAYOUT

    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adulisApi = Common.getApi();

        //init views
        slider = (SliderLayout) findViewById(R.id.slider);
        title= (TextView)findViewById(R.id.title);
        price= (TextView)findViewById(R.id.price);
        releseDate= (TextView)findViewById(R.id.date);
        stoke= (TextView)findViewById(R.id.stoke_status);
        description= (TextView)findViewById(R.id.description);
        catagory= (TextView)findViewById(R.id.category);
        addToCart= (LinearLayout)findViewById(R.id.lyt_add_cart);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProductToCart( Common.currentProductId);
            }
        });

        TextSliderView textSliderView1 = new TextSliderView(this);
        TextSliderView textSliderView2 = new TextSliderView(this);
        TextSliderView textSliderView3 = new TextSliderView(this);

        textSliderView1.description("im commin").image(R.drawable.banner1).setScaleType(BaseSliderView.ScaleType.Fit);
        textSliderView2.description("no credit cards").image(R.drawable.banner).setScaleType(BaseSliderView.ScaleType.Fit);
        textSliderView3.description("jef bezos nightmare").image(R.drawable.banner3).setScaleType(BaseSliderView.ScaleType.Fit);
        slider.addSlider(textSliderView1);
        slider.addSlider(textSliderView2);
        slider.addSlider(textSliderView3);

        //TODO: ADD THIS TO SWIPE REFRESH LAYOUT
        fetchProduct(Common.currentProductId);
    }

    private void addProductToCart(String id) {
        String sid="s%3ALbeHWp4NrEI-TcYTqpjGe3YGOqdjZU3S.IP62nRXNcWjR%2F8AUO5gKFNDcdhOINiaxNQn%2FxlMrF0s";
        compositeDisposable.add(adulisApi.addToCart(id, sid )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<Cart>() {
                            @Override
                            public void accept(Cart cart) throws Exception {
                                Toast.makeText(SingleProduct.this, String.valueOf(cart.getTotalPrice()), Toast.LENGTH_SHORT).show();

                            }

                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Toast.makeText(SingleProduct.this,throwable.getMessage() , Toast.LENGTH_SHORT).show();

                            }
                        }));
    }

    private void fetchProduct(String id) {

        Call<com.example.biniyam.mint.Model.Product.SingleProduct> call= adulisApi.getSingleProduct(id);
        call.enqueue(new Callback<com.example.biniyam.mint.Model.Product.SingleProduct>() {
            @Override
            public void onResponse(Call<com.example.biniyam.mint.Model.Product.SingleProduct> call, Response<com.example.biniyam.mint.Model.Product.SingleProduct> response) {
                response.body();
                title.setText(response.body().product.getPname());
                price.setText(response.body().product.getPrice());
                description.setText(response.body().product.getDescription());
                catagory.setText(response.body().product.getDepartment().department);
                 //STOKE LOGIC
                int stokeamount= response.body().product.getStokeamount();
                if(stokeamount <10){
                    stoke.setText("only "+String.valueOf(stokeamount)+" left");
                    //TODO: MAKE THE TEXT orange

                }
                else if(stokeamount >=10)
                    stoke.setText("IN STOKE");

                else
                    {
                  //TODO: MAKE THE TEXT RED
                    stoke.setText("Out of stoke STOKE");
                }


            }

            @Override
            public void onFailure(Call<com.example.biniyam.mint.Model.Product.SingleProduct> call, Throwable t) {
                Toast.makeText(SingleProduct.this, "Error while loading data", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
