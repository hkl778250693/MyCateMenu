package com;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by abc on 2016/11/25.
 */
public class MyApplication extends Application{
    //Application类的作用。当app创建的时候是先执行创建application这个类生成一个对象
    public boolean isLogin=false;//可以在Application的类里面定义一些变量做为全局属性
    @Override
    public void onCreate() {
        super.onCreate();
        //getBaseContext()//此时获得的上下文对象是Application的上下文对象，也就是整个app的上下文
        //不建议在Activity随意 getApplicationContext();
//        SharedPreferences sharedPreferences=getSharedPreferences();
//        sharedPreferences.getString("numb");
        //init();//初始化一些参数,创建数据库
        //       MyApplication myApplication=(MyApplication)getApplication(); 可以在所有的Activity页面获得当前Application的对象

    }
}
