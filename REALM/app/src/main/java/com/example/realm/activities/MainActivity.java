package com.example.realm.activities;

import android.os.Bundle;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.realm.R;
import com.example.realm.fragments.ListaTalleresFragment;
import com.example.realm.fragments.ListadoAveriasFragment;
import com.example.realm.fragments.NuevaAveriaDialogo;
import com.example.realm.interfaces.OnAveriaInteractionListener;
import com.example.realm.interfaces.OnNuevaAveriaListener;
import com.example.realm.models.Averia;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        OnAveriaInteractionListener,
        OnNuevaAveriaListener {

    DialogFragment dialogNuevaAveria;

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
                dialogNuevaAveria = new NuevaAveriaDialogo();
                dialogNuevaAveria.show(getSupportFragmentManager(),"DialogNuevaAveria");
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Personalizaci??n del contenido del NavigationView header
        ImageView ivAvatar = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.imageViewAvatar);
        ivAvatar.setImageResource(R.drawable.ic_man);

        TextView nombre = (TextView) navigationView.getHeaderView(0).findViewById(R.id.textViewNombre);
        TextView email = (TextView) navigationView.getHeaderView(0).findViewById(R.id.textViewEmail);

        nombre.setText("Miguel");
        email.setText("miguel@miguel.com");

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor,new ListadoAveriasFragment())
                .commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment f = null;

        if (id == R.id.nav_averias) {
            f = new ListadoAveriasFragment();
        } else if (id == R.id.nav_talleres) {
            f = new ListaTalleresFragment();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_logout) {

        }

        if(f!=null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedor,f)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onAveriaClick(Averia averia) {

    }

    @Override
    public void onAveriaGuardarClickListener() {

    }
}
