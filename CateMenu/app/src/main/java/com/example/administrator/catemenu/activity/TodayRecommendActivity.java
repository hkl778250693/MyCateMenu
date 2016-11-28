package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.TodayRecommendAdapter;
import com.example.administrator.catemenu.fragment.HomepageFragment;
import com.example.administrator.catemenu.modle.TodayRecommendItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 2016/11/11.
 */
public class TodayRecommendActivity extends Activity {
    ImageView backBtn;
    ImageView headImg;
    Intent intent;
    List<TodayRecommendItem> recommendItemList = new ArrayList<TodayRecommendItem>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_recommend);

        getData();
        //找到控件id
        backBtn = (ImageView) findViewById(R.id.back_btn);
        listView = (ListView) findViewById(R.id.listview);
        headImg = (ImageView) findViewById(R.id.head_img);

        //点击事件
        backBtn.setOnClickListener(clickListener);
        headImg.setOnClickListener(clickListener);

        //添加适配器
        TodayRecommendAdapter todayRecommendAdapter = new TodayRecommendAdapter(this,recommendItemList);
        listView.setAdapter(todayRecommendAdapter);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back_btn:
                    intent = new Intent(TodayRecommendActivity.this,HomePageActivity.class);
                    startActivity(intent);
                    break;
                case R.id.head_img:
                    intent = new Intent(TodayRecommendActivity.this,MineActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    //获取数据方法
    public void getData(){
        for(int i=0;i<10;i++){
            TodayRecommendItem todayRecommendItem = new TodayRecommendItem();
            recommendItemList.add(todayRecommendItem);
        }
    }
}
