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
public class FoodOrderDetailsActivity extends Activity {
    @InjectView(R.id.order_details_back)
    ImageView orderDetailsBack;
    @InjectView(R.id.guide_name)
    TextView guideName;
    @InjectView(R.id.order_queding)
    TextView orderQueding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order_details);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.order_details_back, R.id.guide_name, R.id.order_queding})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_details_back:
                finish();
                break;
            case R.id.guide_name:
                break;
            case R.id.order_queding:
                Intent intent = new Intent(FoodOrderDetailsActivity.this,FoodPaymentDetailsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
