package com.example.test.activitiesdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {//取数据
            String tempData = savedInstanceState.getString("data_key");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //4-保存被回收活动的临时数据并在onCreate()中启动数据
        String tempData = "Something you just typed";
        outState.putString("data_key", tempData);//存数据
    }
}
