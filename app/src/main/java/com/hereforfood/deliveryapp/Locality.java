package com.hereforfood.deliveryapp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreyak Kumar on 29-04-2017.
 */

public class Locality {

    public int id;
    String AddressLine1, city, landmark;
    double latitude;
    double longitude;
    int isCompleted = 0, housesLeft;
    Date date;
    List<House> house ;


    public Locality() {
        house = new ArrayList<House>();
    }

}
