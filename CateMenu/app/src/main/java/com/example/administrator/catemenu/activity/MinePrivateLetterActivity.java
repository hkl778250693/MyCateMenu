package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.PrivateAdapter;
import com.example.administrator.catemenu.modle.Private;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */
public class MinePrivateLetterActivity extends Activity {
    ImageView siXinBackBtn;
    Intent intent;
    ListView listView;
    List<Private> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_private_letter);

        siXinBackBtn = (ImageView) findViewById(R.id.sixin_back_btn);
        siXinBackBtn.setOnClickListener(clickListener);
        listView = (ListView) findViewById(R.id.mine_listview);
        list = getData();
        PrivateAdapter privateAdapter = new PrivateAdapter(this,list);
        listView.setAdapter(privateAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(MinePrivateLetterActivity.this,SixinActivity.class);
                startActivity(intent);
            }
        });
    }
    public List<Private> getData(){
        list = new ArrayList<>();
        for (int i=0;i<10;i++){
            Private p = new Private();
            p.setImageView(R.mipmap.head_img1);
            p.setSheZhi("个人设置");
            p.setShiJian("暴走大事件，每周五更新");
            list.add(p);
        }
        return list;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.sixin_back_btn:
                    intent = new Intent(MinePrivateLetterActivity.this,MineActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
