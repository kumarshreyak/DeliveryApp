package com.hereforfood.deliveryapp;

import java.sql.Date;
import java.util.List;

/**
 * Created by Shreyak Kumar on 29-04-2017.
 */

public class Locality {

    private int id;
    private String AddressLine1, city, landmark;
    private double latitude;
    private double longitude;
    private int isCompleted = 0, housesLeft;
    private Date date;
    private List<House> house ;

    public Locality() { ; }

}
