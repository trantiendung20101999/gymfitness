package com.example.fitnessproject.fitness.calisthenics;

import android.os.Bundle;
import android.util.Log;
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
import com.example.fitnessproject.SQLiteHelper;
import com.example.fitnessproject.fitness.FragmentFitnessMain;
import com.example.fitnessproject.fitness.gym.ItemGymExerciseAdapter;
import com.example.fitnessproject.model.BaiTap;
import com.example.fitnessproject.model.NhomCo;
import com.example.fitnessproject.model.SectionGymExercise;

import java.util.ArrayList;
import java.util.List;

public class FragmentCalisthenicsFitness extends Fragment {
    private RecyclerView recyclerView;

    private ItemGymExerciseAdapter adapter;

    SQLiteHelper sqLiteHelper ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gym_fitness,container,false);

        sqLiteHelper = new SQLiteHelper(v.getContext());
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
        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
        List<NhomCo> lists = sqLiteHelper.getAll_Nhomco();

        for (int i=0;i<lists.size();i++)
        {

            ArrayList<BaiTap> listBaiTap = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(lists.get(i));
            ArrayList<BaiTap> listend = new ArrayList<>();
            for(int j=0;j<listBaiTap.size();j++)
            {
                if(listBaiTap.get(j).getName().contains("At Home"))
                {
                    listend.add(listBaiTap.get(j));
                }

            }
            sectionGymExercises.add(new SectionGymExercise(lists.get(i).getName(),listend));
        }
        return sectionGymExercises;
    }



}
