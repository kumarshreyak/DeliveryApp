package com.hereforfood.deliveryapp;

/**
 * Created by Shreyak Kumar on 23-04-2017.
 */

public class House {

    private int id = 69;
    private int reportCode;
    private int latitude;
    private int longitude;
    private String userId;

    public House() { ; }

    public House(int houseId) {
        id = houseId;
    }

    public House(String id) {
        userId = id;
    }
}
