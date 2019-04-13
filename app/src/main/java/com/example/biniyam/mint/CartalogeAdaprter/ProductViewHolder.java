package com.example.biniyam.mint.CartalogeAdaprter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biniyam.mint.Interface.IItemClickListner;
import com.example.biniyam.mint.Interface.ItemClickListner;
import com.example.biniyam.mint.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView product_image;
    TextView pname,price,
     priceDiscount;

    IItemClickListner itemClickListner;

    public void setItemClickListner(IItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        product_image =(ImageView)itemView.findViewById(R.id.product_img);
        pname= (TextView) itemView.findViewById(R.id.txt_pnmae);
        price= (TextView) itemView.findViewById(R.id.price);
        priceDiscount= (TextView) itemView.findViewById(R.id.price_discount);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        itemClickListner.onClick(view);
    }
}
