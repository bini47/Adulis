package com.example.biniyam.mint;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Model.Error.APIError;
import com.example.biniyam.mint.Model.Error.ErrorUtils;
import com.example.biniyam.mint.Model.User.User.User;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signup extends AppCompatActivity {
    TextInputEditText firstname,lastname,phone, email,password,password2;
    TextView login,signup;
    ImageView back;
    AdulisApi adulisApi;
    Button signupButton;
    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.sign_up_);

        adulisApi = Common.getApi();
            initViews();
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User(
                        firstname.getText().toString(),
                        lastname.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString(),
                        password2.getText().toString()

                );
                registerUser(user);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup.super.finish();
            }
        });


    }

    private void initViews() {

        firstname = (TextInputEditText)findViewById(R.id.firstname_txt);
        lastname = (TextInputEditText)findViewById(R.id.lastname_txt);
        phone = (TextInputEditText)findViewById(R.id.phone);
        email = (TextInputEditText)findViewById(R.id.emailEditText);
        password = (TextInputEditText)findViewById(R.id.passwordEditText);
        password2 = (TextInputEditText)findViewById(R.id.passwordEditText2);
        signupButton= (Button)findViewById(R.id.signupButton);
        back= (ImageView) findViewById(R.id.back);
    }

    private void registerUser(User user) {
        Call<User> call = adulisApi.register(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful())
                Toast.makeText(signup.this, response.body().getFirstname()+ " registered", Toast.LENGTH_SHORT).show();
                else{
                    //TODO: THIS SHIT DIDN'T WORK - HANDLE ERRORS
                    APIError error = ErrorUtils.parseError(response);
                    Toast.makeText(signup.this, error.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(signup.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}