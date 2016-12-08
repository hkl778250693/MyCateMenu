package com.example.administrator.catemenu.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.administrator.catemenu.R;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/11/26.
 */
public class SeasonRecommendActivity extends Activity {

    private ScrollView waterfall_scrollview;
    private LinearLayout waterfall_container;
    private ArrayList<LinearLayout> waterfall_items;
    private ArrayList<View> view_item;
    private Display display;
    private int itemWidth;
    private int column_count = 2;// 显示列数
    private int page_count = 15;// 每次加载15张图片
    private int current_page = 0;


    private ImageView backBtn;
    private ImageView headImg;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_recommend);

        //根据屏幕获取宽高
        display = this.getWindowManager().getDefaultDisplay();
        itemWidth = display.getWidth() / column_count;// 根据屏幕大小计算每列大小

        //找到相应的控件id
        backBtn = (ImageView) findViewById(R.id.back_btn);
        headImg = (ImageView) findViewById(R.id.head_img);
        waterfall_container = (LinearLayout) findViewById(R.id.linearLayout);

        //设置点击事件
        backBtn.setOnClickListener(clickListener);
        headImg.setOnClickListener(clickListener);
        initlayout();
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void initlayout() {
        waterfall_scrollview = (ScrollView) findViewById(R.id.lazyscrollview);
        waterfall_scrollview.getRootView();
        waterfall_scrollview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {

            }
        });

        waterfall_container = (LinearLayout) findViewById(R.id.linearLayout);
        waterfall_items = new ArrayList<LinearLayout>();

        for (int i = 0; i < column_count; i++) {
            LinearLayout itemLayout = new LinearLayout(this);
            LinearLayout.LayoutParams itemParam = new LinearLayout.LayoutParams(
                    itemWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
            // itemParam.width = itemWidth;
            // itemParam.height = LayoutParams.WRAP_CONTENT;
            itemLayout.setPadding(2, 2, 2, 2);
            itemLayout.setOrientation(LinearLayout.VERTICAL);

            itemLayout.setLayoutParams(itemParam);
            waterfall_items.add(itemLayout);
            waterfall_container.addView(itemLayout);
            for (int j = 0; j < page_count; j++) {
                View view = LayoutInflater.from(this).inflate(R.layout.season_listview_item, null);
                waterfall_items.get(i).addView(view);
            }
        }
    }

//    private void AddItemToContainer(int current_page, int page_count) {
//        int j = 0;
//        int imagecount = view_item.size();
//        for (int i = current_page * page_count; i < page_count * (current_page + 1)
//                && i < imagecount; i++) {
//            j = j >= column_count ? j = 0 : j;
//            AddView(view_item.get(i), j++);
//        }
//    }
//
//    private void AddView(View view, int i) {
//        waterfall_items.get(i).addView(view);
//    }


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

}
