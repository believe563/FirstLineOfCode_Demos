package com.example.test.uidemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by believe563 on 2019/2/13.
 */
public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);

        Button bt_back = findViewById(R.id.bt_back);
        Button bt_exit = findViewById(R.id.bt_exit);
        bt_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"click back",Toast.LENGTH_SHORT).show();
            }
        });

        bt_exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"click exit",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
