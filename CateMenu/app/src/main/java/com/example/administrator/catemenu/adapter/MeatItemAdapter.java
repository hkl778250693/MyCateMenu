package com.example.administrator.catemenu.adapter;

import com.example.administrator.catemenu.activity.ClassifyMeatActivity;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.MeatItem;

import java.util.List;

/**
 * Created by Administrator on 2016/11/15.
 */
public class MeatItemAdapter extends BaseAdapter {
    Context context;
    List<MeatItem> meatItemList;
    LayoutInflater layoutInflater;
    public MeatItemAdapter(ClassifyMeatActivity context, List<MeatItem> meatItemList) {
        this.context = context;
        this.meatItemList = meatItemList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return meatItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return meatItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view != null){
            view = layoutInflater.inflate(R.layout.listview_homepage_huncai_item,null);
        }
        return view;
    }
}
