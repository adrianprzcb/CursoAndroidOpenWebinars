package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {
    ImageView logotipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logotipo = findViewById(R.id.imagen);
 RequestOptions cropOptions = new RequestOptions().fitCenter();

        Glide.with(this)
               .load("https://brandeame.es/wp-content/uploads/2017/05/Nike-Logo-PNG-Pic.png")
               .apply(cropOptions)
                //.apply(new RequestOptions().override(200, 200))
                .into(logotipo);
    }
}