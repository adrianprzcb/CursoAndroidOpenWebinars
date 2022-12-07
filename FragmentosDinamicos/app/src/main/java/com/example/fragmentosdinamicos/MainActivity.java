package com.example.fragmentosdinamicos;

import android.os.Bundle;

import android.view.View;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    boolean cargarFragmento2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Modificar el Fragmento que sale en la pantalla
                // dentro del container

                Fragment f = null;

                if(cargarFragmento2) {
                   f = new SegundoFragment();
                } else {
                    f = new PrimerFragment();
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();

                cargarFragmento2 = !cargarFragmento2;

            }
        });

        // Rescatamos el contenedor y le vamos a cargar un fragmento
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container,new PrimerFragment())
                .commit();


    }


}
