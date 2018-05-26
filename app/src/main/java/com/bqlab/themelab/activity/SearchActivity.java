package com.bqlab.themelab.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bqlab.themelab.R;
import com.bqlab.themelab.custom.NetworkDetector;
import com.bqlab.themelab.custom.ThemeManager;
import com.bqlab.themelab.layout.SearchCountView;
import com.bqlab.themelab.layout.ThemeNoneView;
import com.bqlab.themelab.layout.ThemeView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    NetworkDetector networkDetector = new NetworkDetector(this);

    ThemeManager themeManager;

    EditText searchTopInput;
    Button searchTopButton;
    LinearLayout searchBody;

    String searchWord;

    ArrayList<ThemeView> themes = new ArrayList<ThemeView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Initialization
        themeManager = new ThemeManager(this);

        searchTopInput = (EditText) findViewById(R.id.search_top_input);
        searchTopButton = (Button) findViewById(R.id.search_top_button);
        searchBody = (LinearLayout) findViewById(R.id.search_body);

        Intent intent = getIntent();
        searchWord = intent.getStringExtra("searchWord");

        //Preparing
        for (int i = 0; i < themeManager.getThemeCount(); i++) {
            themes.add((ThemeView) themeManager.getThemeView(i));
        }

        if (!networkDetector.isConnected()) {
            Toast.makeText(SearchActivity.this, "네트워크에 접속할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }

        //Displaying
        searchTopInput.setText(searchWord);
        searchByWord(searchWord);

        searchTopInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {
                if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                    searchWord = searchTopInput.getText().toString();
                    searchByWord(searchWord);
                }
                return false;
            }
        });
        searchTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchWord = searchTopInput.getText().toString();
                searchByWord(searchWord);
            }
        });
    }

    public void searchByWord(String searchWord) {
        searchBody.removeAllViewsInLayout();

        String[] words;
        ArrayList<ThemeView> results = new ArrayList<>();

        words = searchWord.split(" ");

        for (ThemeView theme : themes) {
            int accur = 0;
            for (String themeTag : theme.getTags()) {
                for (String word : words) {
                    if (word.equals(themeTag))
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
                    ThemeView temp;
                    temp = results.get(j);
                    results.set(j, results.get(j + 1));
                    results.set(j + 1, temp);
                }
            }
        }

        if (results.size() > 0) {
            SearchCountView searchCountView = new SearchCountView(this);
            searchCountView.setView(results.size());
            searchBody.addView(searchCountView);

            for (int i = 0; i < results.size(); i++) {
                searchBody.addView(results.get(i));
            }
        } else
            searchBody.addView(new ThemeNoneView(SearchActivity.this));
    }
}

