package com.example.fitnessproject.fitness.gym;

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
import com.example.fitnessproject.fitness.FitnessViewPagerAdapter;
import com.example.fitnessproject.fitness.FragmentFitnessMain;
import com.example.fitnessproject.model.Exercise;
import com.example.fitnessproject.model.SectionGymExercise;

import java.util.ArrayList;

public class FragmentGymFitness extends Fragment {

    private RecyclerView recyclerView;

    private ItemGymExerciseAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gym_fitness,container,false);

        recyclerView = v.findViewById(R.id.revGymFitness);
        adapter = new ItemGymExerciseAdapter(v.getContext());
        adapter.setData(getAll());

        recyclerView.setHasFixedSize(false);
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
        String title1 ="Chest";
        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise(R.drawable.barbel_bench_press,"Barbell Bench Press"));
        exerciseList.add(new Exercise(R.drawable.flat_bench_dumbbell_bench_press,"Flat Bench Dumbbell Press"));
        exerciseList.add(new Exercise(R.drawable.incline_barbell_bench_press,"Low-Incline Barbell Bench Press"));
        exerciseList.add(new Exercise(R.drawable.incline_dumbbell_press,"Incline Dumbbell Press"));
        exerciseList.add(new Exercise(R.drawable.dumbbell_fly,"Dumbbell Flys"));
        exerciseList.add(new Exercise(R.drawable.machine_bench_press,"Machine Bench Press"));
        exerciseList.add(new Exercise(R.drawable.decline_dumbbell_bench_press,"Decline Dumbbell Bench Press"));
        exerciseList.add(new Exercise(R.drawable.pec_deck_machine,"Pec-deck Machine"));
        exerciseList.add(new Exercise(R.drawable.svend_press,"Svend Press"));
        exerciseList.add(new Exercise(R.drawable.cable_crossovers,"Cable Crossover"));
        exerciseList.add(new Exercise(R.drawable.chest_dips,"Chest Dips"));
        exerciseList.add(new Exercise(R.drawable.dumbbell_pullover,"Dumbbell Pullover"));

        sectionGymExercise.setHeaderTitle(title1);
        sectionGymExercise.setExerciseArrayList(exerciseList);

        SectionGymExercise sectionGymExercise2 = new SectionGymExercise();
        String title2 ="Shoulder";
        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(new Exercise(R.drawable.standing_barbell_overhead_press,"Standing Barbell Overhead Press"));
        exerciseList2.add(new Exercise(R.drawable.machine_shoulder_press,"Machine Shoulder Press"));
        exerciseList2.add(new Exercise(R.drawable.cable_overhead_press,"Cable Overhead Press"));
        exerciseList2.add(new Exercise(R.drawable.seated_overhead_dumbbell_press,"Seated Overhead Dumbbell Press"));
        exerciseList2.add(new Exercise(R.drawable.arnold_press,"Arnold Press"));
        exerciseList2.add(new Exercise(R.drawable.dumbbell_alternating_front_raise,"Dumbbell Alternating Front Raise"));
        exerciseList2.add(new Exercise(R.drawable.dumbbell_lateral_raise,"Dumbbell Lateral Raise"));
        exerciseList2.add(new Exercise(R.drawable.incline_dumbbell_front_raise,"Incline Dumbbell Font Raise"));
        exerciseList2.add(new Exercise(R.drawable.incline_dumbbell_lateral_raise,"Incline Dumbbell Lateral Raise"));
        exerciseList2.add(new Exercise(R.drawable.barbell_wide_grip_upright_row,"Barbell Wide Grip Upright Row"));
        exerciseList2.add(new Exercise(R.drawable.one_dumbbell_front_raise,"One Dumbbell Front Raise"));
        exerciseList2.add(new Exercise(R.drawable.barbell_front_raise,"Barbell Front Raise"));
        exerciseList2.add(new Exercise(R.drawable.cable_one_arm_lateral_raise,"Cable One Arm Lateral Raise"));

        sectionGymExercise2.setHeaderTitle(title2);
        sectionGymExercise2.setExerciseArrayList(exerciseList2);


        SectionGymExercise sectionGymExercise3 = new SectionGymExercise();
        String title3 ="Tricep";
        ArrayList<Exercise> exerciseList3 = new ArrayList<>();
        exerciseList3.add(new Exercise(R.drawable.bench_press,"Bench Press"));
        exerciseList3.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise3.setHeaderTitle(title3);
        sectionGymExercise3.setExerciseArrayList(exerciseList3);

        SectionGymExercise sectionGymExercise4 = new SectionGymExercise();
        String title4 ="Back";
        ArrayList<Exercise> exerciseList4 = new ArrayList<>();
        exerciseList4.add(new Exercise(R.drawable.bench_press,"Bench Press"));
        exerciseList4.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise4.setHeaderTitle(title4);
        sectionGymExercise4.setExerciseArrayList(exerciseList4);

        SectionGymExercise sectionGymExercise5 = new SectionGymExercise();
        String title5 ="Bicep";
        ArrayList<Exercise> exerciseList5 = new ArrayList<>();
        exerciseList5.add(new Exercise(R.drawable.bench_press,"Bench Press"));
        exerciseList5.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise5.setHeaderTitle(title5);
        sectionGymExercise5.setExerciseArrayList(exerciseList5);

        SectionGymExercise sectionGymExercise6 = new SectionGymExercise();
        String title6 ="ABS";
        ArrayList<Exercise> exerciseList6 = new ArrayList<>();
        exerciseList6.add(new Exercise(R.drawable.bench_press,"Bench Press"));
        exerciseList6.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise6.setHeaderTitle(title6);
        sectionGymExercise6.setExerciseArrayList(exerciseList6);

        SectionGymExercise sectionGymExercise7 = new SectionGymExercise();
        String title7 ="Leg";
        ArrayList<Exercise> exerciseList7 = new ArrayList<>();
        exerciseList7.add(new Exercise(R.drawable.bench_press,"Bench Press"));
        exerciseList7.add(new Exercise(R.drawable.bench_press,"Bench Press 2"));
        sectionGymExercise7.setHeaderTitle(title7);
        sectionGymExercise7.setExerciseArrayList(exerciseList7);

        sectionGymExerciseList.add(sectionGymExercise);
        sectionGymExerciseList.add(sectionGymExercise2);
        sectionGymExerciseList.add(sectionGymExercise3);
        sectionGymExerciseList.add(sectionGymExercise4);
        sectionGymExerciseList.add(sectionGymExercise5);
        sectionGymExerciseList.add(sectionGymExercise6);
        sectionGymExerciseList.add(sectionGymExercise7);



        return sectionGymExerciseList;

    }


}
