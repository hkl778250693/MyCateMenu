package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/8.
 */
public class GuidepageLoginActivity extends Activity {
    private TextView guidepagehade;
    private Button loginBtn;
    private Button registeredBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidepage_login);

        loginBtn= (Button) findViewById(R.id.login_btn);
        registeredBtn= (Button) findViewById(R.id.registered_btn);

        registeredBtn.setOnClickListener(onClickListener);
        loginBtn.setOnClickListener(onClickListener);
        into();
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.login_btn:
                    Intent intent=new Intent(GuidepageLoginActivity.this,LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.registered_btn:
                    Intent intent1=new Intent(GuidepageLoginActivity.this,RegisterActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    };

    private void into(){
        guidepagehade= (TextView) findViewById(R.id.tv_guidepage_login);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/fzhzgbjw--gb1.TTF");
        guidepagehade.setTypeface(typeface);
    }
}
