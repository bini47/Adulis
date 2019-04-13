package com.example.biniyam.mint.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.biniyam.mint.Retrofit.AdulisApi;
import com.example.biniyam.mint.Retrofit.RetrofitClient;

import retrofit2.Retrofit;

public class Common {

    public static String currentProductId = null;
    public static String currentUsertoken=null;
    public static AdulisApi getApi(){
        return  RetrofitClient.getInstance().create(AdulisApi.class);
    }

    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null){
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if (info!=null)
            {
                for (int i =0; i<info.length; i++)
                    if(info[i].getState()==NetworkInfo.State.CONNECTED)
                        return true;
            }
        }
        return false;
    }

    public static String formatString(String pname) {
        //if character is to long, sub string
        StringBuilder result = new StringBuilder(pname.length() > 12 ? pname.substring(0,12)+ "...": pname);
        return  result.toString();
    }
}
