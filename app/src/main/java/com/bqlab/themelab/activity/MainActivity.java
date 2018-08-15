package com.bqlab.themelab.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bqlab.themelab.R;
import com.bqlab.themelab.custom.ApplicationDetector;
import com.bqlab.themelab.layout.AdLayout;
import com.bqlab.themelab.layout.MyLayout;
import com.bqlab.themelab.layout.NewsLayout;
import com.bqlab.themelab.layout.ThemesLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainBody;
    LinearLayout mainBarMy;
    LinearLayout mainBarThemes;
    LinearLayout mainBarNews;
    LinearLayout mainBarSetting;

    static MyLayout myLayout;
    static NewsLayout newsLayout;
    static ThemesLayout themesLayout;

    private void hasGoogleDrive() {
        if (!new ApplicationDetector(this).hasApplication("com.google.android.apps.docs")) {
            startActivity(new Intent(this, StartActivity.class));
        }
    }

    private void setMainBar() {
        mainBody = (LinearLayout) findViewById(R.id.main_body);
        mainBarMy = (LinearLayout) findViewById(R.id.main_bar_my);
        mainBarThemes = (LinearLayout) findViewById(R.id.main_bar_themes);
        mainBarNews = (LinearLayout) findViewById(R.id.main_bar_news);
        mainBarSetting = (LinearLayout) findViewById(R.id.main_bar_setting);

        myLayout = new MyLayout(this);
        newsLayout = new NewsLayout(this);
        themesLayout = new ThemesLayout(this);

        mainBarMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBody.removeAllViews();
                mainBody.addView(myLayout);
            }
        });
        mainBarThemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBody.removeAllViews();
                mainBody.addView(themesLayout);
            }
        });
        mainBarNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBody.removeAllViews();
                mainBody.addView(newsLayout);
            }
        });
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
        hasGoogleDrive();
        setMainBar();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("앱을 종료하시겠습니까?");
        b.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        b.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        b.setView(new AdLayout(this));
        b.show();
    }
}
