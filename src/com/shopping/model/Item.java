package com.shopping.model;

import sun.text.bidi.BidiLine;

public class Item {
    private String id;
    private double price;

    public  Item(String id, double price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
