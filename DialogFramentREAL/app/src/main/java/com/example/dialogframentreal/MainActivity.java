package com.example.dialogframentreal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnNuevaAveriaListener  {
    DialogFragment dialogoNuevaAveria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void kkk(View view){
        dialogoNuevaAveria = new NuevaAveriaDialogo();
        dialogoNuevaAveria.show(getSupportFragmentManager(),"NuevaAveriaDialogo");
    }

    @Override
    public void onAveriaGuardarClickListener() {
        Toast.makeText(this, "Se ha recibido la avería guardada", Toast.LENGTH_SHORT).show();
    }
}