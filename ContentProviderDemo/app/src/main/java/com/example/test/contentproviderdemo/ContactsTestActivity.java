package com.example.test.contentproviderdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * class ContactsTestActivity Demo
 * 读取联系人：访问其它应用程序的内容
 *
 * @author belie
 * @date 2019/07/28
 */
public class ContactsTestActivity extends AppCompatActivity {

    private ListView contactsView;
    ArrayAdapter<String> adapter;
    List<String> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化listview、适配器、为listview装载适配器
        initView();
        initAdapter();
        contactsView.setAdapter(adapter);

        // 获取运行时权限，如果未获取，则发起对话框，用户选择是否授权；如果已获取，则读取联系人
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.
                    READ_CONTACTS}, 1);
        } else {
            readContacts();
        }
    }

    /**
     * 弹出对话框，用户选择是否授权后
     * 该函数是用户操作后的回调函数，在获取权限成功和失败时进行相应操作
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // 用户成功授权
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                readContacts();
            } else {// 用户拒绝授权
                Toast.makeText(this, "You denied the permission",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                contactsList);
    }

    /**
     * 初始化listview
     */
    private void initView() {
        contactsView = findViewById(R.id.contacts_view);

    }

    /**
     * 读取联系人的具体逻辑
     */
    private void readContacts() {
        Cursor cursor = null;
        try {
            /**
             * 查询联系人
             * 第一个参数是一个内容URI常量
             */
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, null, null, null);

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    // 使用内容URI常量取出对应的字符串
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.
                            CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.
                            CommonDataKinds.Phone.NUMBER));
                    // 将联系人的姓名和号码放到list中，方便展示
                    contactsList.add(name + "\n" + number);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }




}
