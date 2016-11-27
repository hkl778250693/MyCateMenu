package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/8.
 */
public class GuidepageLoginActivity extends Activity {
    TextView loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidepage_login);
        loginbtn= (TextView) findViewById(R.id.tv_login_btn);
        loginbtn.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_login_btn:
                    Intent intent=new Intent(GuidepageLoginActivity.this,LoginActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
