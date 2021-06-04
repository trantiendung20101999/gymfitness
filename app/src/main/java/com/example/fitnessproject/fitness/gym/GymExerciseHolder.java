package com.example.fitnessproject.fitness.gym;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.R;

public class GymExerciseHolder extends RecyclerView.ViewHolder {

    private ImageButton imgExerciseGym;
    private TextView txtDesExerciseGym;



    public ImageButton getImgExerciseGym() {
        return imgExerciseGym;
    }

    public void setImgExerciseGym(ImageButton imgExerciseGym) {
        this.imgExerciseGym = imgExerciseGym;
    }

    public TextView getTxtDesExerciseGym() {
        return txtDesExerciseGym;
    }

    public void setTxtDesExerciseGym(TextView txtDesExerciseGym) {
        this.txtDesExerciseGym = txtDesExerciseGym;
    }

    public GymExerciseHolder(@NonNull View itemView) {
        super(itemView);
        imgExerciseGym = itemView.findViewById(R.id.imgExerciseGym);

        txtDesExerciseGym = itemView.findViewById(R.id.txtDesExerciseGym);

    }
}
