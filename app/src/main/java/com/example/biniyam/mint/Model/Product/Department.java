package com.example.biniyam.mint.Model.Product;

import java.util.List;

public class Department
{
    public String department ;
    public Boolean _new ;
    public List<String> colors ;
    public List<String> size ;
    public String modelno ;

    public Department() {
    }

    public Department(String department, Boolean _new, List<String> colors, List<String> size, String modelno) {
        this.department = department;
        this._new = _new;
        this.colors = colors;
        this.size = size;
        this.modelno = modelno;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean get_new() {
        return _new;
    }

    public void set_new(Boolean _new) {
        this._new = _new;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }
}
