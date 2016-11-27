package com.example.administrator.catemenu.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.SeasonRecommendActivity;
import com.example.administrator.catemenu.activity.TodayRecommendActivity;
import com.example.administrator.catemenu.activity.WeekOrderActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/11.
 */
public class HomepageFragment extends Fragment implements View.OnClickListener {
    RadioButton breakfast;
    RadioButton desssert;
    RadioButton dinner;
    RadioButton lunch;
    ViewPager viewPager;
    RelativeLayout todayRecommend;
    RelativeLayout weekOrder;
    RelativeLayout season;
    Intent intent;
    Activity activity;

    ArrayList<View> lists= new ArrayList<View>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, null);
        breakfast = (RadioButton) view.findViewById(R.id.btn_breakfast);
        desssert = (RadioButton) view.findViewById(R.id.btn_dessert);
        dinner = (RadioButton) view.findViewById(R.id.btn_dinner);
        lunch = (RadioButton) view.findViewById(R.id.btn_lunch);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        todayRecommend = (RelativeLayout) view.findViewById(R.id.today_recommend);
        weekOrder = (RelativeLayout) view.findViewById(R.id.week_order);
        season = (RelativeLayout) view.findViewById(R.id.season);
        activity = getActivity();

        breakfast.setOnClickListener(this);
        desssert.setOnClickListener(this);
        dinner.setOnClickListener(this);
        lunch.setOnClickListener(this);
        todayRecommend.setOnClickListener(this);
        weekOrder.setOnClickListener(this);
        season.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_breakfast:
                if (breakfast.isChecked() ==true){
                    desssert.setChecked(false);
                    dinner.setChecked(false);
                    lunch.setChecked(false);
                }
                break;
            case R.id.btn_dessert:
                if (desssert.isChecked() ==true){
                    breakfast.setChecked(false);
                    dinner.setChecked(false);
                    lunch.setChecked(false);
                }
                break;
            case R.id.btn_dinner:
                if (dinner.isChecked() ==true){
                    breakfast.setChecked(false);
                    desssert.setChecked(false);
                    lunch.setChecked(false);
                }
                break;
            case R.id.btn_lunch:
                if (lunch.isChecked() ==true){
                    breakfast.setChecked(false);
                    desssert.setChecked(false);
                    dinner.setChecked(false);
                }
                break;
            case R.id.today_recommend:
                intent = new Intent(activity, TodayRecommendActivity.class);
                startActivity(intent);
                break;
            case R.id.week_order:
                intent = new Intent(activity, WeekOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.season:
                intent = new Intent(activity, SeasonRecommendActivity.class);
                startActivity(intent);
                break;
        }
    }
}
