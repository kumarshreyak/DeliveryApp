package com.hereforfood.deliveryapp;

import java.io.Serializable;

/**
 * Created by Shreyak Kumar on 23-04-2017.
 */

public class House implements Serializable {

    int id;
    int reportCode;
    String address;
    private double latitude;
    private double longitude;
    private boolean isComplete;

    public House() {
        isComplete = false;
        address = "lorem ipsum dada";
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getId() {
        return id;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean value) {
        isComplete = value;
    }

    public String getAddress() {
        return address;
    }
}
