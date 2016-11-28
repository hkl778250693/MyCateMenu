package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.SquareDiscussTopicUserCommentsAdapter;

/**
 * Created by Administrator on 2016/11/28.
 */
public class SquareDiscussTopicUserCommentsActivity extends Activity {
    ListView listView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_discuss_topic_user_comments);
        listView= (ListView) findViewById(R.id.listview_square_discuss_topic_user);
        imageView= (ImageView) findViewById(R.id.iv_user_comments_return);
        SquareDiscussTopicUserCommentsAdapter adapter=new SquareDiscussTopicUserCommentsAdapter(this);
        listView.setAdapter(adapter);
        imageView.setOnClickListener(clickListener);
    }
    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.iv_user_comments_return:
                    finish();
                    break;
            }
        }
    };
}
