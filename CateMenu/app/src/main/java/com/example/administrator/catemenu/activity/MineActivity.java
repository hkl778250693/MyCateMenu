package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/7.
 */
public class MineActivity extends Activity {
    ImageView mineBackBtn;
    TextView sixinTextview;
    TextView settingBtn;
    TextView passwordChangeTv;
    TextView todaySigninTv;
    TextView collectTv;
    TextView shareTv;
    TextView attentionTv;
    TextView uploadTv;
    TextView orderTv;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        //找到对应控件id
        mineBackBtn = (ImageView) findViewById(R.id.mine_back_btn);
        sixinTextview = (TextView) findViewById(R.id.sixin_textview);
        settingBtn = (TextView) findViewById(R.id.setting_btn);
        passwordChangeTv = (TextView) findViewById(R.id.password_change_tv);
        todaySigninTv = (TextView) findViewById(R.id.today_signin_tv);
        collectTv = (TextView) findViewById(R.id.collect_tv);
        shareTv = (TextView) findViewById(R.id.share_tv);
        attentionTv = (TextView) findViewById(R.id.attention_tv);
        uploadTv = (TextView) findViewById(R.id.upload_tv);
        orderTv = (TextView) findViewById(R.id.order_tv);

        //设置点击事件
        mineBackBtn.setOnClickListener(clickListener);
        sixinTextview.setOnClickListener(clickListener);
        settingBtn.setOnClickListener(clickListener);
        passwordChangeTv.setOnClickListener(clickListener);
        todaySigninTv.setOnClickListener(clickListener);
        collectTv.setOnClickListener(clickListener);
        shareTv.setOnClickListener(clickListener);
        attentionTv.setOnClickListener(clickListener);
        uploadTv.setOnClickListener(clickListener);
        orderTv.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.mine_back_btn:
                    intent = new Intent(MineActivity.this,HomePageActivity.class);
                    startActivity(intent);
                    break;
                case R.id.sixin_textview:
                    intent = new Intent(MineActivity.this,MinePrivateLetterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.setting_btn:
                    intent = new Intent(MineActivity.this,PersonalSettingsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.password_change_tv:
                    intent = new Intent(MineActivity.this,ChangePasswordActivity.class);
                    startActivity(intent);
                    break;
                case R.id.today_signin_tv:
                    intent = new Intent(MineActivity.this,SigninActivity.class);
                    startActivity(intent);
                    break;
                case R.id.collect_tv:
                    intent = new Intent(MineActivity.this,CollectActivity.class);
                    startActivity(intent);
                    break;
                case R.id.share_tv:
                    intent = new Intent(MineActivity.this,ShareActivity.class);
                    startActivity(intent);
                    break;
                case R.id.attention_tv:
                    intent = new Intent(MineActivity.this,AttentionActivity.class);
                    startActivity(intent);
                    break;
                case R.id.upload_tv:
                    intent = new Intent(MineActivity.this,UploadActivity.class);
                    startActivity(intent);
                    break;
                case R.id.order_tv:
                    intent = new Intent(MineActivity.this,MyFoodOrderActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    };
}
