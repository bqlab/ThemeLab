package com.bqlab.themelab.layout;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bqlab.themelab.R;
import com.bqlab.themelab.custom.ThemeManager;

import java.util.ArrayList;

public class ShopLayout extends FrameLayout {

    Button shopTopSort;
    Button shopCategoryStyle;
    Button shopCategoryGeneral;
    Button shopCategorySpecial;
    Button shopCategoryPremium;
    Button shopBodyTodayMore;
    Button shopBodyBoard;
    LinearLayout shopBodyList;
    EditText shopTopSearch;
    ThemeManager themeManager;
    ArrayList<ThemeLayout> themes = new ArrayList<ThemeLayout>();

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

        themeManager = new ThemeManager(getContext());

        shopTopSearch = findViewById(R.id.shop_top_search);
        shopBodyList = findViewById(R.id.shop_body_list);

        shopTopSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {
                if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                    Intent i = new Intent(getContext(), SearchActivity.class);
                    i.putExtra("searchWord", shopTopSearch.getText().toString());
                    shopTopSearch.setText("");
                    getContext().startActivity(i);
                }
                return false;
            }
        });

        for (int i = 0; i < themeManager.getThemeCount(); i++) {
            themes.add(themeManager.getThemeLayout(i));
        }

        for (int i = 0; i < themes.size(); i++) {
            shopBodyList.addView(themes.get(i));
        }
    }

    private void setLayoutInflation() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_shop, this);
        this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }
}
