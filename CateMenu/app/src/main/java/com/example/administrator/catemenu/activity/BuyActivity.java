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
public class BuyActivity extends Activity {
    TextView textViewSub;
    TextView textViewAdd;
    TextView textViewNumber;
    TextView textViewBuy;
    ImageView imageViewBackBuy;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_buy);
        //找到相应控件
        textViewSub = (TextView) findViewById(R.id.numb_sub);
        textViewAdd = (TextView) findViewById(R.id.numb_add);
        textViewNumber = (TextView) findViewById(R.id.number_buy);
        textViewBuy = (TextView) findViewById(R.id.buy_textview);
        imageViewBackBuy = (ImageView) findViewById(R.id.back_buy);
        //设置点击事件
        textViewAdd.setOnClickListener(onClickListener);
        textViewSub.setOnClickListener(onClickListener);
        textViewBuy.setOnClickListener(onClickListener);
        imageViewBackBuy.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.numb_add:
                    i++;
                    textViewNumber.setText(i+"");
                    break;
                case R.id.numb_sub:
                    if (i>0){
                        i--;
                        textViewNumber.setText(i+"");
                    }else {
                        textViewNumber.setText(0+"");
                    }
                    break;
                case R.id.buy_textview:
                    Intent intent = new Intent(BuyActivity.this,BuySuccessActivity.class);
                    startActivity(intent);
                    break;
                case R.id.back_buy:
                    finish();
                    break;
            }
            textViewNumber.clearFocus();
        }
    };
}
