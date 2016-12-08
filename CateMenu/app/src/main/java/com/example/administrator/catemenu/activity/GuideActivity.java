package com.example.administrator.catemenu.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.ViewPagerAdapter;
import com.example.administrator.catemenu.modle.Zoom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */
public class GuideActivity extends Activity {
    ViewPager viewPager;
    List<View> arraylist;
    TextView tvgetlogin;
    GestureDetector gestureDetector;
    View view;
    View view1;
    View view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到对应的控件
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        gestureDetector = new GestureDetector(this,onGestureListener);

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        view = layoutInflater.inflate(R.layout.viewpager_guidepage_one, null);
        view1 = layoutInflater.inflate(R.layout.viewpager_guidepage_two, null);
        view2 = layoutInflater.inflate(R.layout.viewpager_guidepage_three, null);
        arraylist = new ArrayList<View>();
        arraylist.add(view);
        arraylist.add(view1);
        arraylist.add(view2);

        //viewPager.setPageTransformer(true,new DepthPageTransformer());
        viewPager.setPageTransformer(true,new Zoom());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(arraylist);
        viewPager.setAdapter(viewPagerAdapter);

        into();
        tvgetlogin = (TextView) view2.findViewById(R.id.tv_getlogin);
        tvgetlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideActivity.this,HomePageActivity.class);
                startActivity(intent);
            }
        });
    }

    GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //startAnimation();
            return false;
        }
    };

    //引导页动画效果
    public void startAnimation(){
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(viewPager,"alpha",1.0F,0F,1.0F);
        alphaAnimator.setDuration(2000);
        alphaAnimator.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(viewPager,"RotationY",0F,180F,0F);
        rotateAnimator.setDuration(2000);
        rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaAnimator).with(rotateAnimator);
        animatorSet.start();
    }

    //重写onTouchEvent事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    //重写页面销毁方法

    private void into() {
        TextView text = (TextView) view.findViewById(R.id.tv_text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/zitiguanjiafangmeng.ttf");
        text.setTypeface(typeface);
        TextView text1 = (TextView) view1.findViewById(R.id.tv_text1);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/zitiguanjiafangmeng.ttf");
        text1.setTypeface(typeface1);
        TextView text2 = (TextView) view2.findViewById(R.id.tv_text2);
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/zitiguanjiafangmeng.ttf");
        text2.setTypeface(typeface2);
        TextView text3= (TextView) view2.findViewById(R.id.tv_getlogin);
        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/zitiguanjiafangmeng.ttf");
        text3.setTypeface(typeface3);

    }
}
