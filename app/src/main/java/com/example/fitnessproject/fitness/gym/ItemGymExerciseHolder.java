package com.example.fitnessproject.fitness.gym;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.R;

public class ItemGymExerciseHolder extends RecyclerView.ViewHolder {

    private TextView txtTitleBodyGym;
    private RecyclerView revBodyGym;


    public ItemGymExerciseHolder(@NonNull View itemView) {
        super(itemView);

        txtTitleBodyGym = itemView.findViewById(R.id.txtTitleBodyGym);
        revBodyGym = itemView.findViewById(R.id.revBodyGym);
    }

    public TextView getTxtTitleBodyGym() {
        return txtTitleBodyGym;
    }

    public void setTxtTitleBodyGym(TextView txtTitleBodyGym) {
        this.txtTitleBodyGym = txtTitleBodyGym;
    }

    public RecyclerView getRevBodyGym() {
        return revBodyGym;
    }

    public void setRevBodyGym(RecyclerView revBodyGym) {
        this.revBodyGym = revBodyGym;
    }
}
