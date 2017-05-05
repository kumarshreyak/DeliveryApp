package com.hereforfood.deliveryapp;

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
        // TODO insert dummy values in locality list and insert it into firebase

    }
}
