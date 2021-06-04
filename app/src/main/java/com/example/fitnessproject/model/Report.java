package com.example.fitnessproject.model;

import java.io.Serializable;

public class Report implements Serializable {
    int image;
    String des;

    public Report() {
    }

    public Report(int image, String des) {
        this.image = image;
        this.des = des;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
