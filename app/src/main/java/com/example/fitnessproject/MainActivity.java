package com.example.fitnessproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.example.fitnessproject.model.NhomCo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    static AnimatedBottomBar navigationView;
    public static int count ;
    SQLiteHelper sqLiteHelper = new SQLiteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPagerMain);
        navigationView = findViewById(R.id.navbotMain);

//        addALL_nhomco();
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

    public void addALL_nhomco()
    {
        sqLiteHelper.addNhomCo(new NhomCo("CHEST"));
        sqLiteHelper.addNhomCo(new NhomCo("SHOULDER"));
        sqLiteHelper.addNhomCo(new NhomCo("TRICEP"));
        sqLiteHelper.addNhomCo(new NhomCo("BICEP"));
        sqLiteHelper.addNhomCo(new NhomCo("BACK"));
        sqLiteHelper.addNhomCo(new NhomCo("LEG"));
        sqLiteHelper.addNhomCo(new NhomCo("ABS"));
    }
    public static int compareDate(String date)
    {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd/HH:mm").format(Calendar.getInstance().getTime());

        String Date = date;

        String[] timeCurrent = timeStamp.split("/");
        String[] timeSelect = Date.split("/");

        try {
            int dayCurrent = Integer.parseInt(timeCurrent[2]);
            int monthCurrent = Integer.parseInt(timeCurrent[1]);
            int yearCurrent = Integer.parseInt(timeCurrent[0]);
            String[] timee = timeCurrent[3].split(":");
            int hourCurrent = Integer.parseInt(timee[0]);
            int minCurrent = Integer.parseInt(timee[1]);

            int daySelect = Integer.parseInt(timeSelect[2]);
            int monthSelect = Integer.parseInt(timeSelect[1]);
            int yearSelect = Integer.parseInt(timeSelect[0]);
            String[] timee2 = timeSelect[3].split(":");
            int hourSelect = Integer.parseInt(timee2[0]);
            int minSelect = Integer.parseInt(timee2[1]);

            if (dayCurrent + monthCurrent * 30 + yearCurrent * 365 > daySelect + monthSelect * 30 + yearSelect * 365) {
                return -1;
            }
            else if (dayCurrent+monthCurrent*30+yearCurrent*365 == daySelect+monthSelect*30+yearSelect*365) {
                if (hourCurrent * 60 + minCurrent > hourSelect * 60 + minSelect) {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                return 1;
            }
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }
}