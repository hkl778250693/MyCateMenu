package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.ShareListviewActivity;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SquareDiscussFragemtAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context context;
    public SquareDiscussFragemtAdapter(Context context){
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
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
        ViewHolder viewHolder = null;
        if(view == null){
            view=layoutInflater.inflate(R.layout.listview_square_discuss_item,null);
            viewHolder = new ViewHolder();
            viewHolder.userHeadImg = (ImageView) view.findViewById(R.id.user_head_img);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.userHeadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShareListviewActivity.class);
                context.startActivity(intent);
            }
        });
        return view;
    }



    public class ViewHolder{
        ImageView userHeadImg;
    }
}
