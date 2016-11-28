package com.example.administrator.catemenu.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.catemenu.adapter.ChujuAdapter;
import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Chuju;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
public class ChujuFragment extends Fragment {
    List<Chuju> list;
    GridView gridView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shop_rootlayout,null);
        gridView = (GridView) view.findViewById(R.id.gridview);
        Activity activityChuju = getActivity();
        list = getData();
        ChujuAdapter chujuAdapter = new ChujuAdapter(activityChuju,list);
        gridView.setAdapter(chujuAdapter);
        return view;
    }
    //创建数据源
    public List<Chuju> getData(){
        list = new ArrayList<>();
        for (int i=0;i<10;i++){
            Chuju chuju = new Chuju();
            chuju.setImage(R.mipmap.chuju);
            chuju.setName("多层蒸锅不锈钢");
            chuju.setPrivace("￥:45.0");
            list.add(chuju);
        }
        return list;
    }
}
