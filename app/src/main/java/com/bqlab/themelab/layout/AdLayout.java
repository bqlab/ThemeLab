package com.bqlab.themelab.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.bqlab.themelab.R;

public class AdLayout extends LinearLayout {

    public AdLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_ad, this);
    }
}