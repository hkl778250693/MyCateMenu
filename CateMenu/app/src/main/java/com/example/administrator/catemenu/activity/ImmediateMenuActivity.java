package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.catemenu.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by abc on 2016/11/11.
 */
public class ImmediateMenuActivity extends Activity {
    @InjectView(R.id.back_btn)
    ImageView backBtn;
    @InjectView(R.id.add_imageview)
    ImageView addImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immediate_menu);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.back_btn, R.id.add_imageview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                finish();
                break;
            case R.id.add_imageview:
                break;
        }
    }
}
