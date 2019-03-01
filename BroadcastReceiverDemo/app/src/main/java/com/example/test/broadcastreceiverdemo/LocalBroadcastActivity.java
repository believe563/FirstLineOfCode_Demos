package com.example.test.broadcastreceiverdemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 用动态注册广播的方式注册本地广播
 * 本地广播的注册就是在系统广播发送的基础上，使用LocalBroadcastManager来对广播进行管理
 * 包括广播的发送和广播的接收
 */
public class LocalBroadcastActivity extends Activity {

    private Button button;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);

        //使用一个LocalBroadcastManager来对广播进行管理，得到它的实例
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        button = findViewById(R.id.sendlocal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.test.receiverlocal");

                //用LocalBroadcastManager发送广播
                localBroadcastManager.sendBroadcast(intent);

            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.test.receiverlocal");
        localReceiver = new LocalReceiver();

        //用LocalBroadcastManager来注册广播接收者
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);//注册本地广播监听器
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //用LocalBroadcastManager手动取消注册广播接收器
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("locallog","received local broadcast");
        }
    }

}
