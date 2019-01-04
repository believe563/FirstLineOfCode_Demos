package com.example.test.activitiesdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 *  以后其它活动继承BasicActivity
 */
public class BasicActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        //1-在logcat打印**当前**活动的名称
        Log.d("BasicActivity", getClass().getSimpleName());

        //2-ActivityControllor类对活动进行统一管理
        ActivityControllor.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityControllor.removeActivity(this);
    }


}
