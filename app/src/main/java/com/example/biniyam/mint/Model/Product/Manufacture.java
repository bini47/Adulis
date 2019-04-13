package com.example.biniyam.mint.Model.Product;

public class Manufacture
{
    public String manufacturer ;
    public String _id ;
    public String model_number ;

    public Manufacture() {
    }

    public Manufacture(String manufacturer, String _id, String model_number) {
        this.manufacturer = manufacturer;
        this._id = _id;
        this.model_number = model_number;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getModel_number() {
        return model_number;
    }

    public void setModel_number(String model_number) {
        this.model_number = model_number;
    }
}
