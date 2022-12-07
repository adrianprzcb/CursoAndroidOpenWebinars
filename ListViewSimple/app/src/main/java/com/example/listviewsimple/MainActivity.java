package com.example.listviewsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private List<String> talleresList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewTalleres);
        talleresList = new ArrayList<>();
        talleresList.add("hola talleres");
        talleresList.add("adios talleres");
        talleresList.add("pepe talleres");
        talleresList.add("mama talleres");


        ArrayAdapter<String> adaptadorTalleres = new ArrayAdapter<String>(
                this , android.R.layout.simple_list_item_1, talleresList
        );
        lista.setAdapter(adaptadorTalleres);

        lista.setOnItemClickListener(this);




    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

      Toast.makeText(this, "hola " + talleresList.get(posicion), Toast.LENGTH_SHORT).show();
    //  view.animate().rotation(360).setDuration(1000);

    }
}