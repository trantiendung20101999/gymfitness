package com.example.fitnessproject.report;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.GymDayActivity;
import com.example.fitnessproject.MainActivity;
import com.example.fitnessproject.R;
import com.example.fitnessproject.SQLiteHelper;
import com.example.fitnessproject.fitness.FragmentFitnessMain;
import com.example.fitnessproject.model.BuoiTap;
import com.example.fitnessproject.model.Report;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

public class FragmentReportMain extends Fragment {

    RecyclerView rev;
    SQLiteHelper sqLiteHelper;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_report_main,container,false);

        rev = v.findViewById(R.id.revReport);
        ReportAdapter adapter = new ReportAdapter(v.getContext());
        sqLiteHelper = new SQLiteHelper(v.getContext());

        FloatingActionButton fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GymDayActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        ArrayList<BuoiTap> lists = (ArrayList<BuoiTap>) sqLiteHelper.getAll_BuoiTap();
        ArrayList<BuoiTap> list2 = new ArrayList<>();
        Log.e("size",lists.size()+"");
        for(int i=0; i<lists.size() ;i++) {

            Log.e("i",i+"");
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd/HH:mm").format(Calendar.getInstance().getTime());

            String Date = lists.get(i).getDate();

            String[] timeCurrent = timeStamp.split("/");
            String[] timeSelect = Date.split("/");

            try {
                int dayCurrent = Integer.parseInt(timeCurrent[2]);
                int monthCurrent = Integer.parseInt(timeCurrent[1]);
                int yearCurrent = Integer.parseInt(timeCurrent[0]);
                String[] timee = timeCurrent[3].split(":");
                int hourCurrent = Integer.parseInt(timee[0]);
                int minCurrent = Integer.parseInt(timee[1]);

                int daySelect = Integer.parseInt(timeSelect[2]);
                int monthSelect = Integer.parseInt(timeSelect[1]);
                int yearSelect = Integer.parseInt(timeSelect[0]);
                String[] timee2 = timeSelect[3].split(":");
                int hourSelect = Integer.parseInt(timee2[0]);
                int minSelect = Integer.parseInt(timee2[1]);


                if (dayCurrent + monthCurrent * 30 + yearCurrent * 365 > daySelect + monthSelect * 30 + yearSelect * 365) {
                    list2.add(lists.get(i));

                    lists.remove(i);
                    i--;
                }
                else if (dayCurrent+monthCurrent*30+yearCurrent*365 == daySelect+monthSelect*30+yearSelect*365) {

                    if (hourCurrent * 60 + minCurrent > hourSelect * 60 + minSelect) {
                        list2.add(lists.get(i));
                        lists.remove(i);
                        i--;
                    }

                }


            }
            catch (NumberFormatException e)
            {
                Log.e("bug","bug");
            }
        }

        list2.sort(new Comparator<BuoiTap>() {
            @Override
            public int compare(BuoiTap o1, BuoiTap o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
        lists.addAll(list2);

        adapter.setLists(lists);
        rev.setAdapter(adapter);
        rev.setLayoutManager(new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false));
        rev.addOnScrollListener(                        new RecyclerView.OnScrollListener() {
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
        return v;
    }

}
