package com.example.administrator.catemenu.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.ClassifyMeatActivity;

/**
 * Created by Administrator on 2016/11/11.
 */
public class ClassifyFragment extends Fragment {
    RadioButton huncaiBtn;
    RadioButton sucai_btn;
    RadioButton tangcai_btn;
    RadioButton dianxin_btn;
    Intent intent;
    Activity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_homepage_classify,null);
        //找到对应控件id
        huncaiBtn = (RadioButton) view.findViewById(R.id.huncai_btn);
        sucai_btn = (RadioButton) view.findViewById(R.id.sucai_btn);
        tangcai_btn = (RadioButton) view.findViewById(R.id.tangcai_btn);
        dianxin_btn = (RadioButton) view.findViewById(R.id.dianxin_btn);

        //设置点击事件
        huncaiBtn.setOnClickListener(clickListener);
        sucai_btn.setOnClickListener(clickListener);
        tangcai_btn.setOnClickListener(clickListener);
        dianxin_btn.setOnClickListener(clickListener);

        activity = getActivity();

        return view;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.huncai_btn:
                    intent = new Intent(activity, ClassifyMeatActivity.class);
                    startActivity(intent);
                    break;
                case R.id.sucai_btn:
                    break;
                case R.id.tangcai_btn:
                    break;
                case R.id.dianxin_btn:
                    break;

            }
        }
    };
}
