package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.catemenu.modle.ActivityController;

/**
 * Created by abc on 2016/11/30.
 */
public abstract class BaseActivity extends Activity {
    MyBroadCast myBroadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //registerBroadCast();
        send();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregister();
    }

    public void registerBroadCast(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.hkl.action.play");
        intentFilter.addAction("com.hkl.action.run");
        this.registerReceiver(myBroadCast,intentFilter);
    }
    public void unregister(){
        this.unregisterReceiver(myBroadCast);
    }

    public void send(){
        Intent intent = new Intent();
        intent.putExtra("id",552);
        intent.setAction("com.hkl.action.run");
        sendBroadcast(intent);
    }

    public class MyBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("com.hkl.action.run")){
                Log.i("onReceive","播放音乐");
            }else {
                Log.i("onReceive","其他的广播乱入");
            }
        }
    }
}
