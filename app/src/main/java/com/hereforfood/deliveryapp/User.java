package com.hereforfood.deliveryapp;

/**
 * Created by Shreyak Kumar on 23-04-2017.
 */

public class User {

    public String userId;
    public String userEmail;

    public User() {;}

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String userEmail) {
        this.userId = userId;
        this.userEmail = userEmail;
    }
}
