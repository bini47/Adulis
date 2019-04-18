package com.example.biniyam.mint.Common;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.biniyam.mint.Model.User.User.User;
import com.example.biniyam.mint.Retrofit.AdulisApi;
import com.example.biniyam.mint.login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentUser {

    private Context context;
    AdulisApi adulisApi;


    public CurrentUser(Context context) {
        this.context = context;
        adulisApi = Common.getApi();

    }

    public void getCurrentUser(String userToken){
        //GET THE USER TOKEN

        Call<User> call = adulisApi.getCurrent(userToken);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    //DECODING THE USER PROFILE
                    try{
                        Toast.makeText(context, response.body().getFirstname()+ " "
                                +response.body().getLastname() , Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(context, "Wrong credentials: "+ Common.currentUsertoken, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    public String getToken() {
        SharedPreferences token = context.getSharedPreferences("com.example.biniyam.mint", Context.MODE_PRIVATE);
       return token.getString("token","");


    }
}
