package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/12/5.
 */
public class OrderDetailsActivity extends Activity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order_details);
        textView = (TextView) findViewById(R.id.order_queding);
        imageView = (ImageView) findViewById(R.id.order_details_back);
        textView.setOnClickListener(onClickListener);
        imageView.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.order_details_back:
                    finish();
                    break;
                case R.id.order_queding:
                    Intent intent = new Intent(OrderDetailsActivity.this,PaymentDetailsActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
