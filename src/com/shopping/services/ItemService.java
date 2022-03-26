package com.shopping.services;

import java.util.*;
import com.shopping.model.Item;

public class ItemService {
    static ItemService itemService;
    private Map<String, Item> itemMap;
    private ItemService() {
        itemMap = new HashMap<>();
    }

    public static ItemService getInstance() {
        if(itemService == null) {
            synchronized (ItemService.class) {
                itemService = new ItemService();
            }
        }
        return itemService;
    }

    public boolean isIteamAvailable(String itemId) {
        return itemMap.containsKey(itemId);
    }

    public Item getItem(String itemId) {
        return itemMap.getOrDefault(itemId, null);
    }




    public void addItem(Item item, int count) {
        itemMap.put(item.getId(), item);
        InventoryService.getInstance().incrementInventoryItem(item.getId(), count);
    }
    public void removeItem(Long itemId) {
        if(itemMap.containsKey(itemId)) {
            itemMap.remove(itemId);
        }
    }
}
