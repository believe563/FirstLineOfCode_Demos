package com.example.test.broadcastreceiverdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 发送系统标准广播的唯一一个Activity
 */
public class SendStandardBroadcastActivity extends AppCompatActivity {

    private Button bt_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_send = findViewById(R.id.btsend);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.broadcasttest.MY_BROADCAST");
//                Intent intent=new Intent();
//                这种可以
                ComponentName componentName = new ComponentName(SendStandardBroadcastActivity.this,"com.example.test.broadcastreceiverdemo.MyBroadcastReceiver");
                intent.setComponent(componentName);

//                这种也可以,第一个字符串得是应用包名
//                intent.setComponent(new ComponentName("com.example.test.broadcastreceiverdemo","com.example.test.broadcastreceiverdemo.MyBroadcastReceiver"));
                sendOrderedBroadcast(intent,"com.example.test.receiver");

            }
        });
    }
}
