package com.example.fitnessproject.model;

import java.io.Serializable;
import java.util.ArrayList;

public class BaiTap implements Serializable {

    private int id;
    private NhomCo nhomco;
    private String name;
    private int image;
    private String video;
    private int time;

    public BaiTap() {
    }

    public BaiTap(NhomCo nhomco, String name, int image, String video, int time) {
        this.nhomco = nhomco;
        this.name = name;
        this.image = image;
        this.video = video;
        this.time = time;
    }

    public BaiTap(int id, NhomCo nhomco, String name, int image, String video, int time) {
        this.id = id;
        this.nhomco = nhomco;
        this.name = name;
        this.image = image;
        this.video = video;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NhomCo getNhomco() {
        return nhomco;
    }

    public void setNhomco(NhomCo nhomco) {
        this.nhomco = nhomco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
