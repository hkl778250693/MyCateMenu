package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.SquareDiscussTopicAdapter;

/**
 * Created by Administrator on 2016/11/28.
 */
public class SquareDiscussTopicActivity extends Activity {
    private ListView listView;
    private LayoutInflater layoutInflater;
    private Intent intent;
    private TextView topicRaturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_discuss_fragment_item);

        listView= (ListView) findViewById(R.id.listview_square_discuss_topic);
        topicRaturn= (TextView) findViewById(R.id.tv_topic_return);

        topicRaturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        layoutInflater=getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.listview_head_square_discuss_topic,null);
        ImageView imageView= (ImageView) view.findViewById(R.id.iv_message);
        imageView.setOnClickListener(clickListener);
        listView.addHeaderView(view);
        SquareDiscussTopicAdapter adapter=new SquareDiscussTopicAdapter(this);
        listView.setAdapter(adapter);

    }
    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.iv_message:
                    intent=new Intent(SquareDiscussTopicActivity.this,SquareDiscussTopicUserCommentsActivity.class);
                    startActivity(intent);
                    break;
//                case R.id.iv_user_comments_return:
//                    finish();
//                    break;
            }
        }
    };
}
