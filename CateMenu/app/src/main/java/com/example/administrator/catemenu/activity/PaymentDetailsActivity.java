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
public class PaymentDetailsActivity extends Activity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        imageView = (ImageView) findViewById(R.id.payment_details_back);
        textView = (TextView) findViewById(R.id.payment_details_pay);
        imageView.setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.payment_details_back:
                    finish();
                    break;
                case R.id.payment_details_pay:
                    Intent intent = new Intent(PaymentDetailsActivity.this,BuySuccessActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
