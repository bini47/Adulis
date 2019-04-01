package com.example.biniyam.mint.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IMyservice {
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
}
