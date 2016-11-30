package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/7.
 */
public class PersonalSettingsActivity extends Activity {
    ImageView settingBackBtn;
    Intent intent;
    ImageView headImg;
    LayoutInflater layoutInflater;
    LinearLayout personSettingRootLl;
    Button photoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_settings);

        //找到相应控件id
        settingBackBtn = (ImageView) findViewById(R.id.setting_back_btn);
        headImg = (ImageView) findViewById(R.id.head_img);
        personSettingRootLl = (LinearLayout) findViewById(R.id.person_setting_root_ll);

        //设置点击事件
        settingBackBtn.setOnClickListener(clickListener);
        headImg.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.setting_back_btn:
                    intent = new Intent(PersonalSettingsActivity.this,MineActivity.class);
                    startActivity(intent);
                    break;
                case R.id.head_img:
                    photoPopupWindow();
                    break;
            }
        }
    };

    public void photoPopupWindow(){
        layoutInflater = LayoutInflater.from(this);
        View contentView = layoutInflater.inflate(R.layout.popupwindow_photo,null);
        photoBtn = (Button) contentView.findViewById(R.id.photo_btn);

        photoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        PopupWindow popupWindow = new PopupWindow(contentView);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.homepage_edittext_serch_shape));
        popupWindow.showAtLocation(personSettingRootLl, Gravity.BOTTOM,0,0);
    }
}
