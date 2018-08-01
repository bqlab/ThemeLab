package com.bqlab.themelab.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.bqlab.themelab.R;
import com.bqlab.themelab.layout.EventLayout;

public class EventActivity extends AppCompatActivity {

    LinearLayout eventBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        getSupportActionBar().setTitle(R.string.event_actionbar_title);
        getSupportActionBar().setHomeButtonEnabled(true);

        eventBody = (LinearLayout) findViewById(R.id.event_body);

        EventLayout n0001 = new EventLayout(this);
        n0001.setTitle(getResources().getString(R.string.notice_n0001_title));
        n0001.setContent(getResources().getString(R.string.notice_n0001_content));
        eventBody.addView(n0001);

        EventLayout n0002 = new EventLayout(this);
        n0002.setTitle(getResources().getString(R.string.notice_n0002_title));
        n0002.setContent(getResources().getString(R.string.notice_n0002_content));
        eventBody.addView(n0002);

        EventLayout n0003 = new EventLayout(this);
        n0003.setTitle(getResources().getString(R.string.notice_n0003_title));
        n0003.setContent(getResources().getString(R.string.notice_n0003_content));
        eventBody.addView(n0003);

        EventLayout n0004 = new EventLayout(this);
        n0004.setTitle(getResources().getString(R.string.notice_n0004_title));
        n0004.setContent(getResources().getString(R.string.notice_n0004_content));
        eventBody.addView(n0004);

        EventLayout n0005 = new EventLayout(this);
        n0005.setTitle(getResources().getString(R.string.notice_n0005_title));
        n0005.setContent(getResources().getString(R.string.notice_n0005_content));
        eventBody.addView(n0005);

        EventLayout n0006 = new EventLayout(this);
        n0006.setTitle(getResources().getString(R.string.notice_n0006_title));
        n0006.setContent(getResources().getString(R.string.notice_n0006_content));
        eventBody.addView(n0006);

        EventLayout n0007 = new EventLayout(this);
        n0007.setTitle(getResources().getString(R.string.notice_n0007_title));
        n0007.setContent(getResources().getString(R.string.notice_n0007_content));
        eventBody.addView(n0007);

        EventLayout n0008 = new EventLayout(this);
        n0008.setTitle(getResources().getString(R.string.notice_n0008_title));
        n0008.setContent(getResources().getString(R.string.notice_n0008_content));
        eventBody.addView(n0008);
    }

}
