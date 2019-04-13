package com.example.biniyam.mint.Model.Product;

public class Comment
{
    public String _id;
    public String author;
    public String text;

    public Comment() {
    }

    public Comment(String _id, String author, String text) {
        this._id = _id;
        this.author = author;
        this.text = text;
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
}