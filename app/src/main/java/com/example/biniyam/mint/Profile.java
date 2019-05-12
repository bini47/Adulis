package com.example.biniyam.mint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Common.CurrentUser;
import com.example.biniyam.mint.OrderAdapter.MyAdapter;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends Fragment {


    TextView name, email, role;
    LinearLayoutManager linearLayoutManager;
    MyAdapter adapter;
    View rootView;
    AdulisApi adulisApi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    CurrentUser currentUser;
    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            rootView = inflater.inflate(R.layout.fragment_profile, container, false);

            //init views
        name=(TextView)rootView.findViewById(R.id.name);
        email=(TextView)rootView.findViewById(R.id.email);
        role=(TextView)rootView.findViewById(R.id.role);


            adulisApi = Common.getApi();
            currentUser = new CurrentUser(getContext());
            String token = currentUser.getToken();
            if (token.equals("")) {
                //TODO: SEND ERROR DATA TO LOGIN VIEW
                    //fragment.finish()
            }
            getProfile(token);

            return rootView;

    }

    private void getProfile(String authToken) {
        Call<com.example.biniyam.mint.Model.User.Profile.Profile> call = adulisApi.getProfile(authToken);
        call.enqueue(new Callback<com.example.biniyam.mint.Model.User.Profile.Profile>() {
            @Override
            public void onResponse(Call<com.example.biniyam.mint.Model.User.Profile.Profile> call, Response<com.example.biniyam.mint.Model.User.Profile.Profile> response) {
                try {
                    Toast.makeText(getContext(), response.body().getPhone(), Toast.LENGTH_SHORT).show();
                    StringBuilder names= new StringBuilder(
                            response.body().getUser().getFirstname()+" "
                                    + response.body().getUser().getLastname()
                    );
                    name.setText(names);
                    email.setText(response.body().getUser().getEmail());
                    role.setText(response.body().getUser().getRole());

                }catch(NullPointerException e){
                    //TODO: CREATE PROFILE LAYOUT
                    Toast.makeText(getContext(), "profile is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<com.example.biniyam.mint.Model.User.Profile.Profile> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
