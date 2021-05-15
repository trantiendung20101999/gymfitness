package com.example.fitnessproject.fitness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.fitnessproject.MainActivity;
import com.example.fitnessproject.fitness.calender.FragmentCalenderFitness;
import com.example.fitnessproject.fitness.calisthenics.FragmentCalisthenicsFitness;
import com.example.fitnessproject.fitness.gym.FragmentGymFitness;

public class FitnessViewPagerAdapter extends FragmentStatePagerAdapter {


    public FitnessViewPagerAdapter(@NonNull FragmentManager fm , int behavior)
    {
        super(fm,behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: {
                return new FragmentGymFitness();
            }

            case 1: {
                return new FragmentCalisthenicsFitness();
            }

            case 2: {
                return new FragmentCalenderFitness();
            }

            default: {
                return new FragmentGymFitness();
            }

        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0: return "Gym";

            case 1: return "Calisthenics";

            case 2: return "Calender";

            default: return "Gym";
        }
    }
}
