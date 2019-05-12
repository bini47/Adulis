package com.example.biniyam.mint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import  com.example.biniyam.mint.Adapter.*;
import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Common.CurrentUser;
import com.example.biniyam.mint.Model.Product.Checkout;
import com.example.biniyam.mint.Model.Product.Comment;
import com.example.biniyam.mint.Retrofit.AdulisApi;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Comments extends AppCompatActivity {

    Button comment;
    EditText text;
    CurrentUser currentUser;
    AdulisApi adulisApi;
    ArrayList<String> usenames= new ArrayList<>();
    ArrayList<String> contents= new ArrayList<>();
    ArrayList<Integer> profilePics= new ArrayList<>();
    RecyclerView recyclerView;

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        adulisApi = Common.getApi();
        recyclerView= (RecyclerView) findViewById(R.id.comment_recycler);
        comment=(Button)findViewById(R.id.comment);
        text=(EditText) findViewById(R.id.text);
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentUser = new CurrentUser(Comments.this);
                String token = currentUser.getToken();
                if(!token.equals("")){
                    String author = Common.CurrentUser;
                    String pid=Common.currentProductId;
                    Comment comment = new Comment(author,text.getText().toString());

                    pushComment(pid,comment);

                }

            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //fetchComment
        getComments();


    }


    private void getComments() {

        //setting adapter
        List<Comment> productComments = Common.currentProduct.getComments();
        loadComments(productComments);

    }

    private void loadComments(List<Comment> productComments) {
        MyAdapter adapter =new MyAdapter(Comments.this, productComments);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void pushComment(String pid,Comment comment) {
        Call<Comment> call = adulisApi.comemnt(pid,comment);
        call.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                Toast.makeText(Comments.this, "your comment has been published", Toast.LENGTH_SHORT).show();
                refreshComment(Common.currentProductId);
                getComments();
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                Toast.makeText(Comments.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void refreshComment(String pid) {

            Call<com.example.biniyam.mint.Model.Product.SingleProduct> call= adulisApi.getSingleProduct(pid);
            call.enqueue(new Callback<com.example.biniyam.mint.Model.Product.SingleProduct>() {
                @Override
                public void onResponse(Call<com.example.biniyam.mint.Model.Product.SingleProduct> call, Response<com.example.biniyam.mint.Model.Product.SingleProduct> response) {
                    response.body();
                    Common.currentProduct=response.body();

                }

                @Override
                public void onFailure(Call<com.example.biniyam.mint.Model.Product.SingleProduct> call, Throwable t) {
                    Toast.makeText(Comments.this, "Error while loading data", Toast.LENGTH_SHORT).show();
                }
            });


        }

    }

