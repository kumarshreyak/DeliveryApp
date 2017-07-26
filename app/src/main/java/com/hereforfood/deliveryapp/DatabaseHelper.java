package com.hereforfood.deliveryapp;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    DatabaseReference userDB, houseDB, localityDB, assignmentDB, refDB;


    public void DatabaseHelper () {
        userDB = database.getReference(USER_TABLE);
        houseDB = database.getReference(HOUSE_TABLE);
        localityDB = database.getReference(LOCALITY_TABLE);
        assignmentDB = database.getReference(ASSIGNMENT_TABLE);
    }



    public void addUser(String userId, String email) {
        userDB = database.getReference(USER_TABLE);
        User user = new User(userId, email);
        addLocalityToUser(user);
        userDB.child(userId).setValue(user);
    }

    public void addLocalityToUser(User user) {
        String id = database.getReference().push().getKey();
        Locality locality = new Locality(id);
        addHouseToLocality(locality);
        user.addLocality(locality);
    }

    public void addHouseToLocality(Locality locality) {
        String id = database.getReference().push().getKey();
        House house = new House(id);
        locality.addHouse(house);
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

    public void setHouseDeliveryStatus(boolean value, String houseId, final String userId, final String localityId) {
        database.getReference(USER_TABLE)
                .child(userId)
                .child("locality")
                .child(localityId)
                .child("house")
                .child(houseId)
                .child("isComplete")
                .setValue(value);

        database.getReference()
                .child("User")
                .child(userId)
                .child("locality")
                .child(localityId)
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //TODO make this shiz faster

                Locality temp;

                // Getting locality data
                temp = dataSnapshot.getValue(Locality.class);
                String uId, lId;
                uId = userId;
                lId = localityId;

                if(temp.getHousesLeft() == 1 || temp.getHousesLeft() == 0) {
                    setLocalityHousesLeft(0, uId, lId);
                } else {
                    setLocalityHousesLeft(temp.getHousesLeft() - 1, uId, lId);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("D", "Failed to read value.", error.toException());
            }
        });

    }

    public void setLocalityHousesLeft(int housesLeft, String userId, String localityId) {
        database.getReference(USER_TABLE)
                .child(userId)
                .child("locality")
                .child(localityId)
                .child("housesLeft")
                .setValue(housesLeft);
    }

    // TODO functions for getting data from website (houses etc.)



}
