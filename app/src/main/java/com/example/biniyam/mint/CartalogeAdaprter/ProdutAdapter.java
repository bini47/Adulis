package com.example.biniyam.mint.CartalogeAdaprter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biniyam.mint.Common.Common;
import com.example.biniyam.mint.Interface.IItemClickListner;
import com.example.biniyam.mint.Model.Product.Product;
import com.example.biniyam.mint.R;
import com.example.biniyam.mint.SingleProduct;

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

        System.out.println( products.get(i).getPname().toString());
        holder.pname.setText(Common.formatString(products.get(i).getPname()));
        holder.price.setText(new StringBuilder( products.get(i).getPrice()).append("Birr"));


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
