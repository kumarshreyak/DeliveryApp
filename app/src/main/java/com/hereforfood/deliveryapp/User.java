package com.hereforfood.deliveryapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreyak Kumar on 23-04-2017.
 */

public class User {

    public String userId;
    public String userEmail;
    public List<Locality> locality;

    public User() {;}

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String userEmail) {
        this.userId = userId;
        this.userEmail = userEmail;
        locality = new ArrayList<Locality>();

        //insert dummy values in locality list and insert it into firebase
        Locality l = new Locality();

        // Adding locality with id = 21
        l.id = 21;
        l.AddressLine1 = "lorem ipsum";
        l.city = " MUMBAI";
        List<House> houses = new ArrayList<House>();
        House h = new House();
        h.id = 1;
        l.house.add(h);
        h.id = 2;
        l.house.add(h);
        h.id = 3;
        l.house.add(h);
        h.id = 4;
        l.house.add(h);
        h.id = 56;
        l.house.add(h);
        locality.add(l);

        // Adding locality with id = 69
        l.id = 69;
        l.AddressLine1 = "loremsdada ipsum";
        l.city = "NOIDA";
        h.id = 10;
        l.house.add(h);
        h.id = 20;
        l.house.add(h);
        h.id = 30;
        l.house.add(h);
        h.id = 40;
        l.house.add(h);
        h.id = 50;
        l.house.add(h);
       // locality.add(l);

    }
}
