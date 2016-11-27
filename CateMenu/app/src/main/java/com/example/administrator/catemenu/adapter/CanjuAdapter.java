package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Canju;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class CanjuAdapter extends BaseAdapter {
    Context context;
    List<Canju> list;
    LayoutInflater layoutInflater;

    public CanjuAdapter(Context context, List<Canju> list) {
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
            convertView = layoutInflater.inflate(R.layout.supermarket_canju_item_layout,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.canju1_imageview);
        TextView textView = (TextView) convertView.findViewById(R.id.canju1_name);
        TextView textView1 = (TextView) convertView.findViewById(R.id.canju1_price);
        Canju canju = list.get(position);
        imageView.setImageResource(canju.getImage());
        textView.setText(canju.getName());
        textView1.setText(canju.getPrivace());
        return convertView;
    }

}
