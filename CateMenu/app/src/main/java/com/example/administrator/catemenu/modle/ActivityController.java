package com.example.administrator.catemenu.modle;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 2016/11/30.
 */
public class ActivityController {
    //创建一个Activity集合用于存储activity
    public static List<Activity> activityList = new ArrayList<Activity>();

    //添加activity方法
    public static void addActivity(Activity activity){
        activityList.add(activity);
    }

    //移除activity方法
    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }

    //销毁所有activity
    public static void finishAll(){
        for(Activity activity:activityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
