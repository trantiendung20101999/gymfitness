package com.example.fitnessproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.fitness.gym.ItemGymExerciseHolder;
import com.example.fitnessproject.model.SectionGymExercise;

import java.util.ArrayList;

public class ItemGymExerciseAdapterDay extends RecyclerView.Adapter<ItemGymExerciseHolder> {

    private Context mContext;
    private ArrayList<SectionGymExercise> sectionGymExerciseArrayList;

    public ItemGymExerciseAdapterDay(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(ArrayList<SectionGymExercise> sectionGymExerciseArrayList)
    {
        this.sectionGymExerciseArrayList = sectionGymExerciseArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemGymExerciseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_gym_fitness,parent,false);
        return new ItemGymExerciseHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemGymExerciseHolder holder, int position) {

        String title = sectionGymExerciseArrayList.get(position).getHeaderTitle();

        ArrayList listGymExercise = sectionGymExerciseArrayList.get(position).getBaiTapArrayList();

        GymExerciseAdapterDay adapter = new GymExerciseAdapterDay(mContext);
        adapter.setData(listGymExercise);


        TextView txttitle = holder.getTxtTitleBodyGym();
        RecyclerView recyclerView = holder.getRevBodyGym();

        txttitle.setText(title);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);

        holder.setRevBodyGym(recyclerView);
        holder.setTxtTitleBodyGym(txttitle);

    }

    @Override
    public int getItemCount() {

        if(sectionGymExerciseArrayList!=null)
        {
            return sectionGymExerciseArrayList.size();
        }

        return 0;
    }
}
