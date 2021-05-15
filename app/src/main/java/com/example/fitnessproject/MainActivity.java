package com.example.fitnessproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    static AnimatedBottomBar navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPagerMain);
        navigationView = findViewById(R.id.navbotMain);
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(mainViewPagerAdapter);
        navigationView.setupWithViewPager(viewPager);
//        viewPager.addOnPageChangeListener(
//                new ViewPager.OnPageChangeListener() {
//
//
//                    @Override
//                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//                    }
//
//                    @Override
//                    public void onPageSelected(int position) {
//
//                        switch (position){
//
//                            case 0: {
//                                navigationView.getMenu().findItem(R.id.mNavMainFitness).setChecked(true);
//                            }
//
//                            case 1: {
//                                navigationView.getMenu().findItem(R.id.mNavMainHistory).setChecked(true);
//                            }
//
//                            case 2: {
//                                navigationView.getMenu().findItem(R.id.mNavMainReport).setChecked(true);
//                            }
//
//                        }
//
//                    }
//
//                    @Override
//                    public void onPageScrollStateChanged(int state) {
//
//                    }
//                }
//        );
//
//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId())
//                {
//                    case R.id.mNavMainFitness:
//                    {
//                        viewPager.setCurrentItem(0);
//                        break;
//                    }
//                    case R.id.mNavMainHistory:
//                    {
//                        viewPager.setCurrentItem(1);
//                        break;
//                    }
//                    case R.id.mNavMainReport:
//                    {
//                        viewPager.setCurrentItem(2);
//                    }
//                }
//                return true;
//            }
//        });

    }

    public static void hidebotnav()
    {

        navigationView.animate().scaleY(0).setInterpolator(new DecelerateInterpolator()).start();
//        navigationView.setVisibility(View.GONE);
    }

    public static void showbotnav()
    {


        navigationView.animate().scaleY(1).setInterpolator(new DecelerateInterpolator()).start();

    }
}