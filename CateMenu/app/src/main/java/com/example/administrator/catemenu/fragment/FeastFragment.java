package com.example.administrator.catemenu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.YhzsAdapter;
import com.example.administrator.catemenu.modle.Yhzs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class FeastFragment extends Fragment {
    ListView yhzsListview;
    List<Yhzs> yhzsList = new ArrayList<Yhzs>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_feast,null);

        getData();
        yhzsListview = (ListView) view.findViewById(R.id.yhzs_listview);
        YhzsAdapter yhzsAdapter = new YhzsAdapter(getActivity(),yhzsList);
        yhzsListview.setAdapter(yhzsAdapter);
        return view;
    }

    public void getData(){
        for(int i=0;i<10;i++){
            Yhzs yhzs = new Yhzs();
            yhzs.setTimeTv("100分钟");
            yhzsList.add(yhzs);
        }
    }
}
