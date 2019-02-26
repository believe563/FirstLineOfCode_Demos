package com.example.test.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean twoPane=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.bt);
        bt.setOnClickListener(this);
//        if(findViewById(R.id.right_layout)!=null) {
//            replaceFragment(new AnotherRightFragment());
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:


                //创建待添加的碎片实例                transaction.addToBackStack(null);
                if(findViewById(R.id.right_layout)!=null) {
                    AnotherRightFragment fragment = new AnotherRightFragment();
                    replaceFragment(fragment);
                }

                break;
            default:
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        //动态添加碎片
        //                获取到FragmentManager，在活动中调用getFragmentManager得到
        FragmentManager fragmentManager=getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //向容器中加入碎片
        transaction.replace(R.id.right_layout, fragment);
        //将fragment加入回退栈
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
