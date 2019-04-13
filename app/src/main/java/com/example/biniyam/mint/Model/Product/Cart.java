package com.example.biniyam.mint.Model.Product;

import java.util.List;

public class Cart {
    public List<CartProduct> products;
    public double totalPrice;

    public Cart() {
    }

    public Cart(List<CartProduct> products, double totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
