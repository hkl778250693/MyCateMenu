package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class SixinActivity extends Activity {
    ImageView imageView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixin);
        imageView = (ImageView) findViewById(R.id.sixin_fanhui);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(SixinActivity.this,MinePrivateLetterActivity.class);
                startActivity(intent);
            }
        });
    }
}
