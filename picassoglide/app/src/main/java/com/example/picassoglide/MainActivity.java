package com.example.picassoglide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo.findViewById(R.id.logo);
      /*  Picasso.get()
                .load("https://w7.pngwing.com/pngs/552/638/png-transparent-real-madrid-c-f-la-liga-logo-real-madrid-logo-crown-logo-miscellaneous-sport-team-thumbnail.png")
                .resize(50, 50)
                .centerCrop()
                .centerCrop() .into(logo);*/





    }
}