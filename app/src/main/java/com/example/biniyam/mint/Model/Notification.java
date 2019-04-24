package com.example.biniyam.mint.Model;

import java.util.Date;

public class Notification {

    public String type;
    public String body;
    public String subject;
    public Date date;

    public Notification(String type, String body, String subject, Date date) {
        this.type = type;
        this.body = body;
        this.subject = subject;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
