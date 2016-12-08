package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.UseRecord;

import java.util.List;

/**
 * Created by abc on 2016/12/8.
 */
public class UseRecordAdapter extends BaseAdapter{
    Context context;
    List<UseRecord> useRecordList;
    LayoutInflater layoutInflater;

    public UseRecordAdapter(Context context,List<UseRecord> useRecordList) {
        this.context = context;
        this.useRecordList = useRecordList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return useRecordList.size();
    }

    @Override
    public Object getItem(int position) {
        return useRecordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_use_record_item,null);
            viewHolder = new ViewHolder();
            viewHolder.integralNumber = (TextView) convertView.findViewById(R.id.integral_number);
            viewHolder.useContent = (TextView) convertView.findViewById(R.id.use_content);
            viewHolder.useTime = (TextView) convertView.findViewById(R.id.use_time);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/xindijianzhiti.ttf");
        viewHolder.integralNumber.setTypeface(typeface);
        viewHolder.integralNumber.getPaint().setFakeBoldText(true);//加粗
        return convertView;
    }

    public class ViewHolder{
        TextView integralNumber;
        TextView useContent;
        TextView useTime;
    }
}
