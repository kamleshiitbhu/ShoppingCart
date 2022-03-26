package com.shopping.controller;

import com.shopping.services.CartService;

public class CartController {
    private CartService cartService;
    public CartController() {
        cartService  = CartService.getInstance();
    }

    public void addCartItem(String itemId) {
        cartService.addItem(itemId);
    }

    public void removeCartItem(String itemId) {
        cartService.removeItem(itemId);
    }

    public double getCartTotal() {
        return cartService.getCartTotal();
    }
}
