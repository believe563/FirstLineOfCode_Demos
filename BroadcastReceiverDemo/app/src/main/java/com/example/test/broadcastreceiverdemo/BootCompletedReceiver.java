package com.example.test.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 静态广播-开机自启动
 * 需要在AndroidManifest.xml中注册
 * <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>权限
 * 在<action></action>标签中添加相应的action：android.intent.action.BOOT_COMPLETED
 */
public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //Toast.makeText(context, "boot", Toast.LENGTH_SHORT).show();
        Log.e("autoboot", "1111111111111111111112222222222222222222222222");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
