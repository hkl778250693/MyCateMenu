package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.WeekOrder;

import java.util.List;

/**
 * Created by abc on 2016/11/27.
 */
public class WeekOrderAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<WeekOrder> weekOrderList;

    public WeekOrderAdapter(Context context,List<WeekOrder> weekOrderList){
        this.context = context;
        this.weekOrderList = weekOrderList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return weekOrderList.size();
    }

    @Override
    public Object getItem(int position) {
        return weekOrderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_week_item,null);
        }
        return convertView;
    }
}
