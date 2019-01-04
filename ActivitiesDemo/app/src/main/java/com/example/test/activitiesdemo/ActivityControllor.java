package com.example.test.activitiesdemo;

import android.app.Activity;

import java.util.List;

/**
 * 对活动进行统一管理
 */
public class ActivityControllor {
    public static List<Activity> activityList;

    public static void addActivity(Activity activity){
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    /**
     * 在任何地方退出程序时，只需要调用该方法
     */
    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        //退出时杀掉当前进程
        android.os.Process.killProcess(android.os.Process.myPid());

    }
}
