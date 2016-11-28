package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.WeekOrderAdapter;
import com.example.administrator.catemenu.fragment.HomepageFragment;
import com.example.administrator.catemenu.modle.WeekOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 2016/11/11.
 */
public class WeekOrderActivity extends Activity {
    ImageView backBtn;
    Intent intent;
    ListView weekListview;
    ImageView headImg;
    ImageView closeImg;
    RadioButton btnBreakfast;
    RadioButton btnLunch;
    RadioButton btnDessert;
    RadioButton btnDinner;
    List<WeekOrder> weekOrderList = new ArrayList<WeekOrder>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_order);

        getData();
        //找到相应的控件id
        backBtn = (ImageView) findViewById(R.id.back_btn);
        headImg = (ImageView) findViewById(R.id.head_img);
        weekListview = (ListView) findViewById(R.id.week_listview);
        btnBreakfast = (RadioButton) findViewById(R.id.btn_breakfast);
        btnLunch = (RadioButton) findViewById(R.id.btn_lunch);
        btnDessert = (RadioButton) findViewById(R.id.btn_dessert);
        btnDinner = (RadioButton) findViewById(R.id.btn_dinner);

        //设置点击事件
        backBtn.setOnClickListener(clickListener);
        headImg.setOnClickListener(clickListener);
        btnBreakfast.setChecked(true);
        btnBreakfast.setOnClickListener(clickListener);
        btnLunch.setOnClickListener(clickListener);
        btnDessert.setOnClickListener(clickListener);
        btnDinner.setOnClickListener(clickListener);

        //设置适配器
        WeekOrderAdapter weekOrderAdapter = new WeekOrderAdapter(this,weekOrderList);
        weekListview.setAdapter(weekOrderAdapter);
        weekListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                headImg = (ImageView) view.findViewById(R.id.head_img);
                headImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View view1 = getLayoutInflater().inflate(R.layout.popouwindow_image,null);
                        final PopupWindow popupWindow = new PopupWindow(view1);
                        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
                        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.homepage_edittext_serch_shape));
                        popupWindow.showAtLocation(headImg,Gravity.CENTER,0,0);
                        closeImg = (ImageView) view1.findViewById(R.id.close_img);
                        closeImg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                popupWindow.dismiss();
                            }
                        });
                    }
                });
            }
        });
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back_btn:
                    intent = new Intent(WeekOrderActivity.this, HomePageActivity.class);
                    startActivity(intent);
                    break;
                case R.id.head_img:
                    intent = new Intent(WeekOrderActivity.this, MineActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_breakfast:
                    if(btnBreakfast.isChecked() == true){
                        btnLunch.setChecked(false);
                        btnDessert.setChecked(false);
                        btnDinner.setChecked(false);
                    }
                    break;
                case R.id.btn_lunch:
                    if(btnLunch.isChecked() == true){
                        btnBreakfast.setChecked(false);
                        btnDessert.setChecked(false);
                        btnDinner.setChecked(false);
                    }
                    break;
                case R.id.btn_dessert:
                    if(btnDessert.isChecked() == true){
                        btnLunch.setChecked(false);
                        btnBreakfast.setChecked(false);
                        btnDinner.setChecked(false);
                    }
                    break;
                case R.id.btn_dinner:
                    if(btnDinner.isChecked() == true){
                        btnLunch.setChecked(false);
                        btnDessert.setChecked(false);
                        btnBreakfast.setChecked(false);
                    }
                    break;
            }
        }
    };

    //获取数据方法
    public void getData(){
        for(int i=0;i<10;i++){
            WeekOrder weekOrder = new WeekOrder();
            weekOrderList.add(weekOrder);
        }
    }

}
