package com.example.fitnessproject.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Exercise implements Serializable {

    private int image;
    private ArrayList<Integer> imagedescribes;
    private String des;
    private String repNum;
    private String setNum;
    private String detail_instructions;


    public Exercise(int image, ArrayList<Integer> imagedescribes, String des, String repNum, String setNum, String detail_instructions) {
        this.image = image;
        this.imagedescribes = imagedescribes;
        this.des = des;
        this.repNum = repNum;
        this.setNum = setNum;
        this.detail_instructions = detail_instructions;
    }

    public Exercise() {
    }

    public Exercise(int image, ArrayList<Integer> imagedescribes, String des) {
        this.image = image;
        this.imagedescribes = imagedescribes;
        this.des = des;
    }

    public Exercise(int image, String des) {
        this.image = image;
        this.des = des;
    }

    public Exercise(int image, ArrayList<Integer> imagedescribes, String des, String detail_instructions) {
        this.image = image;
        this.imagedescribes = imagedescribes;
        this.des = des;
        this.detail_instructions = detail_instructions;
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

    public ArrayList<Integer> getImagedescribes() {
        return imagedescribes;
    }

    public void setImagedescribes(ArrayList<Integer> imagedescribes) {
        this.imagedescribes = imagedescribes;
    }

    public String getDetail_instructions() {
        return detail_instructions;
    }

    public void setDetail_instructions(String detail_instructions) {
        this.detail_instructions = detail_instructions;
    }

    public String getRepNum() {
        return repNum;
    }

    public void setRepNum(String repNum) {
        this.repNum = repNum;
    }

    public String getSetNum() {
        return setNum;
    }

    public void setSetNum(String setNum) {
        this.setNum = setNum;
    }
}
