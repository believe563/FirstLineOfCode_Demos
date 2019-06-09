package com.example.test.datastoragedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 文件读取：demo1，保存数据到文件中，目录在data/data/<pacage name>/files下
 */
public class SaveDataToFilesActivity extends AppCompatActivity {

    private Button btsavetofile;
    private EditText etStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        将数据写到EditText中
        btsavetofile = findViewById(R.id.bt_savetofile);
        etStr = findViewById(R.id.et_str);
        btsavetofile.setOnClickListener(new View.OnClickListener() {
//            点击按钮时进行保存
            @Override
            public void onClick(View v) {
                String str1=etStr.getText().toString();
                save(str1);

            }
        });
    }

    public void save(String str1) {
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter = null;

//        openFileOutput()方法用于将数据存储到指定文件中
        try {
            //第一个参数是文件名，第二个参数表示覆盖原文件的内容，如果是Context.MODE_APPEND,就表示追加内容
            fileOutputStream = openFileOutput("data", Context.MODE_PRIVATE);

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(str1);
            Toast.makeText(SaveDataToFilesActivity.this, "succeed", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("abc");
            }

        }
    }
}
