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
import android.widget.Toast;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Model.Cart.CartRoot;
import com.example.biniyam.mint.Model.Cart.MyCart;
import com.example.biniyam.mint.Model.Product.Product;
import com.example.biniyam.mint.R;

import java.util.ArrayList;
import java.util.List;

class   CommentsAdapter extends RecyclerView.ViewHolder{


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
    Context context;
    List<MyCart> cartRoots;

    public MyAdapter(Context context, List<MyCart> cartRoots) {
        this.context = context;
        this.cartRoots = cartRoots;
    }

    @NonNull
    @Override
    public CommentsAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_shopping_cart, viewGroup, false);

        return new CommentsAdapter(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter holder, int i) {

        String price= String.valueOf(cartRoots.get(i).getPrice());
        String qty = String.valueOf(cartRoots.get(i).getQty());
        holder.title.setText(Common.formatStringCart(cartRoots.get(i).getItem().getPname()));

        holder.price.setText(new StringBuilder (price).append("Birr"));
        holder.amount.setText(qty);
        holder.image.setImageDrawable(BgCenter(R.drawable.img_plant_6));

    }

    @Override
    public int getItemCount() {
        return cartRoots.size();
    }
    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);


        return  bgDrawable;

    }

}