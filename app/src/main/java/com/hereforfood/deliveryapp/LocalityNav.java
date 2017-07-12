package com.hereforfood.deliveryapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.Manifest;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class LocalityNav extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mgoogleMap;
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
        this.mgoogleMap = googleMap;
        LatLng latLng;

        // Add a marker at all houses in this locality
        for (int i = 0; i < house.size(); i++) {
            latLng = new LatLng(house.get(i).getLatitude(), house.get(i).getLongitude());
            if (house.get(i).isComplete()) {
                // Adds green marker if house is complete
                this.mgoogleMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                        .title("House " + house.get(i).getId()));
            } else {
                // Adds red marker if house is incomplete
                this.mgoogleMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                        .title("House " + house.get(i).getId()));
            }
        }

        // Move the camera to the first unvisited house
        for (int i = 0; i < house.size(); i++) {
            if (!house.get(i).isComplete()) {
                latLng = new LatLng(house.get(i).getLatitude(), house.get(i).getLongitude());
                this.mgoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
                break;
            }
        }

        // Shows the user's current location with blue dot.
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        69);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }

        }
        mgoogleMap.setMyLocationEnabled(true);

        mgoogleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                int housePos = -1;
                LatLng pos = marker.getPosition();
                for (int i = 0; i < house.size(); i++)
                {
                    if(house.get(i).getLatitude() == pos.latitude)
                    {
                        housePos = i;
                        break;
                    }
                }
//                Intent intent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("http://maps.google.com/maps?f=d&daddr="+pos.latitude+","+pos.longitude));
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.addCategory(Intent.CATEGORY_LAUNCHER );
//                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=Berlin Germany"));
                //startActivity(intent);
                if(housePos != -1)
                {
                    Intent intent = new Intent(LocalityNav.this, HouseActivity.class);
                    intent.putExtra("house", house.get(housePos));
                    startActivity(intent);
                }


            }

        });

        // TODO Show path (start navigation)
        Double latitude =  house.get(0).getLatitude();
        Double longitude =  house.get(0).getLongitude();



    }

}
