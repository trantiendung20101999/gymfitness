package com.example.fitnessproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessproject.fitness.gym.GymExerciseAdapter;
import com.example.fitnessproject.fitness.gym.ItemGymExerciseAdapter;
import com.example.fitnessproject.model.BaiTap;

import com.example.fitnessproject.model.NhomCo;
import com.example.fitnessproject.model.SectionGymExercise;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {

    Button btnvideo;
    RecyclerView recyclerView;
    ItemGymExerciseAdapterRe adapter;
    SQLiteHelper sqLiteHelper;
    TextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        Intent intent = getIntent();
        sqLiteHelper = new SQLiteHelper(this);

        BaiTap baiTap = (BaiTap) intent.getSerializableExtra("baitap");
        ImageView img = findViewById(R.id.imgEx);
        img.setImageResource(baiTap.getImage());
        youTubePlayerView.animate().scaleY(0).setInterpolator(new DecelerateInterpolator()).start();
        btnvideo = findViewById(R.id.btnVideo);
        txtTitle = findViewById(R.id.txtName);
        txtTitle.setText(baiTap.getName());
        recyclerView = findViewById(R.id.revGymFitness);
        adapter = new ItemGymExerciseAdapterRe(this);
        ArrayList<BaiTap> lists = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(baiTap.getNhomco());
        for(int i=0;i<lists.size();i++)
        {
            if(baiTap.getName().equalsIgnoreCase(lists.get(i).getName()))
            lists.remove(i);
        }
        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
        sectionGymExercises.add(new SectionGymExercise("Relative",lists));

        adapter.setData(sectionGymExercises);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnvideo.getText().toString().equalsIgnoreCase("WATCH VIDEO")) {
                    btnvideo.setText("Home");
                    youTubePlayerView.bringToFront();
                    youTubePlayerView.animate().scaleY(1).setInterpolator(new DecelerateInterpolator()).start();

                    youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                        @Override
                        public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                            String videoId = baiTap.getVideo();
                            youTubePlayer.loadVideo(videoId, 0);
                        }

                    });
                }
                else
                {
                    Intent intent1 = new Intent(ExerciseActivity.this,MainActivity.class);
                    startActivity(intent1);
                }
            }
        });



    }
}
