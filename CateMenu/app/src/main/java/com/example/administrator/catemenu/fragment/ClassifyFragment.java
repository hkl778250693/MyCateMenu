package com.example.administrator.catemenu.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.ClassifyMeatActivity;
import com.example.administrator.catemenu.activity.TodayRecommendActivity;
import com.example.administrator.catemenu.activity.HomePageActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/11/11.
 */
public class ClassifyFragment extends Fragment implements HomePageActivity.MyTouchListener{
    RadioButton huncaiBtn;
    RadioButton sucaiBtn;
    RadioButton tangcaiBtn;
    RadioButton dianxinBtn;
    Activity activity;
    ViewFlipper viewFlipper;
    GestureDetector gestureDetector;
    RadioGroup radioGroup;
    RadioButton radioBtn1;
    RadioButton radioBtn2;
    RadioButton radioBtn3;
    RadioButton radioBtn4;
    Intent intent;
    View view;
    View view1;
    TextView textView;
    List<View> viewList = new ArrayList<View>();
    ImageView bannerImg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_homepage_classify,null);
        //找到对应控件id
        sucaiBtn = (RadioButton) view.findViewById(R.id.sucai_btn);
        huncaiBtn = (RadioButton) view.findViewById(R.id.huncai_btn);
        tangcaiBtn = (RadioButton) view.findViewById(R.id.tangcai_btn);
        dianxinBtn = (RadioButton) view.findViewById(R.id.dianxin_btn);
        viewFlipper = (ViewFlipper) view.findViewById(R.id.flipper);
        gestureDetector = new GestureDetector(activity,onGestureListener);
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        radioBtn1 = (RadioButton) view.findViewById(R.id.radio_btn1);
        radioBtn2 = (RadioButton) view.findViewById(R.id.radio_btn2);
        radioBtn3 = (RadioButton) view.findViewById(R.id.radio_btn3);
        radioBtn4 = (RadioButton) view.findViewById(R.id.radio_btn4);

        activity = getActivity();
        ((HomePageActivity)activity).registerMyTouchListener(this);

        //设置点击事件
        sucaiBtn.setOnClickListener(clickListener);
        huncaiBtn.setOnClickListener(clickListener);
        tangcaiBtn.setOnClickListener(clickListener);
        dianxinBtn.setOnClickListener(clickListener);
        radioBtn1.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_btn1:
                        if(viewFlipper.isFlipping()){
                            viewFlipper.stopFlipping();
                            viewFlipper.setDisplayedChild(0);
                            viewFlipper.startFlipping();
                        }else {
                            viewFlipper.setDisplayedChild(0);
                        }
                        break;
                    case R.id.radio_btn2:
                        if(viewFlipper.isFlipping()){
                            viewFlipper.stopFlipping();
                            viewFlipper.setDisplayedChild(1);
                            viewFlipper.startFlipping();
                        }else {
                            viewFlipper.setDisplayedChild(1);
                        }
                        break;
                    case R.id.radio_btn3:
                        if(viewFlipper.isFlipping()){
                            viewFlipper.stopFlipping();
                            viewFlipper.setDisplayedChild(2);
                            viewFlipper.startFlipping();
                        }else {
                            viewFlipper.setDisplayedChild(2);
                        }
                        break;
                    case R.id.radio_btn4:
                        if(viewFlipper.isFlipping()){
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
            view1 = activity.getLayoutInflater().inflate(R.layout.view_flipper_item,null);
            if(i == 0){
                textView = (TextView) view1.findViewById(R.id.name_tv);
                bannerImg = (ImageView) view1.findViewById(R.id.banner_img);
                textView.setText("蓝莓");
                bannerImg.setImageResource(R.mipmap.banner);
                viewFlipper.addView(view1);
            }else if(i == 1){
                textView = (TextView) view1.findViewById(R.id.name_tv);
                bannerImg = (ImageView) view1.findViewById(R.id.banner_img);
                textView.setText("留香排骨");
                bannerImg.setImageResource(R.mipmap.liuxiangpaigu);
                viewFlipper.addView(view1);
            }else if(i == 2){
                textView = (TextView) view1.findViewById(R.id.name_tv);
                bannerImg = (ImageView) view1.findViewById(R.id.banner_img);
                textView.setText("蒜子鳝段");
                bannerImg.setImageResource(R.mipmap.banner2);
                viewFlipper.addView(view1);
            }else {
                textView = (TextView) view1.findViewById(R.id.name_tv);
                bannerImg = (ImageView) view1.findViewById(R.id.banner_img);
                textView.setText("烤三文鱼");
                bannerImg.setImageResource(R.mipmap.kswy);
                viewFlipper.addView(view1);
            }
            textView.setTag(i);
            view1.setTag(i+5);
            viewList.add(view1);
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
        return view;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.sucai_btn:
                    intent = new Intent(activity, ClassifyMeatActivity.class);
                    startActivity(intent);
                    break;
                case R.id.huncai_btn:
                    intent = new Intent(activity, ClassifyMeatActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tangcai_btn:
                    intent = new Intent(activity, ClassifyMeatActivity.class);
                    startActivity(intent);
                    break;
                case R.id.dianxin_btn:
                    intent = new Intent(activity, ClassifyMeatActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };

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
