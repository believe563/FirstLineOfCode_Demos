package com.example.test.uidemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * 测试include标签的功能的另一种巧妙实现
 */
public class TitleLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_layout);
        TitleLayout titleLayout = findViewById(R.id.titlelayout);

    }
}
