package com.example.googlemapsapi;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapsapi.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    Marker marker;
    Circle circle;
    LatLng posAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng central = new LatLng(37.390930 , -5.994510);
        posAnterior = sydney;
        marker = mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"));

         mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.390930 , -5.994510 ))
                .title("Talleres Juan e Hijos")
                 .draggable(true)
                 .snippet("telefono: 5132423")
                 .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.400137,-5.955736
                ))
                .title("taller electrico")
                .snippet("telefono 342423")
                 .draggable(true)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconno)));


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.386499,-5.958828))
                .title("taller fesfsefsedfsef")
                .snippet("telefono 34esfsefse2423")
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));


        mMap.setOnMarkerClickListener(this);
        mMap.setOnMarkerDragListener(this);


        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);


        //Definicion del circulo

        CircleOptions crlOpt = new CircleOptions()
                .center(sydney)
                .fillColor(ContextCompat.getColor(this, R.color.purple_200))
                .strokeColor(ContextCompat.getColor(this, R.color.teal_200))
                .strokeWidth(10)
                .radius(1000);

        circle = mMap.addCircle(crlOpt);

    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        Toast.makeText(this, "Has hecho click en: " + latLng.latitude + " , "+ latLng.longitude , Toast.LENGTH_SHORT).show();
       // marker.setPosition(latLng);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
       // mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("nuevo marker"));
        PolylineOptions ret = new PolylineOptions().add(posAnterior).add(latLng);

        Polyline polyline = mMap.addPolyline(ret);

        posAnterior = latLng;
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng , 20));
        circle.setCenter(latLng);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        Toast.makeText(this, "Has hecho LONG  click en: " + latLng.latitude + " , "+ latLng.longitude, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Toast.makeText(this, "Has hecho click en " + marker.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {
        Log.i("MARKER" , "MARKER :" + marker.getPosition().latitude + " , " + marker.getPosition().longitude);
    }

    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {
        Toast.makeText(this, "Se termina de arrastrar " + marker.getTitle(), Toast.LENGTH_SHORT).show();
        marker.hideInfoWindow();
    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {
        Toast.makeText(this, "Se comienza a arrastrar " + marker.getTitle(), Toast.LENGTH_SHORT).show();
        marker.showInfoWindow();
    }
}