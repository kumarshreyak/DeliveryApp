package com.hereforfood.deliveryapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shreyak Kumar on 23-04-2017.
 */

public class User implements Serializable {

    public String userId;
    public String userEmail;
    public HashMap<String, Locality> locality;
    public String userCity;
    public long localitiesDone = 0;

    public User() {}

    public User(String userId, String userEmail) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userCity = "Jaipur";
        locality = new HashMap<>();
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

    public HashMap<String, Locality> getUserLocality() {
        return locality;
    }

    public long getLocalitiesDone() {
        return localitiesDone;
    }

    public long getTotalLocalities() {
        if(locality.isEmpty())
            return 0;
        else
            return locality.size();
    }

    public void addLocality(Locality new_locality)
    {
        locality.put(new_locality.getId(), new_locality);
    }
}
