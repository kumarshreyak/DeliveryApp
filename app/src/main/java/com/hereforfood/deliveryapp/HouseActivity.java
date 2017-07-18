package com.hereforfood.deliveryapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HouseActivity extends AppCompatActivity {

    House house;
    String localityId;
    TextView houseAddrText, delStatText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        house = (House) getIntent().getSerializableExtra("house");
        localityId = String.valueOf((int) getIntent().getSerializableExtra("localityId"));
        setTitle("House " + house.getId());

        // TODO Add elements to this activity and make callingActivity "Deliver" button (and its activity)
        houseAddrText = (TextView) findViewById(R.id.AddrText);
        delStatText = (TextView) findViewById(R.id.DeliText);

        // Setting the house's address
        houseAddrText.setText(house.getAddress());

        // Displaying status of the delivery
        if(house.isComplete())
            delStatText.setText("Delivery Status :- Complete");
        else
            delStatText.setText("Delivery Status :- Incomplete");
    }

    // Deliver button's onclick method
    public void delButtonClick(View v)
    {
        // Built a Alert dialog for confirming delivery
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.DeliveryConfirmDialog));

        // Adding the text
        builder.setMessage("For report id ....").setTitle("Confirm Delivery ?");

        // Adding the buttons
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked YES button
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked NO Button
            }
        });

        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
