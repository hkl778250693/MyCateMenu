package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Tiaoliao;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
public class TiaoliaoAdapter extends BaseAdapter {
    Context context;
    List<Tiaoliao> list;
    LayoutInflater layoutInflater;

    public TiaoliaoAdapter(Context context, List<Tiaoliao> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.supermarket_tiaoliao_item_layout,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.tiaoliao_imageview);
        TextView textViewName = (TextView) convertView.findViewById(R.id.tiaoliao_name);
        TextView textViewPrice = (TextView) convertView.findViewById(R.id.tiaoliao_price);
        Tiaoliao tiaoliao = list.get(position);
        imageView.setImageResource(tiaoliao.getImage());
        textViewName.setText(tiaoliao.getName());
        textViewPrice.setText(tiaoliao.getPrivace());
        return convertView;
    }
}
