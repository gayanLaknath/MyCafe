package com.example.mycafe;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Direction extends FragmentActivity implements GoogleMap.OnMapLoadedCallback, OnMapReadyCallback {

    GoogleMap map;
    ImageView BackToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BackToMenu = findViewById(R.id.back);

        BackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToDashboard = new Intent(Direction.this,Dashboard.class);
                startActivity(intentToDashboard);
                finish();
            }
        });
    }
    @Override
    public void onMapLoaded() {

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng University = new LatLng(5.938401, 80.577691);
        map.addMarker(new MarkerOptions().position(University).title("University of Ruhuna"));
        map.moveCamera(CameraUpdateFactory.newLatLng(University));
    }
}
