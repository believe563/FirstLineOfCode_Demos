package com.example.test.uidemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by believe563 on 20190109.
 *
 */
public class AlertDialogAndProgressDialogActivity extends Activity implements View.OnClickListener {

    private Button bt;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        bt = findViewById(R.id.showalertdialog);
        bt.setOnClickListener(this);
        bt1 = findViewById(R.id.showprogressdialog);
        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.showalertdialog) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogAndProgressDialogActivity.this);
            dialog.setTitle("this is dialog");
            dialog.setMessage("something important");
            dialog.setCancelable(false);
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
        }
        if (v.getId() == R.id.showprogressdialog){
            ProgressDialog pd = new ProgressDialog(AlertDialogAndProgressDialogActivity.this);
            pd.setTitle("this is progressdialog");
            pd.setMessage("loading");

            //如果传入的是false，需要用pd.dismiss()来关闭对话框
            pd.setCancelable(true);
            pd.show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
