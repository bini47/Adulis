package com.example.biniyam.mint.Model.Cart;

public class Product {

        public com.example.biniyam.mint.Model.Product.Product item;
        public int qty;
        public int price;

    public Product(com.example.biniyam.mint.Model.Product.Product item, int qty, int price) {
        this.item = item;
        this.qty = qty;
        this.price = price;
    }

    public com.example.biniyam.mint.Model.Product.Product getItem() {
        return item;
    }

    public void setItem(com.example.biniyam.mint.Model.Product.Product item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
