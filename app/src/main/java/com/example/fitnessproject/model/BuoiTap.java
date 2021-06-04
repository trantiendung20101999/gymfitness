package com.example.fitnessproject.model;

import java.io.Serializable;

public class BuoiTap implements Serializable {

    private int id;
    private int time;
    private int time_stop;
    private String date;

    public BuoiTap() {
    }

    public BuoiTap(int time, int time_stop, String date) {
        this.time = time;
        this.time_stop = time_stop;
        this.date = date;
    }

    public BuoiTap(int id, int time, int time_stop, String date) {
        this.id = id;
        this.time = time;
        this.time_stop = time_stop;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime_stop() {
        return time_stop;
    }

    public void setTime_stop(int time_stop) {
        this.time_stop = time_stop;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
