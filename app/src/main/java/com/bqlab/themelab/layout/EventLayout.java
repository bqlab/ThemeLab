package com.bqlab.themelab.layout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bqlab.themelab.R;
import com.bqlab.themelab.activity.NoticeActivity;

public class EventLayout extends LinearLayout {

    private String title;
    private String content;

    private Context context;
    private Button eventViewButton;

    public EventLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        LayoutInflater.from(getContext()).inflate(R.layout.layout_event, this);
        eventViewButton = (Button) findViewById(R.id.view_event_button);
        eventViewButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EventLayout.this.context, NoticeActivity.class);
                i.putExtra("title", EventLayout.this.title);
                i.putExtra("content", EventLayout.this.content);
                EventLayout.this.context.startActivity(i);
            }
        });
    }

    public void setTitle(String title) {
        this.title = title;
        eventViewButton.setText(title);
    }

    public void setContent(String content) {
        this.content = content;
    }
}