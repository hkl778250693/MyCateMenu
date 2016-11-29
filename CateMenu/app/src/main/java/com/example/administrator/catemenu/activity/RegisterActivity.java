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

import com.example.administrator.catemenu.R;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2016/10/21.
 */
public class RegisterActivity extends Activity {
    CheckBox eyeBtn;
    CheckBox eye1Btn;
    EditText edittext;
    EditText edittext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eyeBtn = (CheckBox) findViewById(R.id.eye_btn);
        eye1Btn = (CheckBox) findViewById(R.id.eye1_btn);
        edittext = (EditText) findViewById(R.id.edittext);
        edittext1 = (EditText) findViewById(R.id.edittext1);

        eyeBtn.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.eye_btn:
                    if(eyeBtn.isChecked()){
                        edittext.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    }else if (eyeBtn.isChecked()){
                        edittext.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }
                    break;
                case R.id.eye1_btn:
                    if(eye1Btn.isChecked()){
                        edittext.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    }else{
                        edittext1.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }
                    break;
            }
        }
    };
}
