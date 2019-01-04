package com.example.test.activitiesdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    /**
     * 3-封装启动SecondActivity的操作
     * @param context
     * @param dt1
     * @param dt2
     */
    public static void actionStart(Context context, String dt1, String dt2) {
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("p1", dt1);
        intent.putExtra("p2", dt2);
        context.startActivity(intent);

    }
}
