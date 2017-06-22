package com.hereforfood.deliveryapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LocalitySelect extends AppCompatActivity {

    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locality_select);


        // Get the user data
        user = (User) getIntent().getSerializableExtra("user");

        //Populate the ListView with user's localities
        ListView listView = (ListView) findViewById(R.id.localityList);
        listView.setAdapter(new LocalityListAdapter(this, user.getUserLocality()));
    }

}
