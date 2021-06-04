package com.example.fitnessproject.fitness.gym;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.example.fitnessproject.model.BaiTap;

import java.util.List;

public class GymExerciseAdapter  extends RecyclerView.Adapter<GymExerciseHolder> {

    private Context context;
    private List<BaiTap> listGymEx;

    public GymExerciseAdapter(Context context)
    {
        this.context = context;
    }

    public void setData(List<BaiTap> listGymEx)
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
    // code code code no bro


    @Override
    public void onBindViewHolder(@NonNull GymExerciseHolder holder, int position) {

        BaiTap baiTap = listGymEx.get(position);

        if(baiTap ==null)
        {
            return;
        }
        else
        {
            ImageButton imgGymEx = holder.getImgExerciseGym();
            imgGymEx.setImageResource(baiTap.getImage());
            holder.setImgExerciseGym(imgGymEx);
            TextView txtGymEx = holder.getTxtDesExerciseGym();
            txtGymEx.setText(baiTap.getName());
            holder.setTxtDesExerciseGym(txtGymEx);

            imgGymEx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ExerciseActivity.class);
                    intent.putExtra("baitap", baiTap);
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
