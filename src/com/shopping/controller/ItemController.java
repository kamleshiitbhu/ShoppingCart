package com.shopping.controller;

import com.shopping.model.Item;
import com.shopping.services.CartService;
import com.shopping.services.ItemService;

public class ItemController {
    private ItemService itemService;
    public ItemController() {
        itemService  = ItemService.getInstance();
    }

    public void addItem(String itemId, double price, int count) {
        itemService.addItem(new Item(itemId, price), count);
    }

    public void removeItem(Long itemId) {
        itemService.removeItem(itemId);
    }

}
