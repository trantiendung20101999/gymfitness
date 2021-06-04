package com.example.fitnessproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.fitness.gym.GymExerciseHolder;
import com.example.fitnessproject.model.BaiTap;

import java.util.List;

public class GymExerciseAdapterDay extends RecyclerView.Adapter<GymExerciseAdapterDay.GymExerciseHolder2> {

    private Context context;
    public static  List<BaiTap> listGymEx;

    public GymExerciseAdapterDay(Context context) {
        this.context = context;
    }

    public void setData(List<BaiTap> listGymEx) {
        this.listGymEx = listGymEx;
        notifyDataSetChanged();
    }


    public class GymExerciseHolder2 extends RecyclerView.ViewHolder {

        ImageButton imgExerciseGym;
        TextView txtDesExerciseGym;

        public GymExerciseHolder2(@NonNull View itemView) {
            super(itemView);
            imgExerciseGym = itemView.findViewById(R.id.imgExerciseGym);
            txtDesExerciseGym = itemView.findViewById(R.id.txtDesExerciseGym);
        }
    }

    @NonNull
    @Override
    public GymExerciseHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gym_relative_rev, parent, false);
        return new GymExerciseHolder2(v);
    }
    // code code code no bro


    @Override
    public void onBindViewHolder(@NonNull GymExerciseHolder2 holder, int position) {

        BaiTap baiTap = listGymEx.get(position);

        if (baiTap == null) {
            return;
        } else {
            holder.imgExerciseGym.setImageResource(baiTap.getImage());

            holder.txtDesExerciseGym.setText(baiTap.getName());


            holder.imgExerciseGym.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GymDayActivity.baiTaps.add(baiTap);
                    GymDayActivity.time += baiTap.getTime()+90;
                    int min = GymDayActivity.time/60;
                    int sec = GymDayActivity.time%60;
                    int hour=0;
                    if(min>60)
                    {
                        hour=min/60;
                        min=min%60;
                    }
                    GymDayActivity.txtTime.setText("Time Complete: "+hour+":"+min+":"+sec);
                    listGymEx.remove(baiTap);
                    Log.e("ss",GymDayActivity.baiTaps.size()+"");
                    GymDayActivity.adapter2.setLists(GymDayActivity.baiTaps);
                    notifyDataSetChanged();
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


