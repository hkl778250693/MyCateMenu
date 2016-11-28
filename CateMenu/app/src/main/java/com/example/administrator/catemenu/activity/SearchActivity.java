package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.modle.SearchResult;

/**
 * Created by Administrator on 2016/11/26.
 */
public class SearchActivity extends Activity{
    TextView cancleTv;
    TextView searchTv;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //找到对应控件id
        cancleTv = (TextView) findViewById(R.id.cancle_tv);
        searchTv = (TextView) findViewById(R.id.search_tv);

        //设置点击事件
        cancleTv.setOnClickListener(clickListener);
        searchTv.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.search_tv:
                    intent = new Intent(SearchActivity.this,SearchResultActivity.class);
                    startActivity(intent);
                    break;
                case R.id.cancle_tv:
                    intent = new Intent(SearchActivity.this,HomePageActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
