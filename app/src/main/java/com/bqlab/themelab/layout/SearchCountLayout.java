package com.bqlab.themelab.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bqlab.themelab.R;

public class SearchCountLayout extends LinearLayout {

    TextView textView;

    public SearchCountLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_search_count, this);
    }

    public void setView(int count) {
        textView = (TextView) findViewById(R.id.view_search_count);
        String text = "전체 " + count + "개의 테마가 검색되었습니다.";
        textView.setText(text);
    }
}