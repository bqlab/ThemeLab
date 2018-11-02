package com.bqlab.themelab.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.bqlab.themelab.R;

public class LikeLayout extends FrameLayout {

    public LikeLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_like, this);
    }
}
