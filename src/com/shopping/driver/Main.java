package com.shopping.driver;

import com.shopping.controller.CartController;
import com.shopping.controller.InventoryController;
import com.shopping.controller.ItemController;
import com.shopping.services.CartService;
import com.shopping.services.InventoryService;

public class Main {
    public static void main(String[] args) {
        //initialize all controller
        ItemController itemController = new ItemController();
        InventoryController inventoryController = new InventoryController();
        CartController cartController = new CartController();

        itemController.addItem("1", 3.5, 2);
        cartController.addCartItem("1");
        cartController.addCartItem("1");
        inventoryController.incrementInventoryItem("1", 10);
        cartController.addCartItem("1");
        System.out.println(cartController.getCartTotal());

    }
}
