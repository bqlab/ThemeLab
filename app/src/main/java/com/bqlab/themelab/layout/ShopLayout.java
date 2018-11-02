package com.bqlab.themelab.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
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
    EditText shopTopSearch;

    Button shopCategoryTotal;
    Button shopCategoryGeneral;
    Button shopCategoryStyle;
    Button shopCategorySpecial;

    Button shopBodyTodayMore;
    Button shopBodyBoard;
    LinearLayout shopBody;
    LinearLayout shopBodyList;

    ThemeManager themeManager;
    ArrayList<ThemeLayout> themes = new ArrayList<ThemeLayout>();

    public ShopLayout(Context context) {
        super(context);
        init();
        setShopTopLayouts();
        setShopCategoryLayouts();
        showAllThemes();
    }

    private void init() {
        themes = new ThemeManager(getContext()).getThemes();
        LayoutInflater.from(getContext()).inflate(R.layout.layout_shop, this);

        shopTopSearch = findViewById(R.id.shop_top_search);

        shopCategoryTotal = findViewById(R.id.shop_category_total);
        shopCategoryGeneral = findViewById(R.id.shop_category_general);
        shopCategoryStyle = findViewById(R.id.shop_category_style);
        shopCategorySpecial = findViewById(R.id.shop_category_special);

        shopBody = findViewById(R.id.shop_body);
        shopBodyTodayMore = findViewById(R.id.shop_body_today_more);
        shopBodyBoard = findViewById(R.id.shop_body_board);
        shopBodyList = findViewById(R.id.shop_body_list);
    }

    private void setShopTopLayouts() {
        shopTopSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {
                if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                    String s = shopTopSearch.getText().toString();
                    if (s.equals(""))
                        return false;
                    searchByWords(s);
                }
                return false;
            }
        });
    }

    private void setShopCategoryLayouts() {
        shopCategoryTotal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                shopBodyList.removeAllViews();

                shopCategoryTotal.setBackground(getResources().getDrawable(R.drawable.shop_category_start_p));
                shopCategoryGeneral.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategoryStyle.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategorySpecial.setBackground(getResources().getDrawable(R.drawable.shop_category_end_np));

                shopCategoryTotal.setTextColor(getResources().getColor(R.color.colorWhiteDark));
                shopCategoryGeneral.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryStyle.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategorySpecial.setTextColor(getResources().getColor(R.color.colorGrayBright));

                showAllThemes();
            }
        });
        shopCategoryGeneral.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                shopBodyList.removeAllViews();

                shopCategoryTotal.setBackground(getResources().getDrawable(R.drawable.shop_category_start_np));
                shopCategoryGeneral.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_p));
                shopCategoryStyle.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategorySpecial.setBackground(getResources().getDrawable(R.drawable.shop_category_end_np));

                shopCategoryTotal.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryGeneral.setTextColor(getResources().getColor(R.color.colorWhiteDark));
                shopCategoryStyle.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategorySpecial.setTextColor(getResources().getColor(R.color.colorGrayBright));

                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains("일반테마")) {
                        shopBodyList.addView(themes.get(i));
                    }
                }
                if (shopBodyList.getChildCount() == 0) {
                    AlertDialog.Builder b = new AlertDialog.Builder(getContext());
                    b.setMessage(getResources().getString(R.string.app_no_data));
                    b.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            showAllThemes();
                        }
                    });
                    b.show();
                }
            }
        });
        shopCategoryStyle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                shopBodyList.removeAllViews();

                shopCategoryTotal.setBackground(getResources().getDrawable(R.drawable.shop_category_start_np));
                shopCategoryGeneral.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategoryStyle.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_p));
                shopCategorySpecial.setBackground(getResources().getDrawable(R.drawable.shop_category_end_np));

                shopCategoryTotal.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryGeneral.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryStyle.setTextColor(getResources().getColor(R.color.colorWhiteDark));
                shopCategorySpecial.setTextColor(getResources().getColor(R.color.colorGrayBright));

                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains("스타일테마")) {
                        shopBodyList.addView(themes.get(i));
                    }
                }
                if (shopBodyList.getChildCount() == 0) {
                    AlertDialog.Builder b = new AlertDialog.Builder(getContext());
                    b.setMessage(getResources().getString(R.string.app_no_data));
                    b.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            showAllThemes();
                        }
                    });
                    b.show();
                }
            }
        });
        shopCategorySpecial.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                shopBodyList.removeAllViews();

                shopCategoryTotal.setBackground(getResources().getDrawable(R.drawable.shop_category_start_np));
                shopCategoryGeneral.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategoryStyle.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategorySpecial.setBackground(getResources().getDrawable(R.drawable.shop_category_end_p));

                shopCategoryTotal.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryGeneral.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryStyle.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategorySpecial.setTextColor(getResources().getColor(R.color.colorWhiteDark));

                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains("스페셜테마")) {
                        shopBodyList.addView(themes.get(i));
                    }
                }
                if (shopBodyList.getChildCount() == 0) {
                    AlertDialog.Builder b = new AlertDialog.Builder(getContext());
                    b.setMessage(getResources().getString(R.string.app_no_data));
                    b.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            showAllThemes();
                        }
                    });
                    b.show();
                }
            }
        });
    }

    private void showAllThemes() {
        shopBodyList.removeAllViews();
        for (int i = 0; i < themes.size(); i++) {
            shopBodyList.addView(themes.get(i));
        }
    }

    public void searchByWords(String searchWord) {
        ArrayList<ThemeLayout> results = new ArrayList<>();
        String[] words = searchWord.split(" ");

        for (ThemeLayout theme : themes) {
            int accur = 0;
            for (String themeTag : theme.getTags()) {
                for (String word : words) {
                    if (word.equalsIgnoreCase(themeTag))
                        accur++;
                }
            }
            theme.setAccuracy(accur);
            if (theme.getAccuracy() > 0)
                results.add(theme);
        }

        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (results.get(j).getAccuracy() < results.get(j + 1).getAccuracy()) {
                    ThemeLayout temp;
                    temp = results.get(j);
                    results.set(j, results.get(j + 1));
                    results.set(j + 1, temp);
                }
            }
        }

        if (results.size() > 0) {
            SearchCountLayout searchCountView = new SearchCountLayout(getContext());
            searchCountView.setView(results.size());
            shopBodyList.addView(searchCountView);

            for (int i = 0; i < results.size(); i++) {
                shopBodyList.addView(results.get(i));
            }
        } else {
            shopBodyList.removeAllViews();
            shopBodyList.addView(new ThemeNoneLayout(getContext()));
        }
    }
}
