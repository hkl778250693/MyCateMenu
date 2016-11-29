package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by Administrator on 2016/10/21.
 */
public class RegisterActivity extends Activity {
    CheckBox eyeBtn;
    CheckBox eye1Btn;
    EditText edittext;
    EditText edittext1;
    EditText etphonenumber;
    TextView tvzhuche;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eyeBtn = (CheckBox) findViewById(R.id.eye_btn);
        eye1Btn = (CheckBox) findViewById(R.id.eye1_btn);
        edittext = (EditText) findViewById(R.id.edittext);
        edittext1 = (EditText) findViewById(R.id.edittext1);
        etphonenumber= (EditText) findViewById(R.id.et_phonenumber);
        tvzhuche= (TextView) findViewById(R.id.tv_zhuce);

        eyeBtn.setOnClickListener(clickListener);
        tvzhuche.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.eye_btn:
                    if (eyeBtn.isChecked()) {
                        edittext.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    } else if (eyeBtn.isChecked()) {
                        edittext.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }
                    break;
                case R.id.eye1_btn:
                    if (eye1Btn.isChecked()) {
                        edittext.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    } else {
                        edittext1.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }
                    break;
                case R.id.tv_zhuce:
                    init();
                    break;

            }
        }
    };

    public void init() {
        SMSSDK.initSDK(this, "197280250e16a", "0af24d5f88fd1cfa6c40dcbdd011b5a3");
        final RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            @Override
            public void afterEvent(int i, int i1, Object o) {
                if (i1 == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = new HashMap<String, Object>();
                    phoneMap.put("phone",etphonenumber.getText());
                   // String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");

// 提交用户信息（此方法可以不调用）
                   // registerUser(country, phone);
                }
            }
        });
        registerPage.show(this);
    }
}
