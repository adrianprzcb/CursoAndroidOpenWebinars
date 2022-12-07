package com.example.picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView icono;
    ImageView icono2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icono =findViewById(R.id.icono);
        icono2 = findViewById(R.id.logo2);

        Picasso.get().load("https://i.imgur.com/DvpvklR.png")
                .into(icono);

        RequestOptions cropOptions = new RequestOptions().centerCrop();

        Glide.with(this)
                .load("https://i.imgur.com/DvpvklR.png")
                .apply(cropOptions)
                .into(icono2);




    }
}