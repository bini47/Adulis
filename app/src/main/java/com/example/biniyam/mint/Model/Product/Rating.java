package com.example.biniyam.mint.Model.Product;

import java.util.List;

public class Rating
{
    public int five ;
    public int four ;
    public int three ;
    public int two ;
    public int one ;
    public double averge ;

    public Rating() {
    }

    public Rating(int five, int four, int three, int two, int one, double averge) {
        this.five = five;
        this.four = four;
        this.three = three;
        this.two = two;
        this.one = one;
        this.averge = averge;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getFour() {
        return four;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public int getThree() {
        return three;
    }

    public void setThree(int three) {
        this.three = three;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public double getAverge() {
        return averge;
    }

    public void setAverge(int averge) {
        this.averge = averge;
    }
}





