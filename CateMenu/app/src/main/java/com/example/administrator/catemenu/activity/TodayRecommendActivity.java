package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

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
    ViewFlipper viewFlipper;
    GestureDetector gestureDetector;
    RadioGroup radioGroup;
    RadioButton radioBtn1;
    RadioButton radioBtn2;
    RadioButton radioBtn3;
    RadioButton radioBtn4;
    View view;
    TextView textView;
    List<View> viewList = new ArrayList<View>();
    ImageView bannerImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_recommend);

        getData();
        //找到控件id
        backBtn = (ImageView) findViewById(R.id.back_btn);
        listView = (ListView) findViewById(R.id.listview);
        headImg = (ImageView) findViewById(R.id.head_img);
        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        gestureDetector = new GestureDetector(this,onGestureListener);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioBtn1 = (RadioButton) findViewById(R.id.radio_btn1);
        radioBtn2 = (RadioButton) findViewById(R.id.radio_btn2);
        radioBtn3 = (RadioButton) findViewById(R.id.radio_btn3);
        radioBtn4 = (RadioButton) findViewById(R.id.radio_btn4);

        //点击事件
        radioBtn1.setChecked(true);
        backBtn.setOnClickListener(clickListener);
        headImg.setOnClickListener(clickListener);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_btn1:
                        if(isFinishing()){
                            viewFlipper.stopFlipping();
                            viewFlipper.setDisplayedChild(0);
                            viewFlipper.startFlipping();
                        }else {
                            viewFlipper.setDisplayedChild(0);
                        }
                        break;
                    case R.id.radio_btn2:
                        if(isFinishing()){
                            viewFlipper.stopFlipping();
                            viewFlipper.setDisplayedChild(1);
                            viewFlipper.startFlipping();
                        }else {
                            viewFlipper.setDisplayedChild(1);
                        }
                        break;
                    case R.id.radio_btn3:
                        if(isFinishing()){
                            viewFlipper.stopFlipping();
                            viewFlipper.setDisplayedChild(2);
                            viewFlipper.startFlipping();
                        }else {
                            viewFlipper.setDisplayedChild(2);
                        }
                        break;
                    case R.id.radio_btn4:
                        if(isFinishing()){
                            viewFlipper.stopFlipping();
                            viewFlipper.setDisplayedChild(3);
                            viewFlipper.startFlipping();
                        }else {
                            viewFlipper.setDisplayedChild(3);
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        for(int i=0;i<4;i++){
            view = getLayoutInflater().inflate(R.layout.view_flipper_item,null);
            if(i == 0){
                textView = (TextView) view.findViewById(R.id.name_tv);
                bannerImg = (ImageView) view.findViewById(R.id.banner_img);
                textView.setText("蓝莓");
                bannerImg.setImageResource(R.mipmap.banner);
                viewFlipper.addView(view);
            }else if(i == 1){
                textView = (TextView) view.findViewById(R.id.name_tv);
                bannerImg = (ImageView) view.findViewById(R.id.banner_img);
                textView.setText("留香排骨");
                bannerImg.setImageResource(R.mipmap.liuxiangpaigu);
                viewFlipper.addView(view);
            }else if(i == 2){
                textView = (TextView) view.findViewById(R.id.name_tv);
                bannerImg = (ImageView) view.findViewById(R.id.banner_img);
                textView.setText("蒜子鳝段");
                bannerImg.setImageResource(R.mipmap.banner2);
                viewFlipper.addView(view);
            }else {
                textView = (TextView) view.findViewById(R.id.name_tv);
                bannerImg = (ImageView) view.findViewById(R.id.banner_img);
                textView.setText("烤三文鱼");
                bannerImg.setImageResource(R.mipmap.kswy);
                viewFlipper.addView(view);
            }
            textView.setTag(i);
            view.setTag(i+5);
            viewList.add(view);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();
        viewFlipper.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                TextView textView1 = (TextView) viewFlipper.getCurrentView().findViewById(R.id.name_tv);
                if(viewFlipper.getCurrentView() instanceof LinearLayout){
                    //当图片是第一张的时候，圆圈相应跳转
                    Log.i("setTag","setTag"+textView1.getTag());
                    switch ((int)textView1.getTag()){
                        case 0:
                            radioBtn1.setChecked(true);
                            break;
                        case 1:
                            radioBtn2.setChecked(true);
                            break;
                        case 2:
                            radioBtn3.setChecked(true);
                            break;
                        case 3:
                            radioBtn4.setChecked(true);
                            break;
                        default:
                            break;
                    }
                }
            }
        });

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

    //gestureDetector的点击事件
    GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {//down事件
            Log.i("onDown","onDown======");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {//按事件
            Log.i("onShowPress","onShowPress======");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {//单次点击up事件
            Log.i("onSingleTapUp","onSingleTapUp======");
            return false;
        }

        @Override//滚动事件       起始位置        结束位置    两个位置之间X方向的距离 | Y方向的距离
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.i("onScroll","onScroll======");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {//长按事件
            Log.i("onLongPress","onLongPress======");
        }

        @Override//滑动事件       起始位置         结束位置         X滑动的速度     Y滑动的速度
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
           /* e1.getX();
            e1.getY();
            e2.getX();
            e2.getY();
            通过e的X的差值的正负，判断方向是左还是右 */

            if(e1.getX() > e2.getX()){
                viewFlipper.stopFlipping();
                viewFlipper.showPrevious();
                viewFlipper.startFlipping();
            }else if(e1.getX() < e2.getX()){
                viewFlipper.stopFlipping();
                viewFlipper.showNext();
                viewFlipper.startFlipping();
            }
            Log.i("onFling","onFling======");
            return false;
        }
    };

    //重写OnTouchEvent点击事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

}
