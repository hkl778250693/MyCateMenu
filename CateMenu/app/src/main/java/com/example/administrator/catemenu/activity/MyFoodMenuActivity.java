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
 * Created by abc on 2016/11/11.
 */
public class MyFoodMenuActivity extends Activity {
    @InjectView(R.id.back_btn)
    ImageView backBtn;
    @InjectView(R.id.immediate_menu)
    TextView immediateMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_my_menu);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.back_btn, R.id.immediate_menu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                finish();
                break;
            case R.id.immediate_menu:
                Intent intent = new Intent(MyFoodMenuActivity.this,ImmediateMenuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
