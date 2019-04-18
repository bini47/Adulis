package com.example.biniyam.mint.Model.Order;

import com.example.biniyam.mint.Model.Product.Product;

import java.util.List;

public class OrderRoot {
        public Product items;
        public List<Order> orders;

    public OrderRoot(Product items, List<Order> orders) {
        this.items = items;
        this.orders = orders;
    }

    public Product getItems() {
        return items;
    }

    public void setItems(Product items) {
        this.items = items;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
