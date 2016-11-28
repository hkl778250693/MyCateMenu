package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.TodayRecommendItem;

import java.util.List;

/**
 * Created by abc on 2016/11/27.
 */
public class TodayRecommendAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<TodayRecommendItem> todayRecommendItemList;

    public TodayRecommendAdapter(Context context,List<TodayRecommendItem> todayRecommendItemList){
        this.context = context;
        this.todayRecommendItemList = todayRecommendItemList;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return todayRecommendItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return todayRecommendItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_today_recommend_item,null);
        }
        return convertView;
    }
}
