package com.shopping.model;
import java.util.HashMap;
import java.util.Map;

public class Inventry {
    Map<String, Integer> itemInventoryMap;

    public Inventry() {
        itemInventoryMap = new HashMap<>();
    }

    public Map<String, Integer> getItemInventoryMap() {
        return itemInventoryMap;
    }
}
