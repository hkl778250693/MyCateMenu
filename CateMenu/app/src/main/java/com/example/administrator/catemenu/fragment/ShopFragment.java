package com.example.administrator.catemenu.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/11.
 */
public class ShopFragment extends Fragment {
    RadioGroup radioGroup;
    RadioButton chujuRadioButton;
    RadioButton canjuRadioButton;
    RadioButton tiaoliaoRadioButton;
    //增加的fragment
    ChujuFragment chujuFragment;
    CanjuFragment canjuFragment;
    TiaoliaoFragment tiaoliaoFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_shop,null);
        radioGroup = (RadioGroup) view.findViewById(R.id.shop_radioGroup);

        //找到radioButton相关控件
        canjuRadioButton = (RadioButton) view.findViewById(R.id.canju_radioButton);
        chujuRadioButton = (RadioButton) view.findViewById(R.id.chuju_radioButton);
        tiaoliaoRadioButton = (RadioButton) view.findViewById(R.id.tiaoliao_radioButton);

        //radioGroup设置点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.chuju_radioButton:       //厨具
                        if (chujuFragment==null){
                            chujuFragment = new ChujuFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.shop_linearLayout,chujuFragment);
                            fragmentTransaction.commit();
                        }
                        break;

                    case R.id.canju_radioButton:       //餐具
                        if (canjuFragment==null){
                            canjuFragment = new CanjuFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.shop_linearLayout,canjuFragment);
                            fragmentTransaction.commit();
                        }
                        break;
                    case R.id.tiaoliao_radioButton:    //调料
                        if (tiaoliaoFragment==null){
                            tiaoliaoFragment = new TiaoliaoFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.shop_linearLayout,tiaoliaoFragment);
                            fragmentTransaction.commit();
                        }
                        break;
                }
            }
        });
        return view;
    }
}
