package com.example.administrator.catemenu.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.WeekOrder;

import java.util.List;

/**
 * Created by abc on 2016/11/27.
 */
public class WeekOrderAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<WeekOrder> weekOrderList;

    public WeekOrderAdapter(Context context,List<WeekOrder> weekOrderList){
        this.context = context;
        this.weekOrderList = weekOrderList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return weekOrderList.size();
    }

    @Override
    public Object getItem(int position) {
        return weekOrderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        final ImageView[] closeImg = new ImageView[1];
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.listview_week_item,null);
            viewHolder.headImg = (ImageView) convertView.findViewById(R.id.head_img);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.headImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = layoutInflater.inflate(R.layout.popouwindow_image,null);
                final PopupWindow popupWindow = new PopupWindow(view);
                popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.homepage_edittext_serch_shape));
                popupWindow.showAtLocation(finalViewHolder.headImg, Gravity.CENTER,0,0);
                closeImg[0] = (ImageView) view.findViewById(R.id.close_img);
                closeImg[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
        return convertView;
    }

    public class ViewHolder{
        ImageView headImg;
    }
}
