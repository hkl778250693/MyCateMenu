package com.example.administrator.catemenu.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.catemenu.adapter.TiaoliaoAdapter;
import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Tiaoliao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
public class TiaoliaoFragment extends Fragment {
    List<Tiaoliao> list;
    GridView gridView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shop_rootlayout,null);
        gridView = (GridView) view.findViewById(R.id.gridview);
        Activity activityTiaoliao = getActivity();
        list = getData();
        TiaoliaoAdapter tiaoliaoAdapter = new TiaoliaoAdapter(activityTiaoliao,list);
        gridView.setAdapter(tiaoliaoAdapter);
        return view;
    }
    //创建数据
    public List<Tiaoliao> getData(){
        list = new ArrayList<>();
        for (int i=0;i<9;i++){
            Tiaoliao tiaoliao = new Tiaoliao();
            tiaoliao.setImage(R.mipmap.tiaoliao);
            tiaoliao.setName("四川正宗特产汉源花椒油");
            tiaoliao.setPrivace("￥:23.7");
            list.add(tiaoliao);
        }
        return list;
    }
}
