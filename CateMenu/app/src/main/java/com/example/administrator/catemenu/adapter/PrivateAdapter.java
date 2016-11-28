package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Private;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
public class PrivateAdapter extends BaseAdapter {
    Context context;
    List<Private> list;
    LayoutInflater layoutInflater;

    public PrivateAdapter(Context context, List<Private> list) {
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
            convertView = layoutInflater.inflate(R.layout.activity_mine_item_layout,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.mine_imageview);
        TextView textViewSheZhi = (TextView) convertView.findViewById(R.id.mine_shezhi);
        TextView textViewShijian = (TextView) convertView.findViewById(R.id.mine_shijian);
        Private p = list.get(position);
        imageView.setImageResource(p.getImageView());
        textViewSheZhi.setText(p.getSheZhi());
        textViewShijian.setText(p.getShiJian());
        return convertView;
    }
}
