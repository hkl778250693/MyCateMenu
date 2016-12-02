package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

/**
 * Created by abc on 2016/12/2.
 */
public class SquarePublishActivity extends Activity {
    TextView cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_publish);

        //找到对应的控件id
        cancle = (TextView) findViewById(R.id.cancel);

        //设置点击事件
        cancle.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cancel:
                    finish();
                    break;
            }
        }
    };
}
