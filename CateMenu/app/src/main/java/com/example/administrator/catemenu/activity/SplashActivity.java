package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/29.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        boolean mFirst = isFirstEnter(SplashActivity.this,SplashActivity.this.getClass().getName());
        if (mFirst){
            mHandler.sendEmptyMessageDelayed(SWITCH_GUIDEACTIVITY,100);
        }else {
            mHandler.sendEmptyMessageDelayed(SWITCH_HOMEPAGEACTIVITY,100);
        }
        SharedPreferences sharedPreferences= this.getSharedPreferences("my_pref", MODE_PRIVATE);
        sharedPreferences.edit().putString("guide_activity", "false").commit();
    }


    private static final String SHAREDPREFERENCES_NAME = "my_pref";
    private static final String KEY_GUIDE_ACTIVITY = "guide_activity";
    private boolean isFirstEnter(Context context, String className){
        if (context==null||className==null||"".equalsIgnoreCase(className))return false;
        String mResultStr = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_WORLD_READABLE).getString(KEY_GUIDE_ACTIVITY, "");
        if(mResultStr.equalsIgnoreCase("false")){
            return false;
        }else {
            return true;
        }
    }

    private final static int SWITCH_HOMEPAGEACTIVITY = 1000;
    private final static int SWITCH_GUIDEACTIVITY = 1001;
    public Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SWITCH_HOMEPAGEACTIVITY:
                    Intent mIntent = new Intent();
                    mIntent.setClass(SplashActivity.this,HomePageActivity.class);
                    SplashActivity.this.startActivity(mIntent);
                    SplashActivity.this.finish();
                    break;
                case SWITCH_GUIDEACTIVITY:
                    mIntent = new Intent();
                    mIntent.setClass(SplashActivity.this,GuideActivity.class);
                    SplashActivity.this.startActivity(mIntent);
                    SplashActivity.this.finish();
                    break;
            }
            super.handleMessage(msg);
        }
    };
}
