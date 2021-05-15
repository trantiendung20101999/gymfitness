package com.example.fitnessproject.fitness;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.fitnessproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class FragmentFitnessMain extends Fragment {

    private static TabLayout tabLayout;

    private FloatingActionButton fab;
    private ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fitness_main,container,false);

        tabLayout = v.findViewById(R.id.tabFitness);
        viewPager = v.findViewById(R.id.viewpagerFitness);
        fab= v.findViewById(R.id.fab);

        FitnessViewPagerAdapter fitnessViewPagerAdapter = new FitnessViewPagerAdapter(getChildFragmentManager(),3);

        viewPager.setAdapter(fitnessViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_muscle);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pull_up);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_calendar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }
    public static void showTablayout()
    {
//        tabLayout.animate().scaleY(1).setInterpolator(new DecelerateInterpolator()).start();
//        tabLayout.setVisibility(View.VISIBLE);
    }
    public static void hideTablayout()
    {
//        tabLayout.animate().scaleY(0).setInterpolator(new DecelerateInterpolator()).start();
//        tabLayout.setVisibility(View.GONE);
    }
}
