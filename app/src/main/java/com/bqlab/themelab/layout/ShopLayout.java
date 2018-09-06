package com.bqlab.themelab.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bqlab.themelab.R;
import com.bqlab.themelab.activity.OldSearchActivity;
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
        setMembers();
        setShopTopLayouts();
        setShopCategoryLayouts();
        showAllThemes();
    }

    private void setLayoutInflation() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_shop, this);
        this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    private void setMembers() {
        themes = new ThemeManager(getContext()).getThemes();
        shopTopSearch = findViewById(R.id.shop_top_search);
        shopCategoryStyle = findViewById(R.id.shop_category_style);
        shopCategoryGeneral = findViewById(R.id.shop_category_general);
        shopCategorySpecial = findViewById(R.id.shop_category_special);
        shopCategoryPremium = findViewById(R.id.shop_category_premium);
        shopBodyList = findViewById(R.id.shop_body_list);
    }

    private void setShopTopLayouts() {
        shopTopSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {
                if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                    shopBodyList.removeAllViews();
                    searchByWords(shopTopSearch.getText().toString());
                }
                return false;
            }
        });
    }

    private void setShopCategoryLayouts() {
        shopCategoryStyle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                shopBodyList.removeAllViews();

                shopCategoryStyle.setBackground(getResources().getDrawable(R.drawable.shop_category_start_p));
                shopCategoryGeneral.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategorySpecial.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategoryPremium.setBackground(getResources().getDrawable(R.drawable.shop_category_end_np));

                shopCategoryStyle.setTextColor(getResources().getColor(R.color.colorWhite));
                shopCategoryGeneral.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategorySpecial.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryPremium.setTextColor(getResources().getColor(R.color.colorGrayBright));

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
        shopCategoryGeneral.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                shopBodyList.removeAllViews();

                shopCategoryStyle.setBackground(getResources().getDrawable(R.drawable.shop_category_start_np));
                shopCategoryGeneral.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_p));
                shopCategorySpecial.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategoryPremium.setBackground(getResources().getDrawable(R.drawable.shop_category_end_np));

                shopCategoryStyle.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryGeneral.setTextColor(getResources().getColor(R.color.colorWhite));
                shopCategorySpecial.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryPremium.setTextColor(getResources().getColor(R.color.colorGrayBright));

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
        shopCategorySpecial.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                shopBodyList.removeAllViews();

                shopCategoryStyle.setBackground(getResources().getDrawable(R.drawable.shop_category_start_np));
                shopCategoryGeneral.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategorySpecial.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_p));
                shopCategoryPremium.setBackground(getResources().getDrawable(R.drawable.shop_category_end_np));

                shopCategoryStyle.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryGeneral.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategorySpecial.setTextColor(getResources().getColor(R.color.colorWhite));
                shopCategoryPremium.setTextColor(getResources().getColor(R.color.colorGrayBright));

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
        shopCategoryPremium.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                shopBodyList.removeAllViews();

                shopCategoryStyle.setBackground(getResources().getDrawable(R.drawable.shop_category_start_np));
                shopCategoryGeneral.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategorySpecial.setBackground(getResources().getDrawable(R.drawable.shop_category_mid_np));
                shopCategoryPremium.setBackground(getResources().getDrawable(R.drawable.shop_category_end_p));

                shopCategoryStyle.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryGeneral.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategorySpecial.setTextColor(getResources().getColor(R.color.colorGrayBright));
                shopCategoryPremium.setTextColor(getResources().getColor(R.color.colorWhite));

                for (int i = 0; i < themes.size(); i++) {
                    if (themes.get(i).getTags().contains("프리미엄테마")) {
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
            AlertDialog.Builder b = new AlertDialog.Builder(getContext());
            b.setTitle("검색된 결과가 없습니다.");
            b.setMessage(getResources().getString(R.string.shop_no_result));
            b.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    showAllThemes();
                }
            });
            b.show();
        }
    }
}
