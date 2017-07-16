package com.hereforfood.deliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HouseActivity extends AppCompatActivity {

    House house;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        house = (House) getIntent().getSerializableExtra("house");
        setTitle("House " + house.getId());

        // TODO Add elements to this activity and make a "Deliver" button (and its activity)
        TextView houseAddrText = (TextView) findViewById(R.id.AddrText);
        TextView delStatText = (TextView) findViewById(R.id.DeliText);

        // Setting the house's address
        houseAddrText.setText(house.getAddress());

        // Displaying status of the delivery
        if(house.isComplete())
            delStatText.setText("Delivery :- Completed");
        else
            delStatText.setText("Delivery :- Incomplete");
    }

    // Deliver button's onclick method
    public void delButtonClick(View v)
    {
        // TODO Open a pop window
    }

}
