package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.SeasonItemAdapter;
import com.example.administrator.catemenu.customview.LazyScrollView;
import com.example.administrator.catemenu.fragment.HomepageFragment;
import com.example.administrator.catemenu.modle.SeasonItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */
public class SeasonRecommendActivity extends Activity {
    LinearLayout leftlinear;
    LinearLayout rghitlinear;
    ImageView backBtn;
    ImageView headImg;
    Intent intent;
    ScrollView lazyScrollView;
    List<SeasonItem> seasonItemList = new ArrayList<SeasonItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_recommend);


        //getData();
        //找到相应的控件id
        backBtn = (ImageView) findViewById(R.id.back_btn);
        headImg = (ImageView) findViewById(R.id.head_img);
        rghitlinear = (LinearLayout) findViewById(R.id.layoutrghit);
        leftlinear = (LinearLayout) findViewById(R.id.layoutleft);

        //设置点击事件
        backBtn.setOnClickListener(clickListener);
        headImg.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.back_btn:
                    intent = new Intent(SeasonRecommendActivity.this, HomePageActivity.class);
                    startActivity(intent);
                    break;
                case R.id.head_img:
                    intent = new Intent(SeasonRecommendActivity.this, MineActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

//    public void getData() {
//        for (int i = 0; i < 10; i++) {
//            SeasonItem seasonItem = new SeasonItem();
//            seasonItemList.add(seasonItem);
//        }
//    }

    /***
     * init view
     */
    public void initView() {
        lazyScrollView = (LazyScrollView) findViewById(R.id.lazyscrollview);
        lazyScrollView.getRootView();




    }
}
