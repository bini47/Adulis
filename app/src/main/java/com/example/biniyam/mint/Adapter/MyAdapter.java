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

import com.example.biniyam.mint.R;

import java.util.ArrayList;

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

    private Context context;
    private ArrayList<String> usernames;
    private ArrayList<String> contents;
    private LayoutInflater inflater;
    private ArrayList<Integer> profilePics;

    public MyAdapter(Context context, ArrayList<String> usernames, ArrayList<String> contents,ArrayList<Integer> profilePics) {
        this.context = context;
        this.usernames = usernames;
        this.contents = contents;
        inflater=LayoutInflater.from(context);
        this.profilePics = profilePics;
    }

    @NonNull
    @Override
    public CommentsAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = inflater.inflate(R.layout.comment_single, viewGroup, false);

        return new CommentsAdapter(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter holder, int i) {


        holder.username.setText(usernames.get(i));
        holder.content.setText(contents.get(i));
        holder.profilePic.setImageDrawable(BgCenter(profilePics.get(i)));
    }

    @Override
    public int getItemCount() {
        return usernames.size();
    }
    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);


        return  bgDrawable;

    }

}