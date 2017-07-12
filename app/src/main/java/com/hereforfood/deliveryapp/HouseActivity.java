package com.hereforfood.deliveryapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HouseActivity extends AppCompatActivity {

    House house;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        house = (House) getIntent().getSerializableExtra("house");
        setTitle("House " + house.getId());


    }

}
