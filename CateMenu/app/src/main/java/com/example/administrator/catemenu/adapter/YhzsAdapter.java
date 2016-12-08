package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Yhzs;

import java.util.List;

import cn.smssdk.gui.DefaultContactViewItem;

/**
 * Created by abc on 2016/11/27.
 */
public class YhzsAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<Yhzs> yhzsList;
    boolean isOpen = true;
    int DEFAULT_LINE = 2;

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
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_feast_item,null);
            viewHolder = new ViewHolder();
            convertView.setTag(viewHolder);
            viewHolder.textViewFeastFoodName = (TextView) convertView.findViewById(R.id.feast_food_name);
            viewHolder.textViewZhankai = (TextView) convertView.findViewById(R.id.feast_zhankai_tv);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Yhzs yhzs = yhzsList.get(position);
        viewHolder.textViewFeastFoodName.setText(yhzs.getFeastFoodName());
        viewHolder.textViewZhankai.setText(yhzs.getZhanKai());
        ViewTreeObserver observer =  viewHolder.textViewFeastFoodName.getViewTreeObserver();
        //获取TextView行数
        final ViewHolder finalViewHolder = viewHolder;
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if ( finalViewHolder.textViewFeastFoodName.getLineCount()<=DEFAULT_LINE){
                    finalViewHolder.textViewZhankai.setVisibility(View.GONE);
                }else if (isOpen &&  finalViewHolder.textViewFeastFoodName.getLineCount()>DEFAULT_LINE){
                    finalViewHolder.textViewFeastFoodName.setHeight(DEFAULT_LINE *  finalViewHolder.textViewFeastFoodName.getLineHeight());
                    finalViewHolder.textViewZhankai.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finalViewHolder.textViewFeastFoodName.setHeight( finalViewHolder.textViewFeastFoodName.getLineCount()* finalViewHolder.textViewFeastFoodName.getLineHeight());
                            finalViewHolder.textViewZhankai.setText("收起");
                            isOpen = false;
                        }
                    });
                }else {
                    finalViewHolder.textViewZhankai.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finalViewHolder.textViewFeastFoodName.setHeight(DEFAULT_LINE *  finalViewHolder.textViewFeastFoodName.getLineHeight());
                            finalViewHolder.textViewZhankai.setText("展开");
                            isOpen = true;
                        }
                    });
                }
            }
        });
        return convertView;
    }
    public class ViewHolder{
        TextView textViewFeastFoodName;
        TextView textViewZhankai;
    }
}
