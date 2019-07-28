package com.example.test.contentproviderdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Demo RuntimePermissionActivity
 * 运行时权限，在Android 6.0及以上需要对危险权限进行权限处理，用户可以在安装应用时对权限进行手动处理
 * 运行时权限的构建过程：
 * 1.在AndroidManifest文件中先声明权限（只做这一步在6.0及以上版本中没有效果）
 * 2.
 *
 * @author belie
 * @date 2019/07/27
 */
public class RuntimePermissionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMakeCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permission);

        initView();
        initClick();
    }

    private void initClick() {
        btnMakeCall.setOnClickListener(this);
    }

    private void initView() {
        btnMakeCall = findViewById(R.id.bt_makecall);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_makecall:

                //添加运行时权限
                // a.先判断用户是否已给授权
                if (ContextCompat.checkSelfPermission(RuntimePermissionActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // 没授权时要调用下面的方法来向用户申请授权
                    ActivityCompat.requestPermissions(RuntimePermissionActivity.this, new
                            String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    call();
                }
                break;
            default:
                break;
        }
    }

    /**
    * 打电话的逻辑
    */
    private void call() {
        try {
            // 构建隐式Intent，其action定义为Intent.ACTION_CALL
            //该action可以直接拨打电话，所以必须声明权限
            Intent intent = new Intent(Intent.ACTION_CALL);

            // 在data部分指定协议是tel，号码是10086
            intent.setData(Uri.parse("tel:10086"));
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     *回调函数，系统弹出对话框信息，用户同意或拒绝授权后，信息会回调到该方法中
     * @param grantResults 授权结果封装在该变量中
     * @param permissions 数组 要申请的权限名
      */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull
            int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
