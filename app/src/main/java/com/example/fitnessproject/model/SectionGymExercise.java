package com.example.fitnessproject.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SectionGymExercise implements Serializable {

    private String headerTitle;
    private ArrayList<BaiTap> baiTapArrayList;

    public SectionGymExercise() {
    }

    public SectionGymExercise(String headerTitle, ArrayList<BaiTap> baiTapArrayList) {
        this.headerTitle = headerTitle;
        this.baiTapArrayList = baiTapArrayList;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<BaiTap> getBaiTapArrayList() {
        return baiTapArrayList;
    }

    public void setBaiTapArrayList(ArrayList<BaiTap> baiTapArrayList) {
        this.baiTapArrayList = baiTapArrayList;
    }
}
