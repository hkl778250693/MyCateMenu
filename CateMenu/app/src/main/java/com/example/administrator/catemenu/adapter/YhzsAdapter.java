package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Yhzs;

import java.util.List;

/**
 * Created by abc on 2016/11/27.
 */
public class YhzsAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<Yhzs> yhzsList;

    public YhzsAdapter(Context context,List<Yhzs> yhzsList){
        this.context = context;
        this.yhzsList = yhzsList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return yhzsList.size();
    }

    @Override
    public Object getItem(int position) {
        return yhzsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_yhzs_item,null);

        }

        return convertView;
    }
}
