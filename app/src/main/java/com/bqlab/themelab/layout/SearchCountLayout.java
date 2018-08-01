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
        init(null, 0);
    }

    public SearchCountLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public SearchCountLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_search_count, this);
        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }

    public void setView(int count) {
        textView = (TextView) findViewById(R.id.view_search_count);
        String text = "전체 " + count + "개의 테마가 검색되었습니다.";
        textView.setText(text);
    }
}