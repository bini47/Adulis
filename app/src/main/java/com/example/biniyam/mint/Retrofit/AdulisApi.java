package com.example.biniyam.mint.Retrofit;

import com.example.biniyam.mint.Model.Cart.CartRoot;
import com.example.biniyam.mint.Model.Cart.MyCart;
import com.example.biniyam.mint.Model.Notification;
import com.example.biniyam.mint.Model.Order.Order;
import com.example.biniyam.mint.Model.Product.Cart;
import com.example.biniyam.mint.Model.Product.Checkout;
import com.example.biniyam.mint.Model.Product.Comment;
import com.example.biniyam.mint.Model.Product.Product;
import com.example.biniyam.mint.Model.Product.SingleProduct;
import com.example.biniyam.mint.Model.User.Profile.Profile;
import com.example.biniyam.mint.Model.User.User.Login;
import com.example.biniyam.mint.Model.User.User.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AdulisApi {
 @POST("/user/register")
    Call<User> register(@Body User user);

    @POST("/user/login")
    Call<User> loginUser(@Body Login login);

    @GET("/user/current")
    Call<User> getCurrent(@Header("Authorization") String authToken);

    @GET("/mobile-api/products")
    Observable<List<Product>> getProducts();


    @GET("/mobile-api/product/{id}")
    Call<SingleProduct> getSingleProduct(@Path("id")String pid);

    @GET("/mobile-api/add-to-cart/{id}")
    Observable<Cart> addToCart(@Path("id")String pid);

    @GET("/mobile-api/cart-total-qty")
   Observable<String> getTotalCartAmount();

   @GET("/profile")
   Call<Profile> getProfile(@Header("Authorization") String authToken);


    @GET("/android-api/shopping-cart")
    Observable<List<MyCart>>  getCart();

    @GET("/notification")
    Observable<List<Notification>>  getNotification(@Header("Authorization") String authToken);

    @POST("/order")
    Call<Checkout> order(@Header("Authorization") String authTooken, @Body Checkout checkout);

    @POST("/product/{id}/comments")
    Call<Comment> comemnt(@Path("id")String pid, @Body Comment comment);

    @GET("/order/view")
    Observable<List<Order>> myOrders(@Header("Authorization") String authTooken);
}
