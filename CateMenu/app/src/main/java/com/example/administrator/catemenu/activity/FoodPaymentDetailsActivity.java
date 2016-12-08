package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/7.
 */
public class FoodPaymentDetailsActivity extends Activity {
    @InjectView(R.id.payment_details_back)
    ImageView paymentDetailsBack;
    @InjectView(R.id.pay_textview)
    TextView payTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        ButterKnife.inject(this);
    }


    @OnClick({R.id.payment_details_back, R.id.pay_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.payment_details_back:
                finish();
                break;
            case R.id.pay_textview:
                Intent intent = new Intent(FoodPaymentDetailsActivity.this,BuySuccessActivity.class);
                startActivity(intent);
                break;
        }
    }
}
