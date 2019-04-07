package com.example.biniyam.mint.Retrofit;

import com.example.biniyam.mint.Model.Product.Product;
import com.example.biniyam.mint.Model.Product.SingleProduct;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AdulisApi {
 @POST("/user/register")
    @FormUrlEncoded
    Observable<String> register(@Field("firstname") String firstname,
                                 @Field("lastname")String lastname,
                                 @Field("email") String email,
                                @Field("password") String password

                                );

    @POST("/user/login")
    @FormUrlEncoded
    Observable<String> loginUser(
                                @Field("email") String email,
                                @Field("password") String password

    );

    @GET("/mobile-api/products")
    Observable<List<Product>> getProducts();

    @GET("/add-to-cart/{id}")
    Observable<List<Product>> addToCart(@Path("id")String pid);

    @GET("/product/{id}")
    Call<SingleProduct> getSingleProduct(@Path("id")String pid);
}
