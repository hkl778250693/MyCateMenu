package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class SearchActivity extends Activity{
    TextView cancleTv;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        cancleTv = (TextView) findViewById(R.id.cancle_tv);
        cancleTv.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.cancle_tv:
                    intent = new Intent(SearchActivity.this,HomePageActivity.class);
                    break;
            }
        }
    };
}
