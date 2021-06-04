package com.example.fitnessproject.history;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fitnessproject.R;
import com.example.fitnessproject.SQLiteHelper;
import com.example.fitnessproject.model.BuoiTap;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentHistoryMain extends Fragment implements OnChartValueSelectedListener {

    private CombinedChart mChart;
    SQLiteHelper sqLiteHelper;
    static ArrayList<BuoiTap>lists;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history_main, container, false);

        sqLiteHelper = new SQLiteHelper(v.getContext());
        mChart = (CombinedChart) v.findViewById(R.id.combinedChart);
        FragmentHistoryMain.lists= (ArrayList<BuoiTap>) sqLiteHelper.getAll_BuoiTap();
        mChart.getDescription().setEnabled(false);
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawGridBackground(false);
        mChart.setDrawBarShadow(false);
        mChart.setHighlightFullBarEnabled(false);
        mChart.setOnChartValueSelectedListener(this);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f);

        final List<String> xLabel = new ArrayList<>();
        xLabel.add("Jan");
        xLabel.add("Feb");
        xLabel.add("Mar");
        xLabel.add("Apr");
        xLabel.add("May");
        xLabel.add("Jun");
        xLabel.add("Jul");
        xLabel.add("Aug");
        xLabel.add("Sep");
        xLabel.add("Oct");
        xLabel.add("Nov");
        xLabel.add("Dec");

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xLabel.get((int) value % xLabel.size());
            }
        });

        CombinedData data = new CombinedData();
        LineData lineDatas = new LineData();
        lineDatas.addDataSet((ILineDataSet) dataChart());

        data.setData(lineDatas);

        xAxis.setAxisMaximum(data.getXMax() + 0.25f);

        mChart.setData(data);
        mChart.invalidate();
        return v;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    private static DataSet dataChart() {

        LineData d = new LineData();
        List<BuoiTap> lists = FragmentHistoryMain.lists;
        int[] data = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for(int i=0;i<lists.size();i++)
        {
            String time = lists.get(i).getDate();

            String[] timeCurrent = time.split("/");
            int monthCurrent = Integer.parseInt(timeCurrent[1]);

            switch (monthCurrent)
            {
                case 1:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[0]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[0]+=lists.get(i).getTime();
                    }
                    break;
                }
                case 2:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[1]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[1]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 3:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[2]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[2]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 4:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[3]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[3]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 5:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[4]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[4]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 6:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[5]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[5]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 7:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[6]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[6]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 8:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[7]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[7]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 9:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[8]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[8]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 10:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[9]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[9]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 11:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[10]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[10]+=lists.get(i).getTime();
                    }
                    break;

                }
                case 12:
                {
                    if(lists.get(i).getTime()>lists.get(i).getTime_stop() && lists.get(i).getTime_stop()!=0)
                        data[11]+= (lists.get(i).getTime()-lists.get(i).getTime_stop());
                    else if(lists.get(i).getTime()==lists.get(i).getTime_stop())
                    {
                        data[11]+=lists.get(i).getTime();
                    }
                    break;

                }
            }
        }

        ArrayList<Entry> entries = new ArrayList<Entry>();
        for (int index = 0; index < 12; index++) {
            Log.e("dsfsghjgjgj",data[index]+"");
            entries.add(new Entry(index, data[index]));
        }

        LineDataSet set = new LineDataSet(entries, "Request Ots approved");
        set.setColor(Color.GREEN);
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.GREEN);
        set.setCircleRadius(5f);
        set.setFillColor(Color.GREEN);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.GREEN);

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return set;


    }

}
