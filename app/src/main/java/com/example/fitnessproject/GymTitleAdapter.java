package com.example.fitnessproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.model.BaiTap;
import com.example.fitnessproject.model.SectionGymExercise;

import java.util.ArrayList;
import java.util.List;

public class GymTitleAdapter extends RecyclerView.Adapter<GymTitleAdapter.TitleHolder> {

    public static List<BaiTap> lists;
    private Context mContext;

    public GymTitleAdapter(Context mContext) {
        this.mContext = mContext;
    }


    public GymTitleAdapter(List<BaiTap> lists) {
        this.lists = lists;
    }

    public List<BaiTap> getLists() {
        return lists;
    }

    public void setLists(List<BaiTap> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TitleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gym_title,parent,false);

        return new TitleHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TitleHolder holder, int position) {

        BaiTap baiTap = lists.get(position);
        Log.e("sfdsfds",baiTap.getName());
        if(baiTap!=null)
        {
            holder.txtTitle.setText(baiTap.getName());
            holder.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lists.remove(baiTap);
                    GymDayActivity.time -= baiTap.getTime();
                    GymDayActivity.time -= 90;
                    int min = GymDayActivity.time/60;
                    int sec = GymDayActivity.time%60;
                    int hour=0;
                    if(min>60)
                    {
                        hour=min/60;
                        min=min%60;
                    }
                    GymDayActivity.txtTime.setText("Time Complete: "+hour+":"+min+":"+sec);
                    GymExerciseAdapterDay.listGymEx.add(baiTap);
                    ArrayList<BaiTap> listss = (ArrayList<BaiTap>) GymExerciseAdapterDay.listGymEx;
                    ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
                    sectionGymExercises.add(new SectionGymExercise("Choose exercise",listss));
                    GymDayActivity.adapter.setData(sectionGymExercises);
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(lists==null)
        {
            return 0;
        }
        return lists.size();
    }

    class TitleHolder extends RecyclerView.ViewHolder{


        TextView txtTitle;
        ImageButton imageButton;
        public TitleHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtDesExerciseGym);
            imageButton=itemView.findViewById(R.id.delete);
        }
    }
}
