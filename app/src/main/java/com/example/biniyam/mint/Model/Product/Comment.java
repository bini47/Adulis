package com.example.biniyam.mint.Model.Product;

import java.util.Date;

public class Comment {
    public String _id;
    public String author;
    public String text;
    public Date created;
    public int __v;
    public Comment() {
    }

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public Comment(String _id, String author, String text, Date created, int __v) {
        this._id = _id;
        this.author = author;
        this.text = text;
        this.created = created;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}