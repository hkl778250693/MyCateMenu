package com.example.administrator.catemenu.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
    LinearLayout shopLinearLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_shop,null);

        //找到radioButton相关控件
        canjuRadioButton = (RadioButton) view.findViewById(R.id.canju_radioButton);
        chujuRadioButton = (RadioButton) view.findViewById(R.id.chuju_radioButton);
        tiaoliaoRadioButton = (RadioButton) view.findViewById(R.id.tiaoliao_radioButton);
        shopLinearLayout = (LinearLayout) view.findViewById(R.id.shop_linearLayout);

        //radioGroup设置点击事件
        chujuRadioButton.setOnClickListener(clickListener);
        canjuRadioButton.setOnClickListener(clickListener);
        tiaoliaoRadioButton.setOnClickListener(clickListener);

        chujuRadioButton.setChecked(true);
        if(chujuRadioButton.isChecked()){
            addHomepageFragment();
        }
        return view;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (v.getId()){
                case R.id.chuju_radioButton:       //厨具
                    if (chujuFragment==null){
                        chujuFragment = new ChujuFragment();
                    }
                    transaction.replace(R.id.shop_linearLayout,chujuFragment);
                    break;
                case R.id.canju_radioButton:       //餐具
                    if (canjuFragment==null){
                        canjuFragment = new CanjuFragment();
                    }
                    transaction.replace(R.id.shop_linearLayout,canjuFragment);
                    break;
                case R.id.tiaoliao_radioButton:    //调料
                    if (tiaoliaoFragment==null){
                        tiaoliaoFragment = new TiaoliaoFragment();
                    }
                    transaction.replace(R.id.shop_linearLayout,tiaoliaoFragment);
                    break;
            }
            transaction.commit();
        }
    };

    public void addHomepageFragment() {
        chujuFragment = new ChujuFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.shop_linearLayout, chujuFragment);
        fragmentTransaction.commit();
    }
}
