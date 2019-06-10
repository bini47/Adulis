package com.example.biniyam.mint.CartalogeAdaprter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Interface.IItemClickListner;
import com.example.biniyam.mint.Model.Product.Product;
import com.example.biniyam.mint.R;
import com.example.biniyam.mint.SingleProduct;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProdutAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    Context context;
    List<Product> products;

    public ProdutAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.product_item, viewGroup, false);
        return new ProductViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int i) {

        //discount algorithm
        double discount= products.get(i).getDiscount();
        double price= Double.parseDouble(products.get(i).getPrice());
        //check if discount is not zero
        if(discount!=0){
            //if discount exists,  perform calculation
            discount=(discount/100)*price;
            //set the old price
            holder.price.setText(new StringBuilder(String.valueOf(price)).append("Birr"));
            //set price style to strike through
            holder.price.setPaintFlags(holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.price.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
            holder.priceDiscount.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            //set discount price to the new price
            holder.priceDiscount.setText( new StringBuilder(String.valueOf(discount)).append("Birr"));

        }
        else{

            //else set discount to empity string
            holder.priceDiscount.setText("");
            //set price to price
            holder.price.setText(new StringBuilder(String.valueOf(price)).append("Birr"));

        }
        Picasso.get().load(products.get(i).getImage()).into(holder.product_image);
        System.out.println( products.get(i).getPname().toString());
        holder.pname.setText(Common.formatString(products.get(i).getPname()));


        holder.setItemClickListner(new IItemClickListner() {
            @Override
            public void onClick(View v) {
                Common.currentProductId=products.get(i).get_id();

                context.startActivity(new Intent(context, SingleProduct.class));

            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
