package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.MyApplication;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.MeatItemAdapter;
import com.example.administrator.catemenu.fragment.ClassifyFragment;
import com.example.administrator.catemenu.modle.MeatItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 2016/11/11.
 */
public class ClassifyMeatActivity extends Activity {
    ListView listview;
    List<MeatItem> meatItemList = new ArrayList<MeatItem>();
    ImageView backBtn;
    Intent intent;
    RelativeLayout relativeBtn;
    RelativeLayout relativeBtn1;
    TextView menuNumbTextview;
    TextView collectNumbTextview;
    int num = 1;
    int num1 = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_meat);

        getData();
        //找到对应控件id
        backBtn = (ImageView) findViewById(R.id.back_btn);
        listview = (ListView) findViewById(R.id.listview);
        relativeBtn = (RelativeLayout) findViewById(R.id.relative_btn);
        relativeBtn1 = (RelativeLayout) findViewById(R.id.relative_btn1);
        menuNumbTextview = (TextView) findViewById(R.id.menu_numb_textview);
        collectNumbTextview = (TextView) findViewById(R.id.collect_num_textview);

        //设置点击事件
        backBtn.setOnClickListener(clickListener);
        relativeBtn.setOnClickListener(clickListener);
        relativeBtn1.setOnClickListener(clickListener);

        //设置适配器
        MeatItemAdapter meatItemAdapter = new MeatItemAdapter(this,meatItemList);
        listview.setAdapter(meatItemAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ClassifyMeatActivity.this,FoodDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back_btn:
                    finish();
                    break;
                case R.id.relative_btn:
                    num++;
                    menuNumbTextview.setText(""+num);
                    break;
                case R.id.relative_btn1:
                    num1++;
                    collectNumbTextview.setText(""+num1);
                    break;
            }
            menuNumbTextview.clearFocus();
            collectNumbTextview.clearFocus();
        }
    };

    public void getData(){
        for(int i=0;i<10;i++){
            MeatItem meatItem = new MeatItem();
            meatItem.setHuncaiNanduLevelTextview("初级");
            meatItemList.add(meatItem);
        }
    }
}
