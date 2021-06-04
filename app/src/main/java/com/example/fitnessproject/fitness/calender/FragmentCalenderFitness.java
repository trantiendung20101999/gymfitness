package com.example.fitnessproject.fitness.calender;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.MainActivity;
import com.example.fitnessproject.R;
import com.example.fitnessproject.fitness.FragmentFitnessMain;
import com.example.fitnessproject.fitness.gym.ItemGymExerciseAdapter;
import com.example.fitnessproject.model.BaiTap;
import com.example.fitnessproject.model.SectionGymExercise;

import java.util.ArrayList;

public class FragmentCalenderFitness extends Fragment {
    private RecyclerView recyclerView;

    private ItemGymExerciseAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gym_fitness,container,false);

        recyclerView = v.findViewById(R.id.revGymFitness);
        adapter = new ItemGymExerciseAdapter(v.getContext());
//        adapter.setData(getAll());

        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy>20)
                {

                    MainActivity.hidebotnav();
                }
                else if(dy< -20){

                    MainActivity.showbotnav();
                }
                if(dy>20)
                {
                    FragmentFitnessMain.showTablayout();
                }
                else if(dy<-20)
                {
                    FragmentFitnessMain.hideTablayout();
                }
            }
        });

        return  v;

    }

//    public ArrayList<SectionGymExercise> getAll()
//    {
//        ArrayList<SectionGymExercise> sectionGymExerciseList = new ArrayList<>();
//
//        SectionGymExercise sectionGymExercise = new SectionGymExercise();
//        String title1 ="Bro Split";
//        ArrayList<BaiTap> baiTapList = new ArrayList<>();
//        baiTapList.add(new BaiTap(R.drawable.chest,"Monday"));
//        sectionGymExercise.setHeaderTitle(title1);
//        sectionGymExercise.setBaiTapArrayList(baiTapList);
//
//        SectionGymExercise sectionGymExercise2 = new SectionGymExercise();
//        String title2 ="Fullbody";
//        ArrayList<BaiTap> baiTapList2 = new ArrayList<>();
//        baiTapList2.add(new BaiTap(R.drawable.squats,"Squat"));
//        sectionGymExercise2.setHeaderTitle(title2);
//        sectionGymExercise2.setBaiTapArrayList(baiTapList2);
//
//        SectionGymExercise sectionGymExercise3 = new SectionGymExercise();
//        String title3 ="Upper - Lower Body";
//        ArrayList<BaiTap> baiTapList3 = new ArrayList<>();
//        baiTapList3.add(new BaiTap(R.drawable.bench_press,"Bench Press"));
//        sectionGymExercise3.setHeaderTitle(title3);
//        sectionGymExercise3.setBaiTapArrayList(baiTapList3);
//
//        SectionGymExercise sectionGymExercise4 = new SectionGymExercise();
//        String title4 ="Push-Pull-Leg";
//        ArrayList<BaiTap> baiTapList4 = new ArrayList<>();
//        baiTapList4.add(new BaiTap(R.drawable.bench_press,"Bench Press"));
//        sectionGymExercise4.setHeaderTitle(title4);
//        sectionGymExercise4.setBaiTapArrayList(baiTapList4);
//
//
//        sectionGymExerciseList.add(sectionGymExercise);
//        sectionGymExerciseList.add(sectionGymExercise2);
//        sectionGymExerciseList.add(sectionGymExercise3);
//        sectionGymExerciseList.add(sectionGymExercise4);
//
//
//        return sectionGymExerciseList;
//
//    }


}
