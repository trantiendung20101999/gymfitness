package com.example.fitnessproject.fitness.gym;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject.MainActivity;
import com.example.fitnessproject.R;
import com.example.fitnessproject.SQLiteHelper;
import com.example.fitnessproject.fitness.FragmentFitnessMain;
import com.example.fitnessproject.model.BaiTap;
import com.example.fitnessproject.model.NhomCo;
import com.example.fitnessproject.model.SectionGymExercise;

import java.util.ArrayList;
import java.util.List;

public class FragmentGymFitness extends Fragment {

    private RecyclerView recyclerView;

    private ItemGymExerciseAdapter adapter;

    SQLiteHelper sqLiteHelper ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gym_fitness,container,false);
        sqLiteHelper = new SQLiteHelper(v.getContext());
        recyclerView = v.findViewById(R.id.revGymFitness);
        adapter = new ItemGymExerciseAdapter(v.getContext());
        adapter.setData(getAll());
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
        return  v;

    }


    public ArrayList<SectionGymExercise> getAll()
    {
        ArrayList<SectionGymExercise> sectionGymExercises = new ArrayList<>();
        List<NhomCo> lists = sqLiteHelper.getAll_Nhomco();

        if(MainActivity.count==0) {
            static_Data();
            Log.e("dsfsd","add");
            MainActivity.count=2;
        }
        for (int i=0;i<lists.size();i++)
        {

            ArrayList<BaiTap> listBaiTap = (ArrayList<BaiTap>) sqLiteHelper.getBaiTapByNhomCo(lists.get(i));
            sectionGymExercises.add(new SectionGymExercise(lists.get(i).getName(),listBaiTap));
        }
        return sectionGymExercises;
    }

    public void static_Data()
    {
        List<NhomCo> lists = sqLiteHelper.getAll_Nhomco();
        sqLiteHelper.deleteall();

        sqLiteHelper.addBaiTap(new BaiTap(1,lists.get(0),"Barbell Bench Press",R.drawable.barbel_bench_press,"kKKuzmkLtv0",84));
        sqLiteHelper.addBaiTap(new BaiTap(2,lists.get(0),"Flat Bench Dumbbell Press",R.drawable.flat_bench_dumbbell_bench_press,"klNatl9L-ck",84));
        sqLiteHelper.addBaiTap(new BaiTap(3,lists.get(0),"Low-Incline Barbell Bench Press",R.drawable.incline_barbell_bench_press,"44VbhvTG3IE",84));
        sqLiteHelper.addBaiTap(new BaiTap(4,lists.get(0),"Incline Dumbbell Press",R.drawable.incline_dumbbell_press,"xe0Xhb1mapY",84));
        sqLiteHelper.addBaiTap(new BaiTap(5,lists.get(0),"Dumbbell Flys",R.drawable.barbel_bench_press,"cAH1pOSflDs",84));
        sqLiteHelper.addBaiTap(new BaiTap(6,lists.get(0),"Machine Bench Press",R.drawable.machine_bench_press,"xUm0BiZCWlQ",84));
        sqLiteHelper.addBaiTap(new BaiTap(7,lists.get(0),"Decline Dumbbell Bench Press",R.drawable.decline_dumbbell_bench_press,"O5nBCxDLhbg",84));
        sqLiteHelper.addBaiTap(new BaiTap(8,lists.get(0),"Pec-deck Machine",R.drawable.pec_deck_machine,"22Q3bmNZk0Y",84));
        sqLiteHelper.addBaiTap(new BaiTap(9,lists.get(0),"Svend Press",R.drawable.svend_press,"cIoUZOnypS8",84));
        sqLiteHelper.addBaiTap(new BaiTap(10,lists.get(0),"Cable Crossover",R.drawable.cable_crossovers,"taI4XduLpTk",84));
        sqLiteHelper.addBaiTap(new BaiTap(11,lists.get(0),"Chest Dips",R.drawable.chest_dips,"0mzzPyxPwzs",84));
        sqLiteHelper.addBaiTap(new BaiTap(12,lists.get(0),"Dumbbell Pullover",R.drawable.dumbbell_pullover,"EGbPGwvnfNk",84));

        sqLiteHelper.addBaiTap(new BaiTap(13,lists.get(1),"Standing Barbell Overhead Press",R.drawable.standing_barbell_overhead_press,"2yjwXTZQDDI",84));
        sqLiteHelper.addBaiTap(new BaiTap(14,lists.get(1),"Machine Shoulder Press",R.drawable.machine_shoulder_press,"3R14MnZbcpw",84));
        sqLiteHelper.addBaiTap(new BaiTap(15,lists.get(1),"Cable Overhead Press",R.drawable.cable_overhead_press,"fBTGwHChaf4",84));
        sqLiteHelper.addBaiTap(new BaiTap(16,lists.get(1),"Seated Overhead Dumbbell Press",R.drawable.seated_overhead_dumbbell_press,"neIy-6C3S3s",84));
        sqLiteHelper.addBaiTap(new BaiTap(17,lists.get(1),"Arnold Press",R.drawable.arnold_press,"WdXmVw",84));
        sqLiteHelper.addBaiTap(new BaiTap(18,lists.get(1),"Dumbbell Alternating Front Raise",R.drawable.dumbbell_alternating_front_raise,"t5pXxF94tuo",84));
        sqLiteHelper.addBaiTap(new BaiTap(19,lists.get(1),"Dumbbell Lateral Raise",R.drawable.dumbbell_lateral_raise,"wDH5Z50p9-U",84));
        sqLiteHelper.addBaiTap(new BaiTap(20,lists.get(1),"Incline Dumbbell Font Raise",R.drawable.incline_dumbbell_front_raise,"0_b43RbenY8",84));
        sqLiteHelper.addBaiTap(new BaiTap(21,lists.get(1),"Incline Dumbbell Lateral Raise",R.drawable.incline_dumbbell_lateral_raise,"oneoO9B8xqs",84));
        sqLiteHelper.addBaiTap(new BaiTap(22,lists.get(1),"Barbell Wide Grip Upright Row",R.drawable.barbell_wide_grip_upright_row,"IzBZ-9NSVVU",84));
        sqLiteHelper.addBaiTap(new BaiTap(23,lists.get(1),"One Dumbbell Front Raise",R.drawable.one_dumbbell_front_raise,"ZFNaDzE7VVc",84));
        sqLiteHelper.addBaiTap(new BaiTap(24,lists.get(1),"Barbell Front Raise",R.drawable.barbell_front_raise,"sxeY7kMYhLc",84));
        sqLiteHelper.addBaiTap(new BaiTap(25,lists.get(1),"Cable One Arm Lateral Raise",R.drawable.cable_one_arm_lateral_raise,"_w6ztKA4tO8",84));

        sqLiteHelper.addBaiTap(new BaiTap(26,lists.get(2),"One Arm Pronated Dumbbell Triceps Extension",R.drawable.one_arm_pronated_dumbbell_triceps_extension,"xNn4bifX_PY",84));
        sqLiteHelper.addBaiTap(new BaiTap(27,lists.get(2),"Cable Pushdown",R.drawable.cable_pushdown,"vB5OHsJ3EME",84));
        sqLiteHelper.addBaiTap(new BaiTap(28,lists.get(2),"Standing Dumbbell Triceps Extension",R.drawable.standing_dumbbell_triceps_extension,"-Vyt2QdsR7E",84));
        sqLiteHelper.addBaiTap(new BaiTap(29,lists.get(2),"Dumbbell Standing Kickback",R.drawable.dumbbell_standing_kickback,"jxYMhEjrQsM",84));
        sqLiteHelper.addBaiTap(new BaiTap(30,lists.get(2),"Double Arm Dumbbell Overhead Extension",R.drawable.double_arm_dumbbell_overhead_extension,"m1u4Bld9OSk",84));
        sqLiteHelper.addBaiTap(new BaiTap(31,lists.get(2),"Dumbbell Lying Triceps Extension",R.drawable.dumbbell_lying_tricep_extension,"MO_03opCc0g",84));
        sqLiteHelper.addBaiTap(new BaiTap(32,lists.get(2),"Barbell Overhead Triceps Extension",R.drawable.barbell_overhead_tricep_extension,"QxFHyf3sDsA",84));
        sqLiteHelper.addBaiTap(new BaiTap(33,lists.get(2),"Dumbbell One Arm Triceps Extension",R.drawable.incline_dumbbell_front_raise,"_gsUck-7M74",84));
        sqLiteHelper.addBaiTap(new BaiTap(34,lists.get(2),"Bench Dips",R.drawable.bench_dips,"c3ZGl4pAwZ4",84));


        sqLiteHelper.addBaiTap(new BaiTap(35,lists.get(3),"Dumbbell Incline Bicep Curl",R.drawable.dumbbell_incline_bicep_curl,"soxrZlIl35U",84));
        sqLiteHelper.addBaiTap(new BaiTap(36,lists.get(3),"Dumbbell Hammer Curl",R.drawable.dumbbell_hammer_curl,"zC3nLlEvin4",84));
        sqLiteHelper.addBaiTap(new BaiTap(37,lists.get(3),"One-Arm Dumbbell Curl",R.drawable.one_arm_dumbbell_curl,"0AUGkch3tzc",84));
        sqLiteHelper.addBaiTap(new BaiTap(38,lists.get(3),"Dumbbell Seated Incline Inner Curls",R.drawable.dumbbell_seated_incline_inner_curl,"-vZbnOSZqfc",84));
        sqLiteHelper.addBaiTap(new BaiTap(39,lists.get(3),"Standing Dumbbell Curls",R.drawable.standing_dumbbell_curl,"sAq_ocpRh_I",84));
        sqLiteHelper.addBaiTap(new BaiTap(40,lists.get(3),"Dumbbell Standing Single Spider Curl",R.drawable.dumbbell_standing_single_curl,"3bgL6UwLLWs",84));

        sqLiteHelper.addBaiTap(new BaiTap(41,lists.get(4),"Pull-up",R.drawable.pull_up,"5WHdim80e7o",84));
        sqLiteHelper.addBaiTap(new BaiTap(42,lists.get(4),"Wide-grip Lat Pull-down",R.drawable.wide_grip_lat_pull_down,"lueEJGjTuPQ",84));
        sqLiteHelper.addBaiTap(new BaiTap(43,lists.get(4),"Machine Front Pull-down",R.drawable.machine_front_pull_down,"7D2t1XnrW2s",84));
        sqLiteHelper.addBaiTap(new BaiTap(44,lists.get(4),"Machine High Row",R.drawable.machine_high_row,"PLYE3TrXO9o",84));
        sqLiteHelper.addBaiTap(new BaiTap(45,lists.get(4),"Seated Cable Row",R.drawable.seated_cable_row,"TZGAx3yBkMc",84));
        sqLiteHelper.addBaiTap(new BaiTap(46,lists.get(4),"Bent-Over Dumbbell Row",R.drawable.bent_over_dumbbell_row,"ssgKBedNWwM",84));
        sqLiteHelper.addBaiTap(new BaiTap(47,lists.get(4),"Bent-over Barbell Row",R.drawable.bent_over_barbell_row,"XJMY1XzzVxQ",84));
        sqLiteHelper.addBaiTap(new BaiTap(48,lists.get(4),"Straight Arm Pull Down",R.drawable.straight_arm_pull_down,"BMzjSIHtFlA",84));
        sqLiteHelper.addBaiTap(new BaiTap(49,lists.get(4),"Single Arm Standing Cable Row",R.drawable.single_arm_standing_cable_row,"_z5NMUxkxxw",84));

        sqLiteHelper.addBaiTap(new BaiTap(50,lists.get(5),"Barbell Squat",R.drawable.barbell_squat,"SW_C1A-rejs",84));
        sqLiteHelper.addBaiTap(new BaiTap(51,lists.get(5),"Dumbbell Romanian Deadlift",R.drawable.dumbbell_romainian_deadlift,"6nciQmeoeZo",84));
        sqLiteHelper.addBaiTap(new BaiTap(52,lists.get(5),"Barbell Romanian Deadlift",R.drawable.barbell_romainan_deadlift,"k7JXXSRrTJ8",84));
        sqLiteHelper.addBaiTap(new BaiTap(53,lists.get(5),"Leg Extension",R.drawable.leg_extension,"lrwPCtjnENE",84));
        sqLiteHelper.addBaiTap(new BaiTap(54,lists.get(5),"Lying Leg Curl",R.drawable.lying_leg_curl,"8whsd-n6XbI",84));
        sqLiteHelper.addBaiTap(new BaiTap(55,lists.get(5),"Dumbbell Lunge",R.drawable.dumbbell_lunge,"ioQcBjeNdo0",84));
        sqLiteHelper.addBaiTap(new BaiTap(56,lists.get(5),"Leg Press",R.drawable.leg_press,"7XRpflRwrIs",84));
        sqLiteHelper.addBaiTap(new BaiTap(57,lists.get(5),"Seated Calf Raise",R.drawable.seated_calf_raise,"3rr-c0_kERA",84));

        sqLiteHelper.addBaiTap(new BaiTap(58,lists.get(6),"Seated Knee Raise",R.drawable.seated_knee_raise,"iJwwu6N-gNM",84));
        sqLiteHelper.addBaiTap(new BaiTap(59,lists.get(6),"Kneeling Cable Crunch",R.drawable.kneeling_cable_crunch,"NJQROeaBiVE",84));
        sqLiteHelper.addBaiTap(new BaiTap(60,lists.get(6),"Decline Bech Leg Raises",R.drawable.decline_bech_leg_raise,"x4Q9hVp2LUA",84));
        sqLiteHelper.addBaiTap(new BaiTap(61,lists.get(6),"Decline Sit-Up",R.drawable.decline_sit_up,"QhGU5cmNZds",84));
        sqLiteHelper.addBaiTap(new BaiTap(62,lists.get(6),"Hanging Leg Raise",R.drawable.hanging_leg_raise,"RuIdJSVTKO4",84));

        sqLiteHelper.addBaiTap(new BaiTap(63,lists.get(0),"Chest At Home ",R.drawable.chest_at_home,"AhGc82jybpA",84));

        sqLiteHelper.addBaiTap(new BaiTap(64,lists.get(1),"Shoulder At Home ",R.drawable.shoulder_at_home,"lNXMmgW0OSs",84));

        sqLiteHelper.addBaiTap(new BaiTap(65,lists.get(2),"Tricep At Home",R.drawable.tricep_at_home,"9by6gQTTQs0",84));

        sqLiteHelper.addBaiTap(new BaiTap(66,lists.get(3),"Bicep At Home",R.drawable.bicep_at_home,"4Vg4Pai-XYI",84));

        sqLiteHelper.addBaiTap(new BaiTap(67,lists.get(4),"Back At Home",R.drawable.back_at_home,"W4GmnV9WTtc&t=535s",84));

        sqLiteHelper.addBaiTap(new BaiTap(68,lists.get(5),"Leg At Home",R.drawable.leg_at_home,"octrQNPXLGs",84));

        sqLiteHelper.addBaiTap(new BaiTap(69,lists.get(6),"ABS At Home",R.drawable.abs_at_home,"nvZQ&t=76s",84));
    }



}
