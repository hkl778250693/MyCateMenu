package com.example.administrator.catemenu.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;


import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.SearchActivity;
import com.example.administrator.catemenu.adapter.YhzsAdapter;
import com.example.administrator.catemenu.modle.Yhzs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class FeastFragment extends Fragment {
    ListView yhzsListview;
    List<Yhzs> yhzsList = new ArrayList<Yhzs>();
    RadioButton taocanBtn;
    RadioButton caipiBtn;
    RadioButton homeBtn;
    RadioButton workmateBtn;
    RadioButton friendBtn;
    RadioButton birthdayBtn;
    RadioButton festivalBtn;
    View itemView;
    LayoutInflater layoutInflater;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_feast,null);

        //找到对应的控件id
        taocanBtn = (RadioButton) view.findViewById(R.id.taocan_btn);
        caipiBtn = (RadioButton) view.findViewById(R.id.caipi_btn);
        homeBtn = (RadioButton) view.findViewById(R.id.home_btn);
        workmateBtn = (RadioButton) view.findViewById(R.id.workmate_btn);
        friendBtn = (RadioButton) view.findViewById(R.id.friend_btn);
        birthdayBtn = (RadioButton) view.findViewById(R.id.birthday_btn);
        festivalBtn = (RadioButton) view.findViewById(R.id.festival_btn);

        //设置点击事件
        taocanBtn.setChecked(true);
        homeBtn.setChecked(true);
        if(taocanBtn.isChecked() && homeBtn.isChecked()){

        }
        taocanBtn.setOnClickListener(clickListener);
        caipiBtn.setOnClickListener(clickListener);
        homeBtn.setOnClickListener(clickListener);
        workmateBtn.setOnClickListener(clickListener);
        friendBtn.setOnClickListener(clickListener);
        birthdayBtn.setOnClickListener(clickListener);
        festivalBtn.setOnClickListener(clickListener);


        getData();
        yhzsListview = (ListView) view.findViewById(R.id.yhzs_listview);
        final YhzsAdapter yhzsAdapter = new YhzsAdapter(getActivity(),yhzsList);
        yhzsListview.setAdapter(yhzsAdapter);
        layoutInflater = LayoutInflater.from(getActivity());
        itemView = layoutInflater.inflate(R.layout.listview_feast_item,null);
        yhzsListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.taocan_btn:
                    break;
                case R.id.caipi_btn:
                    break;
                case R.id.home_btn:
                    break;
                case R.id.workmate_btn:
                    break;
                case R.id.friend_btn:
                    break;
                case R.id.birthday_btn:
                    break;
                case R.id.festival_btn:
                    break;

            }
        }
    };

    public void getData(){
        for(int i=0;i<10;i++){
            Yhzs yhzs = new Yhzs();
            yhzs.setTimeTv("100分钟");
            yhzs.setFeastFoodName("1.酸菜鱼 2.酸菜鱼 3.酸菜鱼 1.酸菜鱼 2.酸菜鱼 3.酸菜鱼 1.酸菜鱼 2.酸菜鱼 3.酸菜鱼 1.酸菜鱼 2.酸菜鱼 3.酸菜鱼");
            yhzs.setZhanKai("[展开]");
            yhzsList.add(yhzs);
        }
    }
}
