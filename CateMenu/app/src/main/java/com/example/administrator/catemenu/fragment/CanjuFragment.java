package com.example.administrator.catemenu.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.catemenu.adapter.CanjuAdapter;
import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Canju;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class CanjuFragment extends Fragment {
    List<Canju> list;
    GridView gridView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.supermarket_canju_layout,null);
        Activity canjuActivity = getActivity();
        gridView = (GridView) view.findViewById(R.id.canju_gridview);
        list=getData();
        CanjuAdapter canjuAdapter = new CanjuAdapter(canjuActivity,list);
        gridView.setAdapter(canjuAdapter);
        return view;
    }
    //餐具数据源
    public List<Canju> getData(){
        list = new ArrayList<>();
        for (int i=0;i<9;i++){
            Canju canju = new Canju();
            canju.setImage(R.mipmap.canju1);
            canju.setName("宏拓天然红木筷子");
            canju.setPrivace("￥:25.0");
            list.add(canju);
        }
        return list;
    }
}
