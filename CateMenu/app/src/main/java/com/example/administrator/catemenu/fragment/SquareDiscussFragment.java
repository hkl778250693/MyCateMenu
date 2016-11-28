package com.example.administrator.catemenu.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.SquareDiscussTopicActivity;
import com.example.administrator.catemenu.adapter.SquareDiscussFragemtAdapter;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SquareDiscussFragment extends Fragment {
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_square_adapter,null);
        listView= (ListView) view.findViewById(R.id.square_discuss_listview);

        SquareDiscussFragemtAdapter discussFragemtAdapter=new SquareDiscussFragemtAdapter(getActivity());
        listView.setAdapter(discussFragemtAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getActivity(), SquareDiscussTopicActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        return view;
    }
}
