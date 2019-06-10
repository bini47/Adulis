package com.example.biniyam.mint.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.biniyam.mint.Model.Cart.MyCart;
import com.example.biniyam.mint.Model.Product.Comment;
import com.example.biniyam.mint.R;

import java.util.ArrayList;
import java.util.List;

class CommentsAdapter extends RecyclerView.ViewHolder{


    protected TextView username, content;
    protected ImageView profilePic;

    public CommentsAdapter(@NonNull View itemView) {
        super(itemView);

       username= (TextView) itemView.findViewById(R.id.comment_username);
       content=(TextView) itemView.findViewById(R.id.comment_content);
       profilePic=(ImageView) itemView.findViewById(R.id.comment_prifile_pic);


    }


}
public class MyAdapter extends RecyclerView.Adapter<CommentsAdapter> {
    Context context;
    List<Comment> comment;

    public MyAdapter(Context context, List<Comment> comment) {
        this.context = context;
        this.comment = comment;
    }

    @NonNull
    @Override
    public CommentsAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.comment_single, viewGroup, false);


        return new CommentsAdapter(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter holder, int i) {


        holder.username.setText(comment.get(i).getAuthor());
        holder.content.setText(comment.get(i).getText());
        holder.profilePic.setImageDrawable(BgCenter(R.drawable.user_3));
    }

    @Override
    public int getItemCount() {
        return comment.size();
    }
    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);


        return  bgDrawable;

    }

}