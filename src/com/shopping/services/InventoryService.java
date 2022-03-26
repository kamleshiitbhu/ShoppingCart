package com.shopping.services;

import com.shopping.model.Inventry;

public class InventoryService {
    Inventry inventry;
    static InventoryService inventoryService;
    private InventoryService() {
        inventry = new Inventry();
    }

    public static InventoryService getInstance() {
        if(inventoryService == null) {
            synchronized (InventoryService.class) {
                inventoryService = new InventoryService();
            }
        }
        return inventoryService;
    }

    public boolean isAvailable(String itemId) {
        return ItemService.getInstance().isIteamAvailable(itemId) && inventry.getItemInventoryMap().getOrDefault(itemId, 0) > 0;
    }


    public void incrementInventoryItem(String itemId, int count) {
        inventry.getItemInventoryMap().put(itemId, inventry.getItemInventoryMap().getOrDefault(itemId, 0) + count);
    }
    public void decrementInventoryItem(String itemId, int count) {
        if (ItemService.getInstance().isIteamAvailable(itemId) && inventry.getItemInventoryMap().getOrDefault(itemId, 0) >= count) {
            inventry.getItemInventoryMap().put(itemId, inventry.getItemInventoryMap().getOrDefault(itemId, 0) - count);
        }
    }
}
