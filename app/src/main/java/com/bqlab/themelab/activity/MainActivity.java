package com.bqlab.themelab.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bqlab.themelab.R;
import com.bqlab.themelab.custom.ApplicationDetector;
import com.bqlab.themelab.layout.AdLayout;
import com.bqlab.themelab.layout.LikeLayout;
import com.bqlab.themelab.layout.NewsLayout;
import com.bqlab.themelab.layout.ShopLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainBody;
    LinearLayout mainBarMy;
    LinearLayout mainBarThemes;
    LinearLayout mainBarNews;
    LinearLayout mainBarSetting;

    static LikeLayout likeLayout;
    static NewsLayout newsLayout;
    static ShopLayout shopLayout;

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

        likeLayout = new LikeLayout(this);
        newsLayout = new NewsLayout(this);
        shopLayout = new ShopLayout(this);

        final TextView mainBarMyText = findViewById(R.id.main_bar_my_text);
        final TextView mainBarThemesText = findViewById(R.id.main_bar_themes_text);
        final TextView mainBarNewsText = findViewById(R.id.main_bar_news_text);

        mainBody.addView(likeLayout);
        mainBarMyText.setTextColor(getColor(R.color.colorYellow));
        mainBarMy.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_like_p));

        mainBarMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBody.removeAllViews();
                mainBody.addView(likeLayout);

                mainBarMy.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_like_p));
                mainBarThemes.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_shop));
                mainBarNews.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_news_np));

                mainBarMyText.setTextColor(getColor(R.color.colorYellow));
                mainBarThemesText.setTextColor(getColor(R.color.colorGrayBrighter));
                mainBarNewsText.setTextColor(getColor(R.color.colorGrayBrighter));
            }
        });
        mainBarThemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBody.removeAllViews();
                mainBody.addView(shopLayout);

                mainBarMy.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_like_np));
                mainBarThemes.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_shop_p));
                mainBarNews.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_news_np));

                mainBarMyText.setTextColor(getColor(R.color.colorGrayBrighter));
                mainBarThemesText.setTextColor(getColor(R.color.colorYellow));
                mainBarNewsText.setTextColor(getColor(R.color.colorGrayBrighter));
            }
        });
        mainBarNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBody.removeAllViews();
                mainBody.addView(newsLayout);

                mainBarMy.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_like_np));
                mainBarThemes.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_shop));
                mainBarNews.getChildAt(0).setBackground(getDrawable(R.drawable.main_bar_news_p));

                mainBarMyText.setTextColor(getColor(R.color.colorGrayBrighter));
                mainBarThemesText.setTextColor(getColor(R.color.colorGrayBrighter));
                mainBarNewsText.setTextColor(getColor(R.color.colorYellow));
            }
        });
        mainBarSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });
    }
}
