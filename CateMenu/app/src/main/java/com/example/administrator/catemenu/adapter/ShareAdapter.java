package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.Share;

import java.util.List;

/**
 * Created by abc on 2016/12/9.
 */
public class ShareAdapter extends BaseAdapter {
    Context context;
    List<Share> shareList;
    LayoutInflater layoutInflater;

    public ShareAdapter(Context context,List<Share> shareList) {
        this.context = context;
        this.shareList = shareList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return shareList.size();
    }

    @Override
    public Object getItem(int position) {
        return shareList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_share_item,null);
            viewHolder = new ViewHolder();
            viewHolder.time = (TextView) convertView.findViewById(R.id.time_tv);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content_textview);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        return convertView;
    }

    public class ViewHolder{
        TextView time;
        TextView content;
        ImageView image;
    }
}
