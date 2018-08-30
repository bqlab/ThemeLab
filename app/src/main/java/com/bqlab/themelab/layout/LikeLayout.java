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
        init(null, 0);
    }

    public LikeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public LikeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        setLayoutInflation();
    }

    private void setLayoutInflation() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_like, this);
        this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }
}
