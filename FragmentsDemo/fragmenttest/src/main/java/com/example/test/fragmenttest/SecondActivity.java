package com.example.test.fragmenttest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends Activity {

    public static void actionStart(Context applicationContext) {
        Intent intent = new Intent(applicationContext, SecondActivity.class);
//        添加该条flag是为了在activity外部能够打开另一个Activity（geto(*￣▽￣*)ブ）
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        applicationContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }
}
