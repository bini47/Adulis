package com.example.biniyam.mint.Model.Product;

import java.util.List;

public class Product
{
    public String _id ;
    public String pname ;
    public String price ;
    public String image ;
    public int stokeamount ;
    public String description ;
    public int __v ;
    public List<Object> tags ;
    public Rating rating ;
    public Department department ;
    public List<Object> comments ;
    public String view ;
    public List<Manufacture> manufacture ;

    public Product() {
    }

    public Product(String _id, String pname, String price, String image, int stokeamount, String description, int __v, List<Object> tags, Rating rating, Department department, List<Object> comments, String view, List<Manufacture> manufacture) {
        this._id = _id;
        this.pname = pname;
        this.price = price;
        this.image = image;
        this.stokeamount = stokeamount;
        this.description = description;
        this.__v = __v;
        this.tags = tags;
        this.rating = rating;
        this.department = department;
        this.comments = comments;
        this.view = view;
        this.manufacture = manufacture;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
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

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public List<Manufacture> getManufacture() {
        return manufacture;
    }

    public void setManufacture(List<Manufacture> manufacture) {
        this.manufacture = manufacture;
    }
}