package com.bqlab.themelab.activity;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bqlab.themelab.R;
import com.bqlab.themelab.custom.ApplicationDetector;
import com.bqlab.themelab.custom.NetworkDetector;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureDetectorCompat;

    private boolean isClickedBackbutton = false;
    private static boolean isCheckedGoogleDrive = false;

    Button mainSearchButton;
    EditText mainSearchInput;

    RelativeLayout mainLayout;
    LinearLayout mainTutorial;
    LinearLayout mainRequest;

    InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkDetector networkDetector = new NetworkDetector(this);
        final ApplicationDetector applicationDetector = new ApplicationDetector(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, new SelectActivityGoer());
        inputMethodManager = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);

        mainSearchButton = (Button) findViewById(R.id.main_search_button);
        mainSearchInput = (EditText) findViewById(R.id.main_search_input);
        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        mainTutorial = (LinearLayout) findViewById(R.id.main_tutorial);
        mainRequest = (LinearLayout) findViewById(R.id.main_request);

        if (getSharedPreferences("settings", MODE_PRIVATE).getBoolean("TUTORIAL", true))
            mainTutorial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainTutorial.setVisibility(View.GONE);
                }
            });
        else
            mainTutorial.setVisibility(View.GONE);

        if (!isCheckedGoogleDrive && !applicationDetector.hasApplication("com.google.android.apps.docs")) {
            isCheckedGoogleDrive = true;
            startActivity(new Intent(this, StartActivity.class));
        }

        mainSearchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {
                if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                    if (!mainSearchInput.getText().toString().isEmpty()) {
                        Intent i = new Intent(MainActivity.this, SearchActivity.class);
                        i.putExtra("searchWord", mainSearchInput.getEditableText().toString());
                        mainSearchInput.setText("");
                        startActivity(i);
                    } else
                        Toast.makeText(MainActivity.this, "검색어를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        mainSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mainSearchInput.getText().toString().isEmpty()) {
                    Intent i = new Intent(MainActivity.this, SearchActivity.class);
                    i.putExtra("searchWord", mainSearchInput.getEditableText().toString());
                    mainSearchInput.setText("");
                    startActivity(i);
                } else
                    Toast.makeText(MainActivity.this, "검색어를 입력하세요.", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.main_request_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TutorialActivity.class));
            }
        });
        findViewById(R.id.main_request_02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactActivity.class));
            }
        });
        findViewById(R.id.main_request_03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EventActivity.class));
            }
        });
        findViewById(R.id.main_request_04).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.main_request_btn04_url)));
                if (applicationDetector.hasApplication("com.android.vending"))
                    i.setPackage("com.android.vending");
                startActivity(i);
            }
        });
        findViewById(R.id.main_request_05).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });
        findViewById(R.id.main_request_06).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (new ApplicationDetector(MainActivity.this).hasApplication("com.facebook.katana")) {
                    String url = getResources().getString(R.string.app_fb_homepage);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } else {
                    String url = getResources().getString(R.string.app_homepage);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }
            }
        });
        findViewById(R.id.main_request_07).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ReportActivity.class));
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
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

    private class SelectActivityGoer extends GestureDetector.SimpleOnGestureListener {
        public boolean onFling(MotionEvent e1, MotionEvent e2, float vx, float vy) {
            if (e1.getY() > e2.getY()) {
                startActivity(new Intent(MainActivity.this, SelectActivity.class));
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
            }
            return true;
        }
    }
}
