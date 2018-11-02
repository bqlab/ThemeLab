package com.bqlab.themelab.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bqlab.themelab.R;

public class NoticeActivity extends AppCompatActivity {

    TextView noticeBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        init();
    }

    private void init() {
        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setHomeButtonEnabled(true);

        noticeBody = (TextView) findViewById(R.id.notice_body);
        noticeBody.setText(content);
    }
}
