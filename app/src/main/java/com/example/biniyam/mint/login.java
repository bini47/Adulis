package com.example.biniyam.mint;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biniyam.mint.Retrofit.AdulisApi;
import com.example.biniyam.mint.Retrofit.RetrofitClient;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class login extends AppCompatActivity {
    TextView bytes,sup,lin;
    EditText email,password;

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    AdulisApi adulisApi;

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //INIT SERVIE
        Retrofit retrofitClient= RetrofitClient.getInstance();
        adulisApi = retrofitClient.create(AdulisApi.class);


        email = (EditText) findViewById(R.id.usrusr);
        password = (EditText)findViewById(R.id.passwrd);
        lin = (TextView)findViewById(R.id.logiin);
        sup = (TextView)findViewById(R.id.sup);
        bytes = (TextView)findViewById(R.id.bytes);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/Lato-Light.ttf");
        bytes.setTypeface(custom_font);
        password.setTypeface(custom_font);
        sup.setTypeface(custom_font);
        lin.setTypeface(custom_font);
        email.setTypeface(custom_font);
        sup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(login.this,signup.class);
                startActivity(it);
            }
        });

        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 loginUser(email.getText().toString(),
                        password.getText().toString());
            }
        });
    }

    private void loginUser(String email, String password) {
        if(TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Email field is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)) {

            Toast.makeText(this, "password field is required", Toast.LENGTH_SHORT).show();
            return;
        }

        compositeDisposable.add(adulisApi.loginUser(email,password)
                .subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String res) throws Exception {
                        Toast.makeText(getBaseContext(), "success:"+ res, Toast.LENGTH_SHORT).show();
                    }
                }));

    }

}
