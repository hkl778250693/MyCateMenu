package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/28.
 */
public class SquareDiscussTopicUserCommentsAdapter extends BaseAdapter {
    Context context;
    public SquareDiscussTopicUserCommentsAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.listview_item_square_discuss_topic_user_comments,null);
        return view;
    }
}
