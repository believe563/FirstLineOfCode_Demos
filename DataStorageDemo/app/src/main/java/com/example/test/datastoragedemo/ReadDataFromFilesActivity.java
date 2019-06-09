package com.example.test.datastoragedemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 文件读取-Demo2：取数据
 * 读取目录为data/data/<package name>/files中名字为"data"文件中的字符
 */
public class ReadDataFromFilesActivity extends Activity {
    private EditText etRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data_from_files);
        etRead = findViewById(R.id.et_read);

//      所读取的字符串
        String loadText=load();

//        TextUtils.isEmpty()可以一次性进行判null和判空字符串两种空值
        if (!TextUtils.isEmpty(loadText)) {
            etRead.setText(loadText);

//          将光标移动到文本末尾以便继续输入
            etRead.setSelection(loadText.length());
            Toast.makeText(this, "read succeed", Toast.LENGTH_SHORT).show();
        }
    }

    public String load() {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileInputStream = openFileInput("data");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String lineStr = "";
            while ((lineStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}
