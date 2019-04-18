package com.example.biniyam.mint.Model.Cart;

import java.util.List;

public class CartData
{
    public List<MyCart> products;
    public int totalPrice;

    public CartData(List<MyCart> products, int totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public List<MyCart> getProducts() {
        return products;
    }

    public void setProducts(List<MyCart> products) {
        this.products = products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
