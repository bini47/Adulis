package com.example.biniyam.mint.Model.Product;

import com.example.biniyam.mint.Model.Product.Date;
import com.example.biniyam.mint.Model.Product.Department;
import com.example.biniyam.mint.Model.Product.Manufacture;
import com.example.biniyam.mint.Model.Product.Rating;
import com.example.biniyam.mint.Model.Product.ShippingDetails;

import java.util.List;


public class Product {
    public String _id;
    public String image;
    public String pname;
    public String price;
    public int stokeamount;
    public String description;
    public int __v;
    public ShippingDetails shipping_details;
    public List<String> tags;
    public Rating rating;
    public Department department;
    public List<Object> comments;
    public List<Object> viewedDates;
    public int view;
    public int discount;
    public Manufacture manufacture;
    public Date date;

    public Product(String _id, String image, String pname, String price, int stokeamount, String description, int __v, ShippingDetails shipping_details, List<String> tags, Rating rating, Department department, List<Object> comments, List<Object> viewedDates, int view, int discount, Manufacture manufacture, Date date) {
        this._id = _id;
        this.image = image;
        this.pname = pname;
        this.price = price;
        this.stokeamount = stokeamount;
        this.description = description;
        this.__v = __v;
        this.shipping_details = shipping_details;
        this.tags = tags;
        this.rating = rating;
        this.department = department;
        this.comments = comments;
        this.viewedDates = viewedDates;
        this.view = view;
        this.discount = discount;
        this.manufacture = manufacture;
        this.date = date;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStokeamount() {
        return stokeamount;
    }

    public void setStokeamount(int stokeamount) {
        this.stokeamount = stokeamount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public ShippingDetails getShipping_details() {
        return shipping_details;
    }

    public void setShipping_details(ShippingDetails shipping_details) {
        this.shipping_details = shipping_details;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

    public List<Object> getViewedDates() {
        return viewedDates;
    }

    public void setViewedDates(List<Object> viewedDates) {
        this.viewedDates = viewedDates;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
