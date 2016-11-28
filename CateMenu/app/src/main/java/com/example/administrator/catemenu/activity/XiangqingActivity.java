package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class XiangqingActivity extends Activity {
    Intent intent;
    TextView textViewGoumai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        textViewGoumai = (TextView) findViewById(R.id.goumai_textview);
        textViewGoumai.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.goumai_textview:
                    intent = new Intent(XiangqingActivity.this,BuyActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
