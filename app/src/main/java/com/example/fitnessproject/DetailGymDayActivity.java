package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fitnessproject.model.BaiTap;
import com.example.fitnessproject.model.BuoiTap;
import com.example.fitnessproject.model.BuoiTap_BaiTap;
import com.example.fitnessproject.model.SectionGymExercise;

import java.util.ArrayList;
import java.util.List;

public class DetailGymDayActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public static ItemGymExerciseAdapterRe adapter;
    TextView txtTime,txtTimeline;
    Button btnStart,btnStop,btnComplete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gym_day);
        recyclerView = findViewById(R.id.revGymFitness);
        adapter = new ItemGymExerciseAdapterRe(this);
        Intent intent = getIntent();
        txtTime = findViewById(R.id.txtTime);

        txtTimeline = findViewById(R.id.txtLine);
        BuoiTap buoiTap = (BuoiTap) intent.getSerializableExtra("buoitap");
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);
        List<BuoiTap_BaiTap> listss = sqLiteHelper.getBTBTByBuoiTap(buoiTap);
        ArrayList<BaiTap> lists = new ArrayList<>();
        for(int i=0;i<listss.size();i++)
        {
            lists.add(listss.get(i).getBaitap());
        }

        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
        sectionGymExercises.add(new SectionGymExercise("Your exercise",lists));
        adapter.setData(sectionGymExercises);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        //
        int min = buoiTap.getTime()/60;
        int sec = buoiTap.getTime()%60;
        int hour=0;
        if(min>60)
        {
            hour=min/60;
            min=min%60;
        }
        txtTime.setText("Time Complete: "+hour+":"+min+":"+sec);
        final int[] time = new int[1];
        if(buoiTap.getTime_stop()==0) {
            time[0] = buoiTap.getTime();
        }
        else
        {
            time[0] = buoiTap.getTime_stop();
        }

        ConstraintLayout constraintLayout = findViewById(R.id.constraint);
        constraintLayout.animate().scaleY(0).setInterpolator(new DecelerateInterpolator()).start();
        final boolean[] isStop = {false};
        TextView txtTimeremain = findViewById(R.id.txtTimeRemain);

        ProgressBar progressBar = findViewById(R.id.Progressbar);

        CountDownTimer countDownTimer = new CountDownTimer(time[0] *1000, 1000) {

            public void onTick(long millisUntilFinished) {

                if(isStop[0])
                {
                    cancel();
                }
                else {
                    txtTimeline.setText((millisUntilFinished / 1000) + "");
                    progressBar.setProgress((int)(millisUntilFinished*100)/time[0]);
                    int temp = Integer.parseInt(txtTimeline.getText().toString());
                    int min = temp/60;
                    int sec = temp%60;
                    int hour=0;
                    if(min>60)
                    {
                        hour=min/60;
                        min=min%60;
                    }
                    txtTimeremain.setText("Time Complete: "+hour+":"+min+":"+sec);

                }

            }

            public void onFinish() {

                buoiTap.setTime_stop(buoiTap.getTime());
                sqLiteHelper.update_Buoitap(buoiTap);
                Intent intent1 = new Intent(DetailGymDayActivity.this,MainActivity.class);
                startActivity(intent1);

            }
        };
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        MediaPlayer ring = MediaPlayer.create(DetailGymDayActivity.this, R.raw.music2);
        CheckBox cb = findViewById(R.id.cbMusic);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    ring.start();
                }
                else
                {
                    ring.pause();
                }
            }
        });
            btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayout.animate().scaleY(1).setInterpolator(new DecelerateInterpolator()).start();
                if(btnStart.getText().toString().equalsIgnoreCase("start"))
                {
                    countDownTimer.start();
                    btnStart.setText("RESUME");
                }
                else
                {
                isStop[0]=false;
                int timeremain = Integer.parseInt(txtTimeline.getText().toString());
                CountDownTimer countDownTimer1 = new CountDownTimer(timeremain*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if(isStop[0])
                        {
                            cancel();
                        }
                        else
                        {
                            txtTimeline.setText((millisUntilFinished / 1000) + "");
                            progressBar.setProgress((int)(millisUntilFinished*100)/time[0]);
                            int temp = Integer.parseInt(txtTimeline.getText().toString());
                            int min = temp/60;
                            int sec = temp%60;
                            int hour=0;
                            if(min>60)
                            {
                                hour=min/60;
                                min=min%60;
                            }
                            txtTimeremain.setText("Time Complete: "+hour+":"+min+":"+sec);
                        }
                    }

                    @Override
                    public void onFinish() {
                        buoiTap.setTime_stop(buoiTap.getTime());
                        sqLiteHelper.update_Buoitap(buoiTap);
                        Intent intent1 = new Intent(DetailGymDayActivity.this,MainActivity.class);
                        startActivity(intent1);
                    }
                };
                countDownTimer1.start();
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayout.animate().scaleY(0).setInterpolator(new DecelerateInterpolator()).start();
                isStop[0] =true;
            }
        });

        btnComplete = findViewById(R.id.btnComplete);
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ring.stop();
                buoiTap.setTime_stop(Integer.parseInt(txtTimeline.getText().toString()));
                sqLiteHelper.update_Buoitap(buoiTap);
                isStop[0]=true;
                Intent intent1 = new Intent(DetailGymDayActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });


    }
}