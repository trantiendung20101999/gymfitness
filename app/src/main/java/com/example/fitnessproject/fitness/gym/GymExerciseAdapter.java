package com.example.fitnessproject.fitness.gym;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.ExerciseActivity;
import com.example.fitnessproject.MainActivity;
import com.example.fitnessproject.R;
import com.example.fitnessproject.model.Exercise;

import java.util.List;

public class GymExerciseAdapter  extends RecyclerView.Adapter<GymExerciseHolder> {

    private Context context;
    private List<Exercise> listGymEx;

    public GymExerciseAdapter(Context context)
    {
        this.context = context;
    }

    public void setData(List<Exercise> listGymEx)
    {
        this.listGymEx = listGymEx;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GymExerciseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gym_rev,parent,false);
        return new GymExerciseHolder(v);
    }
    // code code code conflict

    @Override
    public void onBindViewHolder(@NonNull GymExerciseHolder holder, int position) {

        Exercise exercise = listGymEx.get(position);

        if(exercise ==null)
        {
            return;
        }
        else
        {
            ImageButton imgGymEx = holder.getImgExerciseGym();
            imgGymEx.setImageResource(exercise.getImage());
            holder.setImgExerciseGym(imgGymEx);
            TextView txtGymEx = holder.getTxtDesExerciseGym();
            txtGymEx.setText(exercise.getDes());
            holder.setTxtDesExerciseGym(txtGymEx);

            imgGymEx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ExerciseActivity.class);
                    intent.putExtra("exercise",exercise);
                    context.startActivity(intent);
                }
            });
        }


    }

    @Override
    public int getItemCount() {

        if(listGymEx!=null)
        {
            return listGymEx.size();
        }

        return 0;
    }
}
