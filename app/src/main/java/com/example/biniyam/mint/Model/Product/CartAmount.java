package com.example.biniyam.mint.Model.Product;

public class CartAmount {
    public String totalQty;

    public CartAmount() {
    }

    public String getTotalCartAmount() {
        return totalQty;
    }

    public void setTotalCartAmount(String totalCartAmount) {
        this.totalQty = totalCartAmount;
    }

    public CartAmount(String totalCartAmount) {
        this.totalQty = totalCartAmount;
    }
}
