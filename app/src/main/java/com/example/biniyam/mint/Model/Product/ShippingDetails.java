package com.example.biniyam.mint.Model.Product;

public class ShippingDetails
{
    public String weight ;
    public String width ;
    public String depth ;
    public String height ;

    public ShippingDetails(String weight, String width, String depth, String height) {
        this.weight = weight;
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}

