package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.catemenu.R;

/**
 * Created by abc on 2016/11/27.
 */
public class MadeDetailsActivity extends Activity {
    ImageView backImg;
    ImageView headImg;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_made_details);

        //找到对应的控件id
        backImg = (ImageView) findViewById(R.id.back_img);
        headImg = (ImageView) findViewById(R.id.head_img);

        //设置点击事件
        backImg.setOnClickListener(clickListener);
        headImg.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back_img:
                    intent = new Intent(MadeDetailsActivity.this,SearchActivity.class);
                    startActivity(intent);
                    break;
                case R.id.head_img:
                    intent = new Intent(MadeDetailsActivity.this,MineActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
