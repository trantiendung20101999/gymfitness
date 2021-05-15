package com.example.fitnessproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.fitnessproject.fitness.FragmentFitnessMain;
import com.example.fitnessproject.history.FragmentHistoryMain;
import com.example.fitnessproject.report.FragmentReportMain;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    private int pageNum;
    public MainViewPagerAdapter(@NonNull FragmentManager fm , int behavior)
    {
        super(fm,behavior);
        this.pageNum = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new FragmentFitnessMain();

            case 1: return new FragmentHistoryMain();

            case 2: return new FragmentReportMain();

            default: return new FragmentFitnessMain();
        }
    }

    @Override
    public int getCount() {
        return pageNum;
    }
}
