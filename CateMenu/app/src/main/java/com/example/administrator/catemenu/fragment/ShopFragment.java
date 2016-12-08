package com.example.administrator.catemenu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.ShopFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class ShopFragment extends Fragment {
    RadioGroup radioGroup;
    RadioButton chujuRadioButton;
    RadioButton canjuRadioButton;
    RadioButton tiaoliaoRadioButton;
    //增加的fragment
    List<Fragment> fragmentList;
    ViewPager viewPager;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_shop,null);

        //找到radioButton相关控件
        canjuRadioButton = (RadioButton) view.findViewById(R.id.canju_radioButton);
        chujuRadioButton = (RadioButton) view.findViewById(R.id.chuju_radioButton);
        tiaoliaoRadioButton = (RadioButton) view.findViewById(R.id.tiaoliao_radioButton);
        viewPager = (ViewPager) view.findViewById(R.id.shop_viewPager);

        //radioGroup设置点击事件
        chujuRadioButton.setOnClickListener(clickListener);
        canjuRadioButton.setOnClickListener(clickListener);
        tiaoliaoRadioButton.setOnClickListener(clickListener);

        chujuRadioButton.setChecked(true);

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new ChujuFragment());
        fragmentList.add(new CanjuFragment());
        fragmentList.add(new TiaoliaoFragment());

        fragmentManager = getChildFragmentManager();
        viewPager.setAdapter(new ShopFragmentPagerAdapter(fragmentManager,fragmentList));
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        chujuRadioButton.setChecked(true);
                        break;
                    case 1:
                        canjuRadioButton.setChecked(true);
                        break;
                    case 2:
                        tiaoliaoRadioButton.setChecked(true);
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
        public void onClick(View v) {
            fragmentManager = getChildFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (v.getId()){
                case R.id.chuju_radioButton:       //厨具
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.canju_radioButton:       //餐具
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.tiaoliao_radioButton:    //调料
                    viewPager.setCurrentItem(2);
                    break;
            }
            transaction.commit();
        }
    };

}
