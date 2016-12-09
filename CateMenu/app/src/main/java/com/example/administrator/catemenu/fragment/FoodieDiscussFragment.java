package com.example.administrator.catemenu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.FoodXjqbAdapter;
import com.example.administrator.catemenu.modle.FoodXjqb;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by abc on 2016/12/9.
 */
public class FoodieDiscussFragment extends Fragment {
    ListView listview;
    List<FoodXjqb> foodXjqbList = new ArrayList<FoodXjqb>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foodie_discuss, null);

        getData();
        listview = (ListView) view.findViewById(R.id.listview);
        FoodXjqbAdapter foodXjqbAdapter = new FoodXjqbAdapter(getActivity(), foodXjqbList);
        listview.setAdapter(foodXjqbAdapter);
        return view;
    }

    public void getData() {
        for (int i = 0; i < 10; i++) {
            FoodXjqb foodXjqb = new FoodXjqb();
            foodXjqbList.add(foodXjqb);
        }
    }

}
