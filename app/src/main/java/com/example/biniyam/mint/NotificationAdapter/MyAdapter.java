package com.example.biniyam.mint.NotificationAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biniyam.mint.Interface.ItemClickListner;
import com.example.biniyam.mint.Model.Notification;
import com.example.biniyam.mint.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by voodoo on 2/28/2018.
 */

class AdapteHOlder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{


    private ItemClickListner itemClickListner;
    protected TextView  subject,type,body;
    ImageView icon,sml_bage, sml_bg;
    CardView sml_icon;



    public AdapteHOlder(View itemView) {
        super(itemView);

        subject=(TextView) itemView.findViewById(R.id.subject);
        type=(TextView) itemView.findViewById(R.id.type);
        body=(TextView) itemView.findViewById(R.id.body);
        icon=(ImageView)itemView.findViewById(R.id.icon);
        sml_bage=(ImageView)itemView.findViewById(R.id.sml_bage);
        sml_bg=(ImageView)itemView.findViewById(R.id.sml_bg);



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
    List<Notification> notif;
    ArrayList<String> cardBackground;



    public MyAdapter(Context context, List<Notification> notif) {
        this.context = context;

        this.notif=notif;
        inflater=LayoutInflater.from(context);

    }


    @Override
    public AdapteHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.order_content, parent, false);

        return new AdapteHOlder(itemview);
    }

    @Override
    public void onBindViewHolder(AdapteHOlder holder, int i) {

        Toast.makeText(context, notif.get(i).getType(), Toast.LENGTH_SHORT).show();
        holder.subject.setText(notif.get(i).getSubject());
        holder.type.setText(notif.get(i).getType());
        holder.body.setText("heeey");


        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick) {



                }


            }
        });



    }
    @Override
    public int getItemCount() {
        return notif.size();
    }

    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);

        //bgDrawable.setColorFilter(new PorterDuffColorFilter(Color., PorterDuff.Mode.SRC_ATOP));
        return  bgDrawable;

    }
}
