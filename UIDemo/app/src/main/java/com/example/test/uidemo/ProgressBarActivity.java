package com.example.test.uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends Activity implements View.OnClickListener {

    private ProgressBar progressBar;
    private Button bthide;
    private Button btshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        progressBar = findViewById(R.id.progress_bar);
        bthide = findViewById(R.id.bt1);
        btshow = findViewById(R.id.bt2);
        bthide.setOnClickListener(this);
        btshow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                if (progressBar.getVisibility()==View.VISIBLE) {
                    progressBar.setVisibility(View.INVISIBLE);
//                    progressBar.setVisibility(View.GONE);
                    //INVISIBLE和GONE都可以，gone不占布局空间
                }
                break;
            case R.id.bt2:
                if (progressBar.getVisibility()==View.INVISIBLE) {
                    progressBar.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.VISIBLE);

                    int progress=progressBar.getProgress();
                    progress+=10;
                    progressBar.setProgress(progress);
                }
                break;
        }
    }
}
