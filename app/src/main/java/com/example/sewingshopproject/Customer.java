package com.example.sewingshopproject;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Customer {
    private String name;
    private String address;
    private String cell;
    private String size;
    private String order;


    public Customer() {
    }

    public Customer(String name, String address, String cell, String size, String order) {
        this.name = name;
        this.address = address;
        this.cell = cell;
        this.size = size;
        this.order = order;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCell() {
        return cell;
    }

    public String getSize() {
        return size;
    }

    public String getOrder() {
        return order;
    }


}
