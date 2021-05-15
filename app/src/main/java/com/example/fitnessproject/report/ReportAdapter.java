package com.example.fitnessproject.report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.R;
import com.example.fitnessproject.model.Report;

import java.util.ArrayList;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportHolder> {


    private Context context;
    private ArrayList<Report> listreport;

    public ReportAdapter(Context context) {
        this.context = context;
    }
    public void setData(ArrayList<Report> listreport)
    {
        this.listreport = listreport;
    }

    @NonNull
    @Override
    public ReportHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report_rev,parent,false);
        return new ReportHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportHolder holder, int position) {

        Report report = listreport.get(position);
        if(report==null)
        {
            return;
        }
        else
        {
            holder.imgReport.setImageResource(report.getImage());
            holder.txtReport.setText(report.getDes());
        }


    }

    @Override
    public int getItemCount() {
        if(listreport!=null)
        {
            return listreport.size();
        }
        return 0;
    }

    class ReportHolder extends RecyclerView.ViewHolder{

        ImageView imgReport;
        TextView txtReport;


        public ReportHolder(@NonNull View itemView) {
            super(itemView);

            imgReport = itemView.findViewById(R.id.imgReportItem);
            txtReport = itemView.findViewById(R.id.txtDescribeItem);
        }
    }
}
