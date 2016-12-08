package com.example.administrator.catemenu.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.support.v4.app.Fragment;
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
import com.example.administrator.catemenu.adapter.BannerImage;
import com.example.administrator.catemenu.adapter.ImageViewPagerAdapter;

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
    RadioGroup radioGroup;
    RadioButton radioBtn1;
    RadioButton radioBtn2;
    RadioButton radioBtn3;
    Intent intent;
    View view;
    private ArrayList<View> bannerImageList = new ArrayList<View>();

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
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        radioBtn1 = (RadioButton) view.findViewById(R.id.radio_btn1);
        radioBtn2 = (RadioButton) view.findViewById(R.id.radio_btn2);
        radioBtn3 = (RadioButton) view.findViewById(R.id.radio_btn3);

        activity = getActivity();
        ((HomePageActivity)activity).registerMyTouchListener(this);

        //设置点击事件
        sucaiBtn.setOnClickListener(clickListener);
        huncaiBtn.setOnClickListener(clickListener);
        tangcaiBtn.setOnClickListener(clickListener);
        dianxinBtn.setOnClickListener(clickListener);
        radioBtn1.setOnClickListener(clickListener);
        radioBtn2.setOnClickListener(clickListener);
        radioBtn3.setOnClickListener(clickListener);
        radioBtn1.setChecked(true);
        initViewPagerImage();
        viewPager.setAdapter(new ImageViewPagerAdapter(bannerImageList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioBtn1.setChecked(true);
                        break;
                    case 1:
                        radioBtn2.setChecked(true);
                        break;
                    case 2:
                        radioBtn3.setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
                case R.id.radio_btn1:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.radio_btn2:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.radio_btn3:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.radio_btn4:
                    viewPager.setCurrentItem(3);
                    break;
                default:
                    break;
            }
        }
    };

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

    public void initViewPagerImage(){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.banner_image_item,null);
        View view1 = layoutInflater.inflate(R.layout.banner_image_item,null);
        View view2 = layoutInflater.inflate(R.layout.banner_image_item,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.banner_imageview);
        ImageView imageView1 = (ImageView) view1.findViewById(R.id.banner_imageview);
        ImageView imageView2 = (ImageView) view2.findViewById(R.id.banner_imageview);
        imageView.setImageResource(R.mipmap.banner1);
        imageView1.setImageResource(R.mipmap.banner);
        imageView2.setImageResource(R.mipmap.banner2);
        bannerImageList.add(view);
        bannerImageList.add(view1);
        bannerImageList.add(view2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
