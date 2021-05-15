package com.example.fitnessproject.model;

import java.util.ArrayList;

public class SectionGymExercise {

    private String headerTitle;
    private ArrayList<Exercise> exerciseArrayList;

    public SectionGymExercise() {
    }

    public SectionGymExercise(String headerTitle, ArrayList<Exercise> exerciseArrayList) {
        this.headerTitle = headerTitle;
        this.exerciseArrayList = exerciseArrayList;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<Exercise> getExerciseArrayList() {
        return exerciseArrayList;
    }

    public void setExerciseArrayList(ArrayList<Exercise> exerciseArrayList) {
        this.exerciseArrayList = exerciseArrayList;
    }
}
