package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.SearchResult;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public class SearchResultAdapter extends BaseAdapter {
    Context context;
    List<SearchResult> list;
    LayoutInflater layoutInflater;

    public SearchResultAdapter(Context context, List<SearchResult> list) {
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
            convertView = layoutInflater.inflate(R.layout.listview_search_result_item,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.search_result_image);
        TextView textViewCaiming = (TextView) convertView.findViewById(R.id.search_result_name);
        TextView textViewPublishPerson = (TextView) convertView.findViewById(R.id.publish_person);
        TextView textViewPublishTime = (TextView) convertView.findViewById(R.id.publish_time);
        SearchResult searchResult = list.get(position);
        imageView.setImageResource(searchResult.getImage());
        textViewCaiming.setText(searchResult.getCaiName());
        textViewPublishPerson.setText(searchResult.getPublishPerson());
        textViewPublishTime.setText(searchResult.getPublishTime());
        return convertView;
    }
}
