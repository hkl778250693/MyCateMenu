package com.example.administrator.catemenu.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.ClassifyMeatActivity;
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
    ViewPager viewPager;
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
    ImageView lazyerImageview;
    int[] mImageId;
    int currentPosition = 0;
    int rightFlag = 0;
    int leftFlag = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_homepage_classify,null);
        //找到对应控件id
        sucaiBtn = (RadioButton) view.findViewById(R.id.sucai_btn);
        huncaiBtn = (RadioButton) view.findViewById(R.id.huncai_btn);
        tangcaiBtn = (RadioButton) view.findViewById(R.id.tangcai_btn);
        dianxinBtn = (RadioButton) view.findViewById(R.id.dianxin_btn);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        gestureDetector = new GestureDetector(activity,onGestureListener);
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        radioBtn1 = (RadioButton) view.findViewById(R.id.radio_btn1);
        radioBtn2 = (RadioButton) view.findViewById(R.id.radio_btn2);
        radioBtn3 = (RadioButton) view.findViewById(R.id.radio_btn3);
        radioBtn4 = (RadioButton) view.findViewById(R.id.radio_btn4);

        activity = getActivity();
        ((HomePageActivity)activity).registerMyTouchListener(this);
        setImage();

        //设置点击事件
        sucaiBtn.setOnClickListener(clickListener);
        huncaiBtn.setOnClickListener(clickListener);
        tangcaiBtn.setOnClickListener(clickListener);
        dianxinBtn.setOnClickListener(clickListener);
        radioBtn1.setChecked(true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
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
            float x = e2.getX() - e1.getX();
            float y = e2.getY() - e1.getY();

            if (x > 0) {
                doResult(0);
            } else if (x < 0) {
                doResult(1);
            }
            return true;
        }
    };


    //The method is used to set image
    private void setImage(){
        mImageId=new int[]{R.mipmap.banner,R.mipmap.banner1,R.mipmap.banner2};
        Resources resources = this.getResources();
        Drawable imageDrawable = resources.getDrawable(mImageId[currentPosition]);
        viewPager.setBackgroundDrawable(imageDrawable);
    }

    public void doResult(int action) {
        switch (action) {
            case 0:
                startAnimation();
                currentPosition=(currentPosition+mImageId.length + 1) % mImageId.length;
                setImage();
                break;
            case 1:
                startAnimation();
                currentPosition=(currentPosition+mImageId.length - 1) % mImageId.length;
                setImage();
                break;
        }
    }

    public void startAnimation(){
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(viewPager,"alpha",0F,1.0F);
        alphaAnimator.setDuration(1000);
        alphaAnimator.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator xAnimator = ObjectAnimator.ofInt(viewPager,"X",0,-200);
        xAnimator.setDuration(1000);
        xAnimator.setRepeatMode(ValueAnimator.REVERSE);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaAnimator).with(xAnimator);
        animatorSet.start();
    }

    //重写OnTouchEvent点击事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
