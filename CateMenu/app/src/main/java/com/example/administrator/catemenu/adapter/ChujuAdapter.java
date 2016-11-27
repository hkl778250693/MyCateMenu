package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Chuju;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
public class ChujuAdapter extends BaseAdapter {
    Context context;
    List<Chuju> list;
    LayoutInflater layoutInflater;

    public ChujuAdapter(Context context, List<Chuju> list) {
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
            convertView=layoutInflater.inflate(R.layout.supermarket_chuju_item_layout,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.chuju_imageview);
        TextView textViewName = (TextView) convertView.findViewById(R.id.chuju_name);
        TextView textViewPrice = (TextView) convertView.findViewById(R.id.chuju_price);
        Chuju chuju = list.get(position);
        imageView.setImageResource(chuju.getImage());
        textViewName.setText(chuju.getName());
        textViewPrice.setText(chuju.getPrivace());
        return convertView;
    }
}
