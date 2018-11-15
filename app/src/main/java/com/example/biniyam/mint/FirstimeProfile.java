package com.example.biniyam.mint;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FirstimeProfile extends AppCompatActivity {

    Button profilePicPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstime_profile);

      profilePicPicker =(Button)findViewById(R.id.profilePicPicker);



        profilePicPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==1 && resultCode==RESULT_OK && data !=null){

            Uri selectedImage =data.getData();

            try{
                Bitmap bitmapImage= MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                ImageView imageView= (ImageView)findViewById(R.id.ProfilePic);

                imageView.setImageBitmap(bitmapImage);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
