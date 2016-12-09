package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.ShareAdapter;
import com.example.administrator.catemenu.modle.Share;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by abc on 2016/12/9.
 */
public class ShareListviewActivity extends Activity {
    LayoutInflater layoutInflater;
    @InjectView(R.id.share_listview)
    ListView shareListview;
    List<Share> shareList = new ArrayList<Share>();
    ImageView backBtn;
    ImageView userHeadImg;
    TextView userNameTextview;
    TextView zanNumber;
    TextView collectNumber;
    TextView attentionTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_share);
        ButterKnife.inject(this);

        getData();
        backBtn = (ImageView) findViewById(R.id.back_btn);
        backBtn.setOnClickListener(clickListener);
        layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.activity_someone_homepage, null);
        shareListview.addHeaderView(view);
        ShareAdapter shareAdapter = new ShareAdapter(ShareListviewActivity.this, shareList);
        shareListview.setAdapter(shareAdapter);
    }

    public void getData() {
        for (int i = 0; i < 10; i++) {
            Share share = new Share();
            shareList.add(share);
        }
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.back_btn:
                    finish();
                    break;
                case R.id.user_head_img:
                    break;
                case R.id.user_name_textview:
                    break;
                case R.id.zan_number:
                    break;
                case R.id.collect_number:
                    break;
                case R.id.attention_textview:
                    break;
            }
        }
    };
}
