package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class ShopXiangqingActivity extends Activity {
    Intent intent;
    TextView textViewGoumai;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_xiangqing);
        //找到相应控件
        textViewGoumai = (TextView) findViewById(R.id.goumai_textview);
        imageView = (ImageView) findViewById(R.id.back_xiangqing);
        //设置点击事件
        textViewGoumai.setOnClickListener(onClickListener);
        imageView.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.goumai_textview:
                    intent = new Intent(ShopXiangqingActivity.this,BuyActivity.class);
                    startActivity(intent);
                    break;
                case R.id.back_xiangqing:
                    finish();
                    break;
            }
        }
    };
}
