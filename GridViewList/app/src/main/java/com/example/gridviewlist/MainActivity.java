package com.example.gridviewlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        GridView grid;
    List<Averia> averiaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.gridViewAverias);


        averiaList = new ArrayList<>();
        averiaList.add(new Averia("Espejo roto","Audi - A4","https://dynaimage.cdn.cnn.com/cnn/c_fill,g_auto,w_1200,h_675,ar_16:9/https%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F220721175751-woman-mechanic-stock.jpg",2));
        averiaList.add(new Averia("Paragolpes delantero","Citroen - C4","",0));
        averiaList.add(new Averia("Embrague","Seat - Ibiza","",0));
        averiaList.add(new Averia("Cambio de aceite","Seat - Toledo","",1));

        MiAdaptadorAverias adaptadorAverias = new MiAdaptadorAverias(
                this,
                R.layout.averia_grid_item,
                averiaList
        );

        grid.setAdapter(adaptadorAverias);
    }
    }
