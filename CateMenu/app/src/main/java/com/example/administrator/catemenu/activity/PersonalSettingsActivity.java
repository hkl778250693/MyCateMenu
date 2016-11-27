package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/7.
 */
public class PersonalSettingsActivity extends Activity {
    ImageView settingBackBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_settings);

        settingBackBtn = (ImageView) findViewById(R.id.setting_back_btn);
        settingBackBtn.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.setting_back_btn:
                    intent = new Intent(PersonalSettingsActivity.this,MineActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
