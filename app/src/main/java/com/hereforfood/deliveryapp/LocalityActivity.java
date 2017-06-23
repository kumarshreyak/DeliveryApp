package com.hereforfood.deliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class LocalityActivity extends AppCompatActivity {

    Locality locality;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locality);

        // Setting the title bar
        locality = (Locality) getIntent().getSerializableExtra("locality");
        setTitle("Locality " + locality.getId());

        // Setting the Address details
        TextView addressText = (TextView) findViewById(R.id.addressText);
        addressText.setText(locality.getAddress());

    }

    public void navButtonClick(View view) {
        Intent intent = new Intent(this, LocalityNav.class);
        intent.putExtra("locality",locality);
        startActivity(intent);
    }

}
