package com.bqlab.themelab.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.bqlab.themelab.R;
import com.bqlab.themelab.view.EventView;

public class EventActivity extends AppCompatActivity {

    LinearLayout eventBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        getSupportActionBar().setTitle(R.string.event_actionbar_title);
        getSupportActionBar().setHomeButtonEnabled(true);

        eventBody = (LinearLayout) findViewById(R.id.event_body);

        EventView n0001 = new EventView(this);
        n0001.setTitle(getResources().getString(R.string.notice_n0001_title));
        n0001.setContent(getResources().getString(R.string.notice_n0001_content));
        eventBody.addView(n0001);

        EventView n0002 = new EventView(this);
        n0002.setTitle(getResources().getString(R.string.notice_n0002_title));
        n0002.setContent(getResources().getString(R.string.notice_n0002_content));
        eventBody.addView(n0002);
    }

}
