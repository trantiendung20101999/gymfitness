package com.example.fitnessproject.model;

import java.io.Serializable;

public class NhomCo implements Serializable {

    private int id;
    private String name;

    public NhomCo() {
    }

    public NhomCo(String name) {
        this.name = name;
    }

    public NhomCo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
