package com.hereforfood.deliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;

public class LocalitySelect extends AppCompatActivity {

    User user;
    HashMap<String, Locality> localityHashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locality_select);


        // Get the user data
        user = (User) getIntent().getSerializableExtra("user");
        localityHashMap = user.getUserLocality();

        //Populate the ListView with user's localities
        ListView listView = (ListView) findViewById(R.id.localityList);
        listView.setAdapter(new LocalityListAdapter(this, user.getUserLocality()));

        //TODO make the onListItemClick method
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                String mKey[] = localityHashMap.keySet().toArray(new String[localityHashMap.size()]);

                // Open the clicked locality's activity
                Intent intent = new Intent(LocalitySelect.this, LocalityActivity.class);
                intent.putExtra("locality", localityHashMap.get(mKey[position]));
                startActivity(intent);
            }
        });
    }

}
