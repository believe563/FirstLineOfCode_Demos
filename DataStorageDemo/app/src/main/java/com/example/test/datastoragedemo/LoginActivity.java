package com.example.test.datastoragedemo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * SharedPreferenceActivity的Login按钮
 */
public class LoginActivity extends AppCompatActivity {
    private EditText userid;
    private EditText pwd;
    private Button loginnow;
    private CheckBox chkbox;

    private String idremembered;
    private String pwdremembered;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        pref = PreferenceManager.getDefaultSharedPreferences(this);

//      查看本地有没有记录账号和密码

        boolean isremembered = pref.getBoolean("remembered", false);
        if (isremembered) {
            idremembered = pref.getString("id", "");
            pwdremembered = pref.getString("pwd", "");
            userid.setText(idremembered);
            pwd.setText(pwdremembered);
            chkbox.setChecked(true);
        }


//      点击登录时
        loginnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userid.getText().toString().equals("123456") && pwd.getText().toString().equals("123456")) {
                    editor = pref.edit();
                    if (chkbox.isChecked()) {

                        editor.putBoolean("remembered", true);
                        editor.putString("id", userid.getText().toString());
                        editor.putString("pwd", pwd.getText().toString());


                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "login succeed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void initView() {
        userid = findViewById(R.id.user_id);
        pwd = findViewById(R.id.pwd);
        loginnow = findViewById(R.id.loginnow);
        chkbox = findViewById(R.id.chkbox);
    }
}
