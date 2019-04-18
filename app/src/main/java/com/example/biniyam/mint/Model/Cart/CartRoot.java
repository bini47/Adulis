package com.example.biniyam.mint.Model.Cart;

import java.util.List;

public class CartRoot {

        public List<Product> products;
        public CartData cartData;

    public CartRoot(List<Product> products, CartData cartData) {
        this.products = products;
        this.cartData = cartData;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public CartData getCartData() {
        return cartData;
    }

    public void setCartData(CartData cartData) {
        this.cartData = cartData;
    }
}
