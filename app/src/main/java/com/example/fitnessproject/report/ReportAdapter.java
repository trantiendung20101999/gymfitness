package com.example.fitnessproject.report;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.DetailGymDayActivity;
import com.example.fitnessproject.GymDayActivity;
import com.example.fitnessproject.MainActivity;
import com.example.fitnessproject.MyReceiver;
import com.example.fitnessproject.R;
import com.example.fitnessproject.SQLiteHelper;
import com.example.fitnessproject.model.BaiTap;
import com.example.fitnessproject.model.BuoiTap;
import com.example.fitnessproject.model.BuoiTap_BaiTap;
import com.example.fitnessproject.model.NhomCo;
import com.example.fitnessproject.model.Report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportHolder> {


    private Context context;
    private ArrayList<BuoiTap> lists;

    public ReportAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<BuoiTap> getLists() {
        return lists;
    }

    public void setLists(ArrayList<BuoiTap> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReportHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report_rev,parent,false);
        return new ReportHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportHolder holder, int position) {

        BuoiTap buoiTap = lists.get(position);
        if(buoiTap==null)
        {
            return;
        }
        else
        {


            holder.itemClickListener= new ItemClickListener() {
                @Override
                public void onClick(View view, int position) {

                    if(buoiTap.getTime() == buoiTap.getTime_stop())
                    {
                        holder.linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.report_item2) );
                    }
                    else {

                        Intent intent = new Intent(context, DetailGymDayActivity.class);
                        intent.putExtra("buoitap", buoiTap);
                        context.startActivity(intent);
                    }
                }
            };

            holder.txtDate.setText(buoiTap.getDate());
            String title = "";
            List<BuoiTap_BaiTap> listsss = new SQLiteHelper(context).getBTBTByBuoiTap(buoiTap);
            Log.e("fdsfd",listsss.size()+"");
            int check[] = new int[100000];
            for(int i=0;i<listsss.size();i++)
            {
                if(listsss.get(i).getBaitap()!=null) {
                    if (check[listsss.get(i).getBaitap().getNhomco().getId()] == 0) {

                        title += "-"+listsss.get(i).getBaitap().getNhomco().getName();
                        check[listsss.get(i).getBaitap().getNhomco().getId()] = 1;
                    }
                }
            }
            holder.txtTitle.setText(title);
            if(buoiTap.getTime_stop()==0)
            {
                holder.imgCheck.setImageResource(R.drawable.ic_baseline_remove_done_24);
            }
            else if(buoiTap.getTime_stop()!=buoiTap.getTime())
            {
                holder.imgCheck.setImageResource(R.drawable.ic_baseline_rotate_left_24);
            }
            else
            {
                holder.imgCheck.setImageResource(R.drawable.ic_baseline_check_24);
            }
            if(MainActivity.compareDate(buoiTap.getDate())==-1)
            {
                holder.linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.report_item2) );
            }
            else
            {
                holder.linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.report_item));
                holder.imbDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                                    Intent intent1=new Intent();
                                    PendingIntent sender = PendingIntent.getBroadcast(v.getContext(),
                                            buoiTap.getId(), intent1,PendingIntent.FLAG_UPDATE_CURRENT);
                                    sender.cancel();
                                    lists.remove(buoiTap);
                                    new SQLiteHelper(context).delete_buoitap(buoiTap.getId());
                                    notifyDataSetChanged();
                                }
                });
            }


        }


    }

    @Override
    public int getItemCount() {
        if(lists!=null)
        {
            return lists.size();
        }
        return 0;
    }

    public interface ItemClickListener{
        public void onClick(View view , int position);

    }
    class ReportHolder extends RecyclerView.ViewHolder{

        ImageView imgCheck;
        TextView txtDate,txtTitle;
        ImageButton imbDel,imbPreview;
        LinearLayout linearLayout;

        ItemClickListener itemClickListener;

        public ReportHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            linearLayout=itemView.findViewById(R.id.linearr);
            imgCheck = itemView.findViewById(R.id.check);
            txtDate=itemView.findViewById(R.id.txtDate);
            imbDel = itemView.findViewById(R.id.imbdel);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(v,getAdapterPosition());
                }
            });
        }
    }
}
