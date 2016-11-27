package com.example.administrator.catemenu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.SquareVideoFragemtAdapter;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SquareVideoFragment extends Fragment {
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_square_adapter,null);
        listView= (ListView) view.findViewById(R.id.square_discuss_listview);


        SquareVideoFragemtAdapter videoFragemtAdapter=new SquareVideoFragemtAdapter(getActivity());
        listView.setAdapter(videoFragemtAdapter);

        return view;
    }
}
