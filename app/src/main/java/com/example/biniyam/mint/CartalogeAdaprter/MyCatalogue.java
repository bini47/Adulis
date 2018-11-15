package com.example.biniyam.mint.CartalogeAdaprter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.biniyam.mint.R;

import java.util.ArrayList;

 class catalogueAdapter extends RecyclerView.ViewHolder {

    public ImageView productPic, rating[];
    public TextView pname, price;


    public catalogueAdapter(@NonNull View itemView) {
        super(itemView);

        productPic = (ImageView) itemView.findViewById(R.id.product_img);
        pname = (TextView) itemView.findViewById(R.id.pname);
        price = (TextView) itemView.findViewById(R.id.price);
        rating = new ImageView[5];
        rating[0] = (ImageView) itemView.findViewById(R.id.rating1);
        rating[1] = (ImageView) itemView.findViewById(R.id.rating2);
        rating[2] = (ImageView) itemView.findViewById(R.id.rating3);
        rating[3] = (ImageView) itemView.findViewById(R.id.rating4);
        rating[4] = (ImageView) itemView.findViewById(R.id.rating5);


    }
}

 public  class MyCatalogue extends RecyclerView.Adapter<catalogueAdapter> {
    @NonNull

    private Context context;
    private ArrayList<String> pnames;
    private ArrayList<String> price;
    private  ArrayList<Integer> rated;
    private ArrayList<Integer> pimg;
    private LayoutInflater inflater;

    public MyCatalogue(@NonNull Context context, ArrayList<String> pnames, ArrayList<String> price, ArrayList<Integer> rated, ArrayList<Integer> pimg) {
        this.context = context;
        this.pnames = pnames;
        this.price = price;
        this.rated = rated;
        this.pimg = pimg;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public catalogueAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = inflater.inflate(R.layout.catalogue_holder, viewGroup, false);

        return new catalogueAdapter(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull catalogueAdapter holder, int i) {

       // holder.productPic.setImageDrawable(pimg.get(i));
        holder.pname.setText(pnames.get(i));
        holder.price.setText(price.get(i));

        for (int k = 0; k < 5 ; k++) {
            holder.rating[k].setImageDrawable(BgCenter(R.drawable.star));
        }

         for (int j=0; j< rated.get(i);j++){
             holder.rating[j].setImageDrawable(BgCenter(R.drawable.star1));
         }



    }

    @Override
    public int getItemCount() {
        return pnames.size();
    }

    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);

        //bgDrawable.setColorFilter(new PorterDuffColorFilter(Color., PorterDuff.Mode.SRC_ATOP));
        return  bgDrawable;

    }
}




