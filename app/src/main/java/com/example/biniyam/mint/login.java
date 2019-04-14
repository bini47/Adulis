package com.example.biniyam.mint;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Model.User.User.Login;
import com.example.biniyam.mint.Model.User.User.User;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class login extends AppCompatActivity {

    private ImageView bookIconImageView;
    private TextView bookITextView,WelcomeTextView,readITogetherTextView,sign_up,forget_pass,skipTextView;
    private ProgressBar loadingProgressBar;
    private RelativeLayout rootView, afterAnimationView;
    private TextInputEditText emailEditText, passwordEditText;
    private Button loginButton;
    AdulisApi adulisApi;
    ImageView back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_);

        initViews();
        initAnims();
        adulisApi = Common.getApi();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.super.finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInUser( emailEditText.getText().toString(),
                        passwordEditText.getText().toString());

            }
        });

        final int colorFrom = getResources().getColor(R.color.colorBackground);
        int colorTo = getResources().getColor(R.color.colorSplashText);

        skipTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this, signup.class);
                startActivity(i);
            }
        });
        final ValueAnimator colorAnimation= ValueAnimator.ofObject(new ArgbEvaluator(),colorFrom,colorTo);
        colorAnimation.setDuration(600);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                rootView.setBackgroundColor((int) valueAnimator.getAnimatedValue());

            }
        });


        new CountDownTimer(1500, 1000) {

            @Override
            public void onTick(long millisUntilDone) {


            }

            @Override
            public void onFinish() {

                animateViews();
                bookITextView.setVisibility(GONE);
                loadingProgressBar.setVisibility(GONE);
                //view smooth animation

                colorAnimation.start();
                bookIconImageView.setImageResource(R.drawable.ic_action_plus);
                startAnimation();
            }
        }.start();
    }

    private void getUser(String userToken) {
            //GET THE USER TOKEN
        Call<User> call = adulisApi.getCurrent(userToken);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    //DECODING THE USER PROFILE
                    try{
                    Toast.makeText(login.this, response.body().getFirstname()+ " "
                            +response.body().getLastname() , Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.printStackTrace();
                }
                }
                else{
                    Toast.makeText(login.this, "Wrong credentials: "+ Common.currentUsertoken, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void logInUser(String email, String password) {
        Login login = new Login( email,password);
        Call<User> call = adulisApi.loginUser(login);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    //GET THE USERS TOKEN BARYER AND SEND IT TO THE DECODING ROUTE
                    try{
                        //TODO: STORE THIS TOKEN IN A SHAREDPRFERENCE
                    Common.currentUsertoken = response.body().getToken();
                    getUser(response.body().getToken());
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(login.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void animateViews() {
        WelcomeTextView.animate().translationYBy(-100f).alpha(1f).setDuration(1000);
        readITogetherTextView.animate().translationYBy(-100f).alpha(1f).setDuration(1100);
        emailEditText.animate().translationYBy(-100f).alpha(1f).setDuration(1200);
        passwordEditText.animate().translationYBy(-100f).alpha(1f).setDuration(1300);
        sign_up.animate().translationYBy(-100f).alpha(1f).setDuration(1400);
        forget_pass.animate().translationYBy(-100f).alpha(1f).setDuration(1400);
        passwordEditText.animate().translationYBy(-100f).alpha(1f).setDuration(1500);
        loginButton.animate().translationYBy(-100f).alpha(1f).setDuration(1600);
        skipTextView.animate().translationYBy(-100f).alpha(1f).setDuration(1700);
    }

    private void initAnims() {
        WelcomeTextView.setTranslationY(100f);
        WelcomeTextView.setAlpha(0f);
        readITogetherTextView.setTranslationY(100f);
        readITogetherTextView.setAlpha(0f);
        emailEditText.setTranslationY(100f);
        emailEditText.setAlpha(0f);
        passwordEditText.setTranslationY(100f);
        passwordEditText.setAlpha(0f);
        sign_up.setTranslationY(100f);
        sign_up.setAlpha(0f);
        forget_pass.setTranslationY(100f);
        forget_pass.setAlpha(0f);
        loginButton.setTranslationY(100f);
        loginButton.setAlpha(0f);
        skipTextView.setTranslationY(100f);
        skipTextView.setAlpha(0f);

    }

    private void initViews() {
        bookIconImageView = findViewById(R.id.logo);
        bookITextView = findViewById(R.id.bookITextView);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        rootView = findViewById(R.id.rootView);
        afterAnimationView = findViewById(R.id.afterAnimationView);
        WelcomeTextView= findViewById(R.id.WelcomeTextView);
        readITogetherTextView= findViewById(R.id.readItTogetherTextView);
        emailEditText=findViewById(R.id.emailEditText);
        passwordEditText=findViewById(R.id.passwordEditText);
        sign_up=findViewById(R.id.sign_up);
        forget_pass=findViewById(R.id.forget_pass);
        loginButton=findViewById(R.id.loginButton);
        skipTextView=findViewById(R.id.skipTextView);
        back= (ImageView) findViewById(R.id.back);


    }

    private void startAnimation() {
        ViewPropertyAnimator viewPropertyAnimator = bookIconImageView.animate();
        viewPropertyAnimator.x(50f);
        viewPropertyAnimator.y(100f);
        viewPropertyAnimator.setDuration(600);
        ObjectAnimator scaleDownx=ObjectAnimator.ofFloat(bookIconImageView,"scaleX",0.5f);
        ObjectAnimator scaleDowny=ObjectAnimator.ofFloat(bookIconImageView,"scaleY",0.5f);
        scaleDownx.setDuration(600);
        scaleDowny.setDuration(600);

        AnimatorSet sscaleDown = new AnimatorSet();
        sscaleDown.play(scaleDownx).with(scaleDowny);
        sscaleDown.start();
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                afterAnimationView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
