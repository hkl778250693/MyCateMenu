package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_meat);

        getData();
        //找到对应控件id
        backBtn = (ImageView) findViewById(R.id.back_btn);
        listview = (ListView) findViewById(R.id.listview);

        //设置点击事件
        backBtn.setOnClickListener(clickListener);

        //设置适配器
        MeatItemAdapter meatItemAdapter = new MeatItemAdapter(this,meatItemList);
        listview.setAdapter(meatItemAdapter);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back_btn:
                    intent = new Intent(ClassifyMeatActivity.this, HomePageActivity.class);
                    startActivity(intent);
                    break;
            }
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
