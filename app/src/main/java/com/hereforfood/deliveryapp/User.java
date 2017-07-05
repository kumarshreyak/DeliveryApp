package com.hereforfood.deliveryapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreyak Kumar on 23-04-2017.
 */

public class User implements Serializable {

    public String userId;
    public String userEmail;
    public List<Locality> locality;
    public String userCity;
    public long localitiesDone = 0;

    public User() {;}

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String userEmail) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userCity = "Jaipur";
    }

    public User(String userId, String userEmail, String userCity) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userCity = userCity;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserCity() {
        return userCity;
    }

    public List<Locality> getUserLocality() {
        return locality;
    }

    public long getLocalitiesDone() {
        return localitiesDone;
    }

    public long getTotalLocalities() {
        return locality.size();
    }
}
