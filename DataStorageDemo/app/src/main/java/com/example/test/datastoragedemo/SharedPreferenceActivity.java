package com.example.test.datastoragedemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * SharedPreference存储：Demo3
 * 用键值对的方式存储数据
 * 支持多种不同的数据类型存储
 */
public class SharedPreferenceActivity extends Activity {

    private Button savedata;
    private Button restoredata;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        savedata = findViewById(R.id.savedata);
        restoredata = findViewById(R.id.restore_data);
        login = findViewById(R.id.login);

        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              得到SharedPreferences类的方法对应书上的第一种方法
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Will");
                editor.putInt("age", 24);
                editor.putBoolean("married", false);
                editor.apply();
            }
        });

        restoredata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                String name = pref.getString("name", "zhangsan");
                int age = pref.getInt("age", 100);
                boolean married = pref.getBoolean("married", true);

                Log.d("SharedPreferenceActi", "name is:" + name);
                Log.d("SharedPreferenceActi", "age is:" + age);
                Log.d("SharedPreferenceActi", "is married:" + married);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedPreferenceActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
