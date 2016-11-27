package com.example.administrator.catemenu.fragment;

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
    Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_homepage_classify,null);
        huncaiBtn = (RadioButton) view.findViewById(R.id.huncai_btn);
        huncaiBtn.setOnClickListener(clickListener);

        return view;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.huncai_btn:
                    intent = new Intent(getActivity(), ClassifyMeatActivity.class);
                    break;
            }
        }
    };
}
