package com.hereforfood.deliveryapp;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Shreyak Kumar on 29-04-2017.
 */

public class DatabaseHelper {

    private static final String USER_TABLE = "User";
    private static final String HOUSE_TABLE = "House";
    private static final String LOCALITY_TABLE = "Locality";
    private static final String ASSIGNMENT_TABLE = "Assignment";
    private static final String DELIVERY_TABLE = "Delivery";

    FirebaseAuth auth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userDB, houseDB, localityDB, assignmentDB;


    public void DatabaseHelper () {
        userDB = database.getReference(USER_TABLE);
        houseDB = database.getReference(HOUSE_TABLE);
        localityDB = database.getReference(LOCALITY_TABLE);
        assignmentDB = database.getReference(ASSIGNMENT_TABLE);
    }



    public void addUser(String userId, String email) {
        userDB = database.getReference(USER_TABLE);
        User user = new User(userId, email);
        userDB.child(userId).setValue(user);
    }

    public void getCity(String userId) {
        User user1;
        userDB = database.getReference(USER_TABLE);
        userDB.orderByChild("userId").addChildEventListener(new ChildEventListener() {
            User user;
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                user = dataSnapshot.getValue(User.class);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }

    // TODO functions for getting data from website (houses etc.)



}
