package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.SeasonItem;

import java.util.List;

/**
 * Created by abc on 2016/11/27.
 */
public class SeasonItemAdapter extends BaseAdapter{
    Context context;
    List<SeasonItem> itemList;
    LayoutInflater layoutInflater;

    public SeasonItemAdapter(Context context,List<SeasonItem> itemList){
        this.context = context;
        this.itemList = itemList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.season_listview_item,null);
        }
        return convertView;
    }

}
