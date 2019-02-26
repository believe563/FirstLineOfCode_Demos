package com.example.test.dynamicallyloadlayout;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.bt);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                //创建待添加的碎片实例                transaction.addToBackStack(null);
                AnotherRightFragment fragment = new AnotherRightFragment();
//                获取到FragmentManager，在活动中调用getFragmentManager得到
                FragmentManager fragmentManager = getFragmentManager();
                //开启一个事务
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                //向容器中加入碎片
                transaction.replace(R.id.right_layout, fragment);
                //将fragment加入回退栈
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            default:
                break;
        }
    }
}

