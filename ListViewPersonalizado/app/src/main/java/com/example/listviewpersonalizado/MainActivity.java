package com.example.listviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView lista;
    List<Averia> averiaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);

        averiaList = new ArrayList<>();
        averiaList.add(new Averia("Espejo Roto" , "Audi a4" , "https://previews.123rf.com/images/martincp/martincp1505/martincp150500365/40521209-siete-a%C3%B1os-de-mala-suerte-coche-roto-ala-espejo.jpg" , 2));
        averiaList.add(new Averia("para Roto" , "citroen seo" , "" , 0));
        averiaList.add(new Averia("espeja rata" , "opel corsa" , "" , 1));
        averiaList.add(new Averia("coche todo roto" , "bmw" , "" , 2));

        MiAdaptadorAverias adaptadorAverias = new MiAdaptadorAverias(this, R.layout.averiaitem , averiaList);
        lista.setAdapter(adaptadorAverias);


    }
}