package com.bqlab.themelab.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bqlab.themelab.R;
import com.bqlab.themelab.custom.ApplicationDetector;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainBarMy;
    LinearLayout mainBarThemes;
    LinearLayout mainBarNews;
    LinearLayout mainBarSetting;

    boolean isClickedBackbutton = false;

    private void isHasGoogleDrive() {
        if (!new ApplicationDetector(this).hasApplication("com.google.android.apps.docs")) {
            startActivity(new Intent(this, StartActivity.class));
        }
    }

    private void setMainBar() {
        mainBarMy = (LinearLayout) findViewById(R.id.main_bar_my);
        mainBarThemes = (LinearLayout) findViewById(R.id.main_bar_themes);
        mainBarNews= (LinearLayout) findViewById(R.id.main_bar_news);
        mainBarSetting = (LinearLayout) findViewById(R.id.main_bar_setting);

        mainBarSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isHasGoogleDrive();

        setMainBar();
    }

    @Override
    public void onBackPressed() {
        if (!isClickedBackbutton) {
            Toast.makeText(this, "한번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
            isClickedBackbutton = true;
        } else {
            super.onBackPressed();
            ActivityCompat.finishAffinity(this);
        }
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {

            }

            public void onFinish() {
                isClickedBackbutton = false;
            }
        }.start();
    }
}
