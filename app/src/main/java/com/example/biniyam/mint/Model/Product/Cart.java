package com.example.biniyam.mint.Model.Product;

import java.util.List;

public class Cart {
        public int totalPrice;
        public int totalQty;
        public Product items;

        public Cart(int totalPrice, int totalQty, Product items) {
            this.totalPrice = totalPrice;
            this.totalQty = totalQty;
            this.items = items;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
        }

        public int getTotalQty() {
            return totalQty;
        }

        public void setTotalQty(int totalQty) {
            this.totalQty = totalQty;
        }

        public Product getItems() {
            return items;
        }

        public void setItems(Product items) {
            this.items = items;
        }
    }

