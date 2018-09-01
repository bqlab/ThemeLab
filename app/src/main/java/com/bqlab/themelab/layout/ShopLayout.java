package com.bqlab.themelab.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.bqlab.themelab.R;

public class ShopLayout extends FrameLayout {

    LinearLayout shopTopSearch;
    Button shopTopSort;
    Button shopCategoryStyle;
    Button shopCategoryGeneral;
    Button shopCategorySpecial;
    Button shopCategoryPremium;
    Button shopBodyTodayMore;
    Button shopBodyBoard;
    LinearLayout shopBodyList;

    public ShopLayout(Context context) {
        super(context);
        init(null, 0);
    }

    public ShopLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ShopLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        setLayoutInflation();

        shopBodyList = (LinearLayout) findViewById(R.id.shop_body_list);
    }

    private void setLayoutInflation() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_shop, this);
        this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }
}
