package com.bqlab.themelab.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.bqlab.themelab.R;

public class ThemeNoneLayout extends LinearLayout {

    public ThemeNoneLayout(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_theme_none, this);
    }
}