package com.hereforfood.deliveryapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class LocalityNav extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Locality locality;
    List<House> house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locality_nav);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Get the locality's data
        locality = (Locality) getIntent().getSerializableExtra("locality");
        house = locality.getLocalityHouses();
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
        LatLng latLng;

        // Add a marker at all houses in this locality
        for (int i = 0; i < house.size(); i ++) {
            latLng = new LatLng(house.get(i).getLatitude(), house.get(i).getLongitude());
            if(house.get(i).isComplete()) {
                // Adds green marker if house is complete
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                        .title("House " + house.get(i).getId()));
            } else {
                // Adds red marker if house is incomplete
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                        .title("House " + house.get(i).getId()));
            }
        }

        // Move the camera to the first unvisited house
        for (int i = 0; i < house.size(); i ++) {
            if(!house.get(i).isComplete()) {
                latLng = new LatLng(house.get(i).getLatitude(), house.get(i).getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
                break;
            }
        }



    }
}
