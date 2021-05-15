package com.example.fitnessproject.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.R;
import com.example.fitnessproject.model.Report;

import java.util.ArrayList;

public class FragmentReportMain extends Fragment {

    RecyclerView rev;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_report_main,container,false);

        rev = v.findViewById(R.id.revReport);
        ReportAdapter adapter = new ReportAdapter(v.getContext());
        adapter.setData(getAll());
        rev.setAdapter(adapter);
        rev.setLayoutManager(new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false));


        return v;
    }

    public ArrayList<Report> getAll(){

        ArrayList<Report> all = new ArrayList<>();

        Report report = new Report(R.drawable.ic_fitness,"Thống kê về cường độ tập gym ");
        all.add(report);
        Report report1 = new Report(R.drawable.ic_history,"Thống kê về cân nặng ");
        all.add(report1);
        return all;

    }
}
