package com.example.test.broadcastreceiverdemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 动态注册接收网络实时状态
 */
public class ReceiveNetStateActivity extends Activity {

    private NetWorkChangeReceiver netWorkChangeReceiver;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_net_state);
        tv = findViewById(R.id.tv);

        IntentFilter intentFilter=new IntentFilter();

//        网络状态发生变化时，发出该广播
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
         netWorkChangeReceiver=new NetWorkChangeReceiver();

//        注册完广播onReceive()方法中才能收到广播
        registerReceiver(netWorkChangeReceiver, intentFilter);
    }

    class NetWorkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

            //这一步需要打开相应的权限    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
//                Toast.makeText(context, "network available", Toast.LENGTH_SHORT).show();
                tv.setText("available");
            } else {
//                Toast.makeText(context, "network unavailable", Toast.LENGTH_SHORT).show();
                tv.setText("unavailable");

            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        动态注册的广播必须手动取消注册
        unregisterReceiver(netWorkChangeReceiver);
    }
}
