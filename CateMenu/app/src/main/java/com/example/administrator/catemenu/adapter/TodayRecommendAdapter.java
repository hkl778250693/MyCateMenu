package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.TodayRecommendItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by abc on 2016/11/27.
 */
public class TodayRecommendAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<TodayRecommendItem.ResultBean> todayRecommendItemList;

    public TodayRecommendAdapter(Context context, List<TodayRecommendItem.ResultBean> todayRecommendItemList) {
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_today_recommend_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        TodayRecommendItem.ResultBean resultBean=todayRecommendItemList.get(position);
        viewHolder.tvFoodname.setText(resultBean.getName());
        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_imageurl)
        ImageView ivImageurl;
        @InjectView(R.id.tv_foodname)
        TextView tvFoodname;
        @InjectView(R.id.ll_efficacy)
        LinearLayout llEfficacy;
        @InjectView(R.id.tv_mainintroduction)
        TextView tvMainintroduction;
        @InjectView(R.id.tv_content)
        TextView tvContent;
        @InjectView(R.id.more_tv)
        TextView moreTv;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
