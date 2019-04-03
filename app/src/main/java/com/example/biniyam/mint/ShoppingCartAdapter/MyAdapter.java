package com.example.biniyam.mint.ShoppingCartAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biniyam.mint.R;

import java.util.ArrayList;

class CommentsAdapter extends RecyclerView.ViewHolder{


    protected ImageView image;
    protected TextView amount, title,price;

    public CommentsAdapter(@NonNull View itemView) {
        super(itemView);

       image= (ImageView) itemView.findViewById(R.id.image);
       amount=(TextView) itemView.findViewById(R.id.amount);
       title=(TextView) itemView.findViewById(R.id.title);
       price=(TextView) itemView.findViewById(R.id.price);


    }


}

public class MyAdapter extends RecyclerView.Adapter<CommentsAdapter> {

    private Context context;
    private ArrayList<String> titles;
    private ArrayList<String> price;
    private LayoutInflater inflater;
    private ArrayList<Integer> images;
    private ArrayList<String> amounts;

    public MyAdapter(Context context, ArrayList<String> titles, ArrayList<String> price, ArrayList<Integer> images, ArrayList<String> amounts) {
        this.context = context;
        this.titles = titles;
        this.price = price;
        this.images = images;
        this.amounts = amounts;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CommentsAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = inflater.inflate(R.layout.item_shopping_cart, viewGroup, false);

        return new CommentsAdapter(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter holder, int i) {


        holder.title.setText(titles.get(i));
        holder.price.setText(price.get(i));
        holder.amount.setText(amounts.get(i));
        holder.image.setImageDrawable(BgCenter(images.get(i)));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);


        return  bgDrawable;

    }

}