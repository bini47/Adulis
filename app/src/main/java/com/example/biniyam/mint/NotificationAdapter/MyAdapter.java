package com.example.biniyam.mint.NotificationAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biniyam.mint.Interface.ItemClickListner;
import com.example.biniyam.mint.R;


import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by voodoo on 2/28/2018.
 */

class AdapteHOlder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{


    private ItemClickListner itemClickListner;
    TextView  desc;
    ImageView icon;
    CardView card;

    public AdapteHOlder(View itemView) {
        super(itemView);

        desc=(TextView) itemView.findViewById(R.id.desc);
        icon=(ImageView)itemView.findViewById(R.id.icon);
        card=(CardView) itemView.findViewById(R.id.background_card);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }
    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view, getAdapterPosition(), false);


    }

    @Override
    public boolean onLongClick(View view) {

        itemClickListner.onClick(view, getAdapterPosition(), true);
        return true;

    }
}

public class MyAdapter extends RecyclerView.Adapter<AdapteHOlder> {

    private Context context;
    private ArrayList<String> descriptions;
    private ArrayList<Integer> images;
    private LayoutInflater inflater;

    ArrayList<String> cardBackground;



    public MyAdapter(Context context,  ArrayList<String> descriptions,
                     ArrayList<Integer> images,  ArrayList<String> cardBackground) {
        this.context = context;

        this.descriptions = descriptions;
        this.images = images;
        inflater=LayoutInflater.from(context);
        this.cardBackground=cardBackground;
    }


    @Override
    public AdapteHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.notification_content, parent, false);

        return new AdapteHOlder(itemview);
    }

    @Override
    public void onBindViewHolder(AdapteHOlder holder, int position) {


        holder.desc.setText(descriptions.get(position));
        holder.icon.setImageDrawable(BgCenter(images.get(position)));
        holder.card.setCardBackgroundColor(Color.parseColor(cardBackground.get(position)));

        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick) {



                        //TODO: notification on click


                }


            }
        });



    }
    @Override
    public int getItemCount() {
        return descriptions.size();
    }

    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);

        //bgDrawable.setColorFilter(new PorterDuffColorFilter(Color., PorterDuff.Mode.SRC_ATOP));
        return  bgDrawable;

    }
}
