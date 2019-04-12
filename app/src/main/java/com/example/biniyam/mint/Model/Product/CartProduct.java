package com.example.biniyam.mint.Model.Product;

public class CartProduct {
    public Product item;
    public int qty ;
    public double price;

    public CartProduct(Product item, int qty, double price) {
        this.item = item;
        this.qty = qty;
        this.price = price;
    }

    public CartProduct() {
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
