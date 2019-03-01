package com.example.test.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by believe563 on 2019/2/21.
 * 发送标准广播的第一个Receiver
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //收到自定义广播时，会弹出提示
        //Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
        Log.e("loggg", "receivedinMyBroadcastReceiver");
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
