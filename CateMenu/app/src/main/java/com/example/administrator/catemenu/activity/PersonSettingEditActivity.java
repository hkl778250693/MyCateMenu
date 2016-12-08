package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.catemenu.R;

/**
 * Created by abc on 2016/12/8.
 */
public class PersonSettingEditActivity extends Activity {
    ImageView settingBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_setting_edit);

        //找到控件id
        settingBackBtn = (ImageView) findViewById(R.id.setting_back_btn);

        //设置点击事件
        settingBackBtn.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.setting_back_btn:
                    finish();
                    break;
            }
        }
    };
}
