package com.example.administrator.catemenu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

/**
 * Created by abc on 2016/12/8.
 */
public class SquarePublishFragment extends Fragment {
    TextView cancle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_square_publish,null);
        //找到对应的控件id
        cancle = (TextView) view.findViewById(R.id.cancel);

        //设置点击事件
        cancle.setOnClickListener(clickListener);

        return view;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cancel:
                    break;
            }
        }
    };
}
