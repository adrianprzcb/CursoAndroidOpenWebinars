package com.example.implicitocall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void crearAlarma(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
               // .putExtra(AlarmClock.EXTRA_MESSAGE, "Ir al trabajo")
                .putExtra(AlarmClock.EXTRA_HOUR, 11)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30);
        if (intent.resolveActivity(getPackageManager()) != null) {
            Log.i("Tag","Llegare aqui?");

            startActivity(intent);
        }else{
            Log.i("Tag" , "NO");
            startActivity(intent);
        }
    }

    public void marcarTelefonoEmergencia(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:112"));

        if (intent.resolveActivity(getPackageManager()) != null) {
        }
        startActivity(intent);

    }
}