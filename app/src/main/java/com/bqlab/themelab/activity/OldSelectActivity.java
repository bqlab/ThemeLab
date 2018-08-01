package com.bqlab.themelab.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bqlab.themelab.R;
import com.bqlab.themelab.custom.ApplicationDetector;
import com.bqlab.themelab.custom.NetworkDetector;
import com.bqlab.themelab.custom.ThemeManager;
import com.bqlab.themelab.layout.ThemeNoneLayout;
import com.bqlab.themelab.layout.ThemeLayout;

import java.util.ArrayList;

public class OldSelectActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureDetectorCompat;
    private boolean isClickedBackbutton = false;
    private String clickedButton;

    Button selectTopBoardButton;
    Button selectTopButton01;
    Button selectTopButton02;
    Button selectTopButton03;
    Button selectTopButton04;
    Button selectTopButton05;
    Button selectTopButton06;

    LinearLayout selectBody;
    LinearLayout selectBottom;

    ThemeManager themeManager;

    ArrayList<ThemeLayout> themes = new ArrayList<ThemeLayout>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_select);

        getSharedPreferences("settings", MODE_PRIVATE).edit().putBoolean("TUTORIAL", false).apply();

        gestureDetectorCompat = new GestureDetectorCompat(this, new MainActivityGoer());
        themeManager = new ThemeManager(this);

        selectTopBoardButton = (Button) findViewById(R.id.select_top_board_button);
        selectTopButton01 = (Button) findViewById(R.id.select_top_btn01);
        selectTopButton02 = (Button) findViewById(R.id.select_top_btn02);
        selectTopButton03 = (Button) findViewById(R.id.select_top_btn03);
        selectTopButton04 = (Button) findViewById(R.id.select_top_btn04);
        selectTopButton05 = (Button) findViewById(R.id.select_top_btn05);
        selectTopButton06 = (Button) findViewById(R.id.select_top_btn06);

        selectBody = (LinearLayout) findViewById(R.id.select_body);
        selectBottom = (LinearLayout) findViewById(R.id.select_bottom);

        for (int i = 0; i < themeManager.getThemeCount(); i++) {
            themes.add((ThemeLayout) themeManager.getThemeView(i));
        }

        NetworkDetector networkDetector = new NetworkDetector(this);
        if (!networkDetector.isConnected()) {
            Toast.makeText(OldSelectActivity.this, "네트워크에 접속할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        setTopButtons();

        for (int i = 0; i < themes.size(); i++) {
            selectBody.addView(themes.get(i));
        }

        selectBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (new ApplicationDetector(OldSelectActivity.this).hasApplication("com.facebook.katana")) {
                    String url = getResources().getString(R.string.app_fb_homepage);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } else {
                    String url = getResources().getString(R.string.app_homepage);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(OldSelectActivity.this, OldMainActivity.class));
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void setTopButtons() {
        selectTopBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OldSelectActivity.this, ContactActivity.class));
            }
        });

        selectTopButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectBody.removeAllViewsInLayout();
                selectTopButton01.setBackground(getResources().getDrawable(R.color.colorYellow));
                selectTopButton02.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton03.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton04.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton05.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton06.setBackground(getResources().getDrawable(R.color.colorWhite));
                clickedButton = "스타일테마";
                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains(clickedButton)) {
                        selectBody.addView(themes.get(i));
                    }
                }
                if (selectBody.getChildCount() == 0)
                    selectBody.addView(new ThemeNoneLayout(OldSelectActivity.this));
            }
        });

        selectTopButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectBody.removeAllViewsInLayout();
                selectTopButton01.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton02.setBackground(getResources().getDrawable(R.color.colorYellow));
                selectTopButton03.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton04.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton05.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton06.setBackground(getResources().getDrawable(R.color.colorWhite));
                clickedButton = "일반테마";
                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains(clickedButton)) {
                        selectBody.addView(themes.get(i));
                    }
                }
                if (selectBody.getChildCount() == 0)
                    selectBody.addView(new ThemeNoneLayout(OldSelectActivity.this));
            }
        });

        selectTopButton03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectBody.removeAllViewsInLayout();
                selectTopButton01.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton02.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton03.setBackground(getResources().getDrawable(R.color.colorYellow));
                selectTopButton04.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton05.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton06.setBackground(getResources().getDrawable(R.color.colorWhite));
                clickedButton = "커스텀테마";
                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains(clickedButton)) {
                        selectBody.addView(themes.get(i));
                    }
                }
                if (selectBody.getChildCount() == 0)
                    selectBody.addView(new ThemeNoneLayout(OldSelectActivity.this));
            }
        });

        selectTopButton04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectBody.removeAllViewsInLayout();
                selectTopButton01.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton02.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton03.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton04.setBackground(getResources().getDrawable(R.color.colorYellow));
                selectTopButton05.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton06.setBackground(getResources().getDrawable(R.color.colorWhite));
                clickedButton = "창작터테마";
                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains(clickedButton)) {
                        selectBody.addView(themes.get(i));
                    }
                }
                if (selectBody.getChildCount() == 0)
                    selectBody.addView(new ThemeNoneLayout(OldSelectActivity.this));
            }
        });

        selectTopButton05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectBody.removeAllViewsInLayout();
                selectTopButton01.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton02.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton03.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton04.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton05.setBackground(getResources().getDrawable(R.color.colorYellow));
                selectTopButton06.setBackground(getResources().getDrawable(R.color.colorWhite));
                clickedButton = "스페셜테마";
                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains(clickedButton)) {
                        selectBody.addView(themes.get(i));
                    }
                }
                if (selectBody.getChildCount() == 0)
                    selectBody.addView(new ThemeNoneLayout(OldSelectActivity.this));
            }
        });

        selectTopButton06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectBody.removeAllViewsInLayout();
                selectTopButton01.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton02.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton03.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton04.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton05.setBackground(getResources().getDrawable(R.color.colorWhite));
                selectTopButton06.setBackground(getResources().getDrawable(R.color.colorYellow));
                clickedButton = "프리미엄테마";
                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains(clickedButton)) {
                        selectBody.addView(themes.get(i));
                    }
                }
                if (selectBody.getChildCount() == 0)
                    selectBody.addView(new ThemeNoneLayout(OldSelectActivity.this));
            }
        });
    }

    private class MainActivityGoer extends GestureDetector.SimpleOnGestureListener {
        public boolean onFling(MotionEvent e1, MotionEvent e2, float vx, float vy) {
            if (e1.getY() < e2.getY()) {
                startActivity(new Intent(OldSelectActivity.this, OldMainActivity.class));
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
            }
            return true;
        }
    }
}

