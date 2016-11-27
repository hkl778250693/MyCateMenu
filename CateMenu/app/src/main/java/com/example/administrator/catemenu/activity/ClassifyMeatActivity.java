package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.MeatItemAdapter;
import com.example.administrator.catemenu.modle.MeatItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 2016/11/11.
 */
public class ClassifyMeatActivity extends Activity {
    ListView huncaiListview;
    List<MeatItem> meatItemList = new ArrayList<MeatItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_meat);

        getData();
        huncaiListview = (ListView) findViewById(R.id.huncai_listview);
        MeatItemAdapter meatItemAdapter = new MeatItemAdapter(this,meatItemList);
        huncaiListview.setAdapter(meatItemAdapter);
    }

    public void getData(){
        for(int i=0;i<10;i++){
            MeatItem meatItem = new MeatItem();
            meatItem.setHuncaiNanduLevelTextview("初级");
            meatItemList.add(meatItem);
        }
    }
}
