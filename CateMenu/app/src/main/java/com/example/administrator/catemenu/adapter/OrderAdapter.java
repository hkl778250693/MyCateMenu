package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Order;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public class OrderAdapter extends BaseAdapter {
    Context context;
    List<Order> list;
    LayoutInflater layoutInflater;

    public OrderAdapter(Context context, List<Order> list) {
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
            convertView = layoutInflater.inflate(R.layout.listview_food_my_order_item,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.order_image);
        TextView textViewName = (TextView) convertView.findViewById(R.id.order_name);
        TextView textViewCaizi = (TextView) convertView.findViewById(R.id.order_caizhi);
        TextView textViewPrice = (TextView) convertView.findViewById(R.id.order_price);
        TextView textViewNumber = (TextView) convertView.findViewById(R.id.order_number);
        TextView textViewState = (TextView) convertView.findViewById(R.id.order_state);
        Order order = list.get(position);
        imageView.setImageResource(order.getImage());
        textViewName.setText(order.getName());
        textViewCaizi.setText(order.getCaiZi());
        textViewPrice.setText(order.getPrice()+"");
        textViewNumber.setText(order.getNumber()+"");
        textViewState.setText(order.getState());
        return convertView;
    }
}
