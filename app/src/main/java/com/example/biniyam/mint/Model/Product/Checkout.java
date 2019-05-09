package com.example.biniyam.mint.Model.Product;

public class Checkout {

    String firstname;
    String lastname;
    String companyname;
    String city;
    String streetname;
    String housenumber;
    String phone;
    String email;
    String paymentmethod;
    String note;
    String transactionmethod;
    String deliverydate;

    public Checkout(String firstname, String lastname, String companyname, String city, String streetname, String housenumber, String phone, String email, String paymentmethod, String note, String transactionmethod, String deliverydate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.companyname = companyname;
        this.city = city;
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.phone = phone;
        this.email = email;
        this.paymentmethod = paymentmethod;
        this.note = note;
        this.transactionmethod = transactionmethod;
        this.deliverydate = deliverydate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTransactionmethod() {
        return transactionmethod;
    }

    public void setTransactionmethod(String transactionmethod) {
        this.transactionmethod = transactionmethod;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }
}
