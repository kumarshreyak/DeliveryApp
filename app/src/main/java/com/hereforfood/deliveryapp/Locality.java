package com.hereforfood.deliveryapp;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shreyak Kumar on 29-04-2017.
 */

public class Locality implements Serializable {

    public String id;
    String AddressLine1, city, landmark;
    double latitude;
    double longitude;
    int housesLeft;
    Date date;
    HashMap<String, House> house ;
    boolean isComplete;

    public Locality() {}

    public Locality(String localityId) {
        house = new HashMap<>();
        this.id = localityId;
        isComplete = false;
    }

    public HashMap<String, House> getLocalityHouses() {
        return house;
    }

    public String getId() {
        return id;
    }

    public int getHousesLeft() {
        return housesLeft;
    }

    public String getAddress() {
        return AddressLine1;
    }

    public void addHouse(House new_house)
    {
        house.put(new_house.getId(), new_house);
    }

}
