package com.example.fitnessproject.fitness.calisthenics;

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
import com.example.fitnessproject.model.Exercise;
import com.example.fitnessproject.model.SectionGymExercise;

import java.util.ArrayList;

public class FragmentCalisthenicsFitness extends Fragment {
    private RecyclerView recyclerView;

    private ItemGymExerciseAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gym_fitness,container,false);

        recyclerView = v.findViewById(R.id.revGymFitness);
        adapter = new ItemGymExerciseAdapter(v.getContext());
        adapter.setData(getAll());

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

    public ArrayList<SectionGymExercise> getAll()
    {
        ArrayList<SectionGymExercise> sectionGymExerciseList = new ArrayList<>();

        SectionGymExercise sectionGymExercise = new SectionGymExercise();
        String title1 ="Pull up";
        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise(R.drawable.pull_up,"Pull up basic"));
        exerciseList.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise.setHeaderTitle(title1);
        sectionGymExercise.setExerciseArrayList(exerciseList);

        SectionGymExercise sectionGymExercise2 = new SectionGymExercise();
        String title2 ="Inverted Row";
        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(new Exercise(R.drawable.inverted_row,"inverted row basic"));
        exerciseList2.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise2.setHeaderTitle(title2);
        sectionGymExercise2.setExerciseArrayList(exerciseList2);

        SectionGymExercise sectionGymExercise3 = new SectionGymExercise();
        String title3 ="Dip";
        ArrayList<Exercise> exerciseList3 = new ArrayList<>();
        exerciseList3.add(new Exercise(R.drawable.bench_press,"Bench Press"));
        exerciseList3.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise3.setHeaderTitle(title3);
        sectionGymExercise3.setExerciseArrayList(exerciseList3);

        SectionGymExercise sectionGymExercise4 = new SectionGymExercise();
        String title4 ="Push up";
        ArrayList<Exercise> exerciseList4 = new ArrayList<>();
        exerciseList4.add(new Exercise(R.drawable.bench_press,"Bench Press"));
        exerciseList4.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise4.setHeaderTitle(title4);
        sectionGymExercise4.setExerciseArrayList(exerciseList4);

        SectionGymExercise sectionGymExercise5 = new SectionGymExercise();
        String title5 ="Crunches";
        ArrayList<Exercise> exerciseList5 = new ArrayList<>();
        exerciseList5.add(new Exercise(R.drawable.bench_press,"Bench Press"));
        exerciseList5.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise5.setHeaderTitle(title5);
        sectionGymExercise5.setExerciseArrayList(exerciseList5);



        sectionGymExerciseList.add(sectionGymExercise);
        sectionGymExerciseList.add(sectionGymExercise2);
        sectionGymExerciseList.add(sectionGymExercise3);
        sectionGymExerciseList.add(sectionGymExercise4);
        sectionGymExerciseList.add(sectionGymExercise5);


        return sectionGymExerciseList;

    }


}
