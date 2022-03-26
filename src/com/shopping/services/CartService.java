package com.shopping.services;

import com.shopping.model.ItemBucket;
import com.shopping.model.Inventry;

import java.util.*;

public class CartService {
    private static CartService cartService;
    Map<String, ItemBucket> cart;
    double total;

    public static CartService getInstance() {
        if(cartService == null) {
            synchronized (CartService.class) {
                cartService = new CartService();
            }
        }
        return cartService;
    }
    private CartService() {
        total = 0;
        cart = new HashMap<>();
    }

    public double getCartTotal() {
        return this.total;
    }

    public void addItem(String itemId) {
        if (!InventoryService.getInstance().isAvailable(itemId)) {
            System.out.println("Item Not Available in Inventory");
            return;
        }
        if (!cart.containsKey(itemId)) {
            cart.put(itemId, new ItemBucket());
        }
        ItemBucket bucket = cart.get(itemId);
        InventoryService.getInstance().decrementInventoryItem(itemId, 1);
        bucket.setCount(bucket.getCount()+ 1);
        this.total = this.total + ItemService.getInstance().getItem(itemId).getPrice();
    }

    public void removeItem(String itemId) {
        if (!cart.containsKey(itemId)) {
            cart.put(itemId, new ItemBucket());
        }
        ItemBucket bucket = cart.get(itemId);
        if (bucket.getCount() <= 1) {
            cart.remove(itemId);
            return;
        }
        InventoryService.getInstance().incrementInventoryItem(itemId, 1);
        bucket.setCount(bucket.getCount()+ 1);
        this.total = this.total - ItemService.getInstance().getItem(itemId).getPrice();
    }

}
