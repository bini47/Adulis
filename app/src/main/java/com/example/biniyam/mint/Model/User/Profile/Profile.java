package com.example.biniyam.mint.Model.User.Profile;

import com.example.biniyam.mint.Model.User.User.User;

public class Profile {

    private String location;
    private String phone;
    private User user;

    public Profile() {
    }

    public Profile(String location, String phone, User user) {
        this.location = location;
        this.phone = phone;
        this.user = user;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
