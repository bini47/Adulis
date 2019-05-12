package com.example.biniyam.mint.NotificationAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biniyam.mint.Model.Cart.MyCart;
import com.example.biniyam.mint.Model.Notification;
import com.example.biniyam.mint.R;

import java.util.List;

class AdapterHolder extends RecyclerView.ViewHolder{


    protected TextView  subject,type,body;
    ImageView icon,sml_bage, sml_bg;
    CardView sml_icon;

    public AdapterHolder(@NonNull View itemView) {
        super(itemView);

        subject=(TextView) itemView.findViewById(R.id.subject);
        type=(TextView) itemView.findViewById(R.id.type);
        body=(TextView) itemView.findViewById(R.id.body);
        icon=(ImageView)itemView.findViewById(R.id.icon);
        sml_bage=(ImageView)itemView.findViewById(R.id.sml_bage);
        sml_bg=(ImageView)itemView.findViewById(R.id.sml_bg);

    }


}

public class MyNotifAdapter extends RecyclerView.Adapter<AdapterHolder> {
    Context context;
    List<Notification> notif;
    private LayoutInflater inflater;
    public MyNotifAdapter(Context context, List<Notification> notif) {
        this.context = context;
        this.notif = notif;
        inflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemview = inflater.inflate(R.layout.notification_item, viewGroup, false);


        return new AdapterHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int i) {


        holder.subject.setText(notif.get(i).getSubject());
        holder.type.setText(notif.get(i).getType());
        holder.body.setText("heeey");

    }

    @Override
    public int getItemCount() {

        return notif.size();
    }
    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);


        return  bgDrawable;

    }

}