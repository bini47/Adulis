package com.example.biniyam.mint.Model.Order;

import com.example.biniyam.mint.Model.Product.Cart;

import java.util.Date;

public class Order
{
    public String _id ;
    public Cart cart ;
    public String user ;
    public String name ;
    public String deliveryadress ;
    public String phone ;
    public Date deliverydate ;
    public int __v ;
    public String status ;
    public Boolean paid ;
    public Date ordereddate ;

    public Order(String _id, Cart cart, String user, String name, String deliveryadress, String phone, Date deliverydate, int __v, String status, Boolean paid, Date ordereddate) {
        this._id = _id;
        this.cart = cart;
        this.user = user;
        this.name = name;
        this.deliveryadress = deliveryadress;
        this.phone = phone;
        this.deliverydate = deliverydate;
        this.__v = __v;
        this.status = status;
        this.paid = paid;
        this.ordereddate = ordereddate;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryadress() {
        return deliveryadress;
    }

    public void setDeliveryadress(String deliveryadress) {
        this.deliveryadress = deliveryadress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Date getOrdereddate() {
        return ordereddate;
    }

    public void setOrdereddate(Date ordereddate) {
        this.ordereddate = ordereddate;
    }
}
