package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.fitnessproject.model.BaiTap;
import com.example.fitnessproject.model.BuoiTap;
import com.example.fitnessproject.model.BuoiTap_BaiTap;
import com.example.fitnessproject.model.NhomCo;
import com.example.fitnessproject.model.SectionGymExercise;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GymDayActivity extends AppCompatActivity {

    SQLiteHelper sqLiteHelper;

    Button btnCreate;
    RecyclerView recyclerView , recyclerView2;
    EditText edDate,edTime;
    public static ItemGymExerciseAdapterDay adapter;
    public static GymTitleAdapter adapter2;
    public static TextView txtTime;
    public static int time=300;
    public static ArrayList<BaiTap> baiTaps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_day);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        sqLiteHelper = new SQLiteHelper(this);
        btnCreate = findViewById(R.id.btnCreate);
        List<NhomCo> lists = sqLiteHelper.getAll_Nhomco();
        String[] nhomcos = {"CHEST","SHOULDER","TRICEP","BICEP","BACK","LEG","ABS","ALL"};

        txtTime = findViewById(R.id.txtTime);
        ArrayAdapter<CharSequence> langAdapter = new ArrayAdapter<CharSequence>(this, R.layout.spinner_text, nhomcos );
        langAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(langAdapter);

        recyclerView = findViewById(R.id.revGymFitness);
        adapter = new ItemGymExerciseAdapterDay(this);
        ArrayList<BaiTap> listss = (ArrayList<BaiTap>) sqLiteHelper.getAll_Baitap();
        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
        sectionGymExercises.add(new SectionGymExercise("Choose exercise",listss));
        adapter.setData(sectionGymExercises);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        recyclerView2 = findViewById(R.id.revGymFitness2);
        adapter2 = new GymTitleAdapter(this);
        adapter2.setLists(GymDayActivity.baiTaps);
        recyclerView2.setHasFixedSize(false);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0: {
                        GymDayActivity.time=300;
                        txtTime.setText("Time Compltete : ");
                        ArrayList<BaiTap> listss2 = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(lists.get(0));
                        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
                        sectionGymExercises.add(new SectionGymExercise("Choose exercise", listss2));
                        adapter.setData(sectionGymExercises);
                        adapter2.setLists(null);
                        GymTitleAdapter.lists = new ArrayList<>();
                        GymDayActivity.baiTaps=new ArrayList<>();
                        break;
                    }
                    case 1: {
                        GymDayActivity.time=300;
                        txtTime.setText("Time Compltete : ");
                        ArrayList<BaiTap> listss2 = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(lists.get(1));
                        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
                        sectionGymExercises.add(new SectionGymExercise("Choose exercise", listss2));
                        adapter.setData(sectionGymExercises);
                        adapter2.setLists(null);
                        GymTitleAdapter.lists = new ArrayList<>();
                        GymDayActivity.baiTaps=new ArrayList<>();

                        break;
                    }
                    case 2:{
                        GymDayActivity.time=300;
                        txtTime.setText("Time Compltete : ");
                        ArrayList<BaiTap> listss2 = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(lists.get(2));
                        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
                        sectionGymExercises.add(new SectionGymExercise("Choose exercise", listss2));
                        adapter.setData(sectionGymExercises);
                        adapter2.setLists(null);
                        GymTitleAdapter.lists = new ArrayList<>();
                        GymDayActivity.baiTaps=new ArrayList<>();

                        break;
                    }
                    case 3:{
                        GymDayActivity.time=300;
                        txtTime.setText("Time Compltete : ");
                        ArrayList<BaiTap> listss2 = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(lists.get(3));
                        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
                        sectionGymExercises.add(new SectionGymExercise("Choose exercise", listss2));
                        adapter.setData(sectionGymExercises);
                        adapter2.setLists(null);
                        GymTitleAdapter.lists = new ArrayList<>();
                        GymDayActivity.baiTaps=new ArrayList<>();

                        break;
                    }
                    case 4:{

                        GymDayActivity.time=300;
                        txtTime.setText("Time Compltete : ");
                        ArrayList<BaiTap> listss2 = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(lists.get(4));
                        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
                        sectionGymExercises.add(new SectionGymExercise("Choose exercise", listss2));
                        adapter.setData(sectionGymExercises);
                        adapter2.setLists(null);
                        GymTitleAdapter.lists = new ArrayList<>();
                        GymDayActivity.baiTaps=new ArrayList<>();

                        break;
                    }
                    case 5:{
                        GymDayActivity.time=300;
                        txtTime.setText("Time Compltete : ");
                        ArrayList<BaiTap> listss2 = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(lists.get(5));
                        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
                        sectionGymExercises.add(new SectionGymExercise("Choose exercise", listss2));
                        adapter.setData(sectionGymExercises);
                        adapter2.setLists(null);
                        GymTitleAdapter.lists = new ArrayList<>();
                        GymDayActivity.baiTaps=new ArrayList<>();

                        break;
                    }
                    case 6:{
                        GymDayActivity.time=300;
                        txtTime.setText("Time Compltete : ");
                        ArrayList<BaiTap> listss2 = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(lists.get(6));
                        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
                        sectionGymExercises.add(new SectionGymExercise("Choose exercise", listss2));
                        adapter.setData(sectionGymExercises);
                        adapter2.setLists(null);
                        GymTitleAdapter.lists = new ArrayList<>();
                        GymDayActivity.baiTaps=new ArrayList<>();

                        break;
                    }
                    case 7:{
                        GymDayActivity.time=300;
                        txtTime.setText("Time Compltete : ");
                        ArrayList<BaiTap> listss2 = (ArrayList<BaiTap>) sqLiteHelper.getAll_Baitap();
                        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
                        sectionGymExercises.add(new SectionGymExercise("Choose exercise", listss2));
                        adapter.setData(sectionGymExercises);
                        adapter2.setLists(null);
                        GymTitleAdapter.lists = new ArrayList<>();
                        GymDayActivity.baiTaps=new ArrayList<>();

                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        edDate = findViewById(R.id.edDate);
        edTime = findViewById(R.id.edTime);
        edDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int mDay = calendar.get(Calendar.DAY_OF_MONTH);
                int mMonth = calendar.get(Calendar.MONTH);
                int mYear = calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(GymDayActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edDate.setText(year+"/"+(month+1)+"/"+dayOfMonth);
                    }
                },mYear,mMonth,mDay);
                datePickerDialog.show();
            }
        });
        edTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int mHour = calendar.get(Calendar.HOUR);
                int mMinute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        GymDayActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                edTime.setText(hourOfDay+":"+minute);
                            }
                        },
                        mHour,mMinute,false
                );
                timePickerDialog.show();
            }
        });


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String timeStamp = new SimpleDateFormat("yyyy/MM/dd/HH:mm").format(Calendar.getInstance().getTime());

                String Date = edDate.getText().toString()+"/"+edTime.getText().toString();

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

                    if(dayCurrent+monthCurrent*30+yearCurrent*365 > daySelect+monthSelect*30+yearSelect*365)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setMessage("Không thể tạo buổi tập cho quá khứ ");
                        builder.create().show();
                    }
                    else if (dayCurrent+monthCurrent*30+yearCurrent*365 == daySelect+monthSelect*30+yearSelect*365)
                    {
                        if(hourCurrent*60 + minCurrent > hourSelect*60 + minSelect)
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                            builder.setMessage("Không thể tạo buổi tập cho quá khứ time");
                            builder.create().show();
                        }
                        else
                        {
                            BuoiTap buoiTap = new BuoiTap();
                            buoiTap.setTime(GymDayActivity.time);
                            String month,day,hour,min;
                            if(monthSelect<10)
                            {
                                 month = "0"+monthSelect;
                            }
                            else
                            {
                                month = monthSelect+"";
                            }
                            if(daySelect<10)
                            {
                                 day = "0"+daySelect;
                            }
                            else
                            {
                                day = daySelect+"";
                            }
                            if(hourSelect<10)
                            {
                                hour = "0"+hourSelect;
                            }
                            else
                            {
                                hour=hourSelect+"";
                            }
                            if(minSelect<10)
                            {
                                 min = "0"+minSelect;
                            }
                            else
                            {
                                min = minSelect+"";
                            }
                            String dayinsert = yearSelect+"/"+month+"/"+day+"/"+hour+":"+min;
                            buoiTap.setDate(dayinsert);
                            buoiTap.setTime_stop(0);
                            buoiTap.setId((int) sqLiteHelper.addBuoiTap(buoiTap));
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(yearSelect,monthSelect-1,daySelect,hourSelect,minSelect-5);
                            Log.e("time",calendar.getTime().toString());
                            Intent intent = new Intent(GymDayActivity.this, MyReceiver.class);
                            intent.putExtra("channel",buoiTap.getId()+"Channel");
                            intent.putExtra("title","Bạn có buổi tập vào : "+ hourSelect+" : "+minSelect+"");
                            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                                    GymDayActivity.this, buoiTap.getId(), intent, 0);

                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                            Log.e("buoitapid",buoiTap.getId()+"dd");
                            for(int i=0 ;i<GymDayActivity.baiTaps.size();i++)
                            {
                                BuoiTap_BaiTap buoiTap_baiTap = new BuoiTap_BaiTap();
                                buoiTap_baiTap.setBaitap(baiTaps.get(i));
                                buoiTap_baiTap.setBuoitap(buoiTap);
                                sqLiteHelper.addBuoiTap_BaiTap(buoiTap_baiTap);
                                Log.e("baitapid",baiTaps.get(i).getId()+"");
                                Log.e("baitap_buoitap_id",buoiTap_baiTap.getBaitap().getName()+"");
                            }

                            Intent intent1 = new Intent(GymDayActivity.this,MainActivity.class);
                            startActivity(intent1);

                        }
                    }
                    else
                    {
                        BuoiTap buoiTap = new BuoiTap();
                        buoiTap.setTime(GymDayActivity.time);
                        String month,day,hour,min;
                        if(monthSelect<10)
                        {
                            month = "0"+monthSelect;
                        }
                        else
                        {
                            month = monthSelect+"";
                        }
                        if(daySelect<10)
                        {
                            day = "0"+daySelect;
                        }
                        else
                        {
                            day = daySelect+"";
                        }
                        if(hourSelect<10)
                        {
                            hour = "0"+hourSelect;
                        }
                        else
                        {
                            hour=hourSelect+"";
                        }
                        if(minSelect<10)
                        {
                            min = "0"+minSelect;
                        }
                        else
                        {
                            min = minSelect+"";
                        }
                        String dayinsert = yearSelect+"/"+month+"/"+day+"/"+hour+":"+min;
                        buoiTap.setDate(dayinsert);
                        buoiTap.setTime_stop(0);
                        buoiTap.setId((int) sqLiteHelper.addBuoiTap(buoiTap));
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(yearSelect,monthSelect-1,daySelect,hourSelect,minSelect-5);
                        Log.e("time",calendar.getTime().toString());
                        Intent intent = new Intent(GymDayActivity.this, MyReceiver.class);
                        intent.putExtra("channel",buoiTap.getId()+"Channel");
                        intent.putExtra("title","Bạn có buổi tập vào : "+ hourSelect+" : "+minSelect+"");
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                                GymDayActivity.this, buoiTap.getId(), intent, 0);

                        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                        Log.e("buoitapid",buoiTap.getId()+"dd");
                        for(int i=0 ;i<GymDayActivity.baiTaps.size();i++)
                        {
                            BuoiTap_BaiTap buoiTap_baiTap = new BuoiTap_BaiTap();
                            buoiTap_baiTap.setBaitap(baiTaps.get(i));
                            buoiTap_baiTap.setBuoitap(buoiTap);
                            sqLiteHelper.addBuoiTap_BaiTap(buoiTap_baiTap);
                            Log.e("baitapid",baiTaps.get(i).getId()+"");
                            Log.e("baitap_buoitap_id",buoiTap_baiTap.getBaitap().getName()+"");
                        }

                        Intent intent1 = new Intent(GymDayActivity.this,MainActivity.class);
                        startActivity(intent1);
                    }
                }
                catch (NumberFormatException e)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("Nhập ngày giở không đúng định dạng , double click để nhập ");
                    builder.create().show();
                }



            }
        });

    }

}