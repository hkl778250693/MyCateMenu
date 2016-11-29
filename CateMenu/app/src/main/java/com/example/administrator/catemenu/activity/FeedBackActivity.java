package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/7.
 */
public class FeedBackActivity extends Activity {
    ImageView backBtn;
    Button commitBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //找到对应的控件
        backBtn = (ImageView) findViewById(R.id.back_btn);
        commitBtn = (Button) findViewById(R.id.commit_btn);

        //设置点击事件
        backBtn.setOnClickListener(clickListener);
        commitBtn.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back_btn:
                    intent = new Intent(FeedBackActivity.this,HomePageActivity.class);
                    startActivity(intent);
                    break;
                case R.id.commit_btn:
                    intent = new Intent(FeedBackActivity.this,HomePageActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
