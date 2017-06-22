package com.hereforfood.deliveryapp;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreyak Kumar on 29-04-2017.
 */

public class Locality implements Serializable {

    public int id;
    String AddressLine1, city, landmark;
    double latitude;
    double longitude;
    int housesLeft;
    Date date;
    List<House> house ;
    boolean isComplete;


    public Locality() {
        house = new ArrayList<House>();
        isComplete = false;
    }

    public List<House> getLocalityHouses() {
        return house;
    }

    public int getId() {
        return id;
    }

    public int getHousesLeft() {
        return housesLeft;
    }

}
