package com.shopping.controller;

import com.shopping.services.CartService;
import com.shopping.services.InventoryService;

public class InventoryController {
    private InventoryService inventoryService;
    public InventoryController() {
        inventoryService  = inventoryService.getInstance();
    }

    public void incrementInventoryItem(String itemId, int count) {
        inventoryService.incrementInventoryItem(itemId, count);
    }

    public void decrementCartItem(String itemId, int count) {
        inventoryService.decrementInventoryItem(itemId, count);
    }
}
