package com.bqlab.themelab.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bqlab.themelab.R;

public class TutorialActivity extends AppCompatActivity {

    WebView tutorialWebview;
    WebSettings tutorialWebSettings;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        getSupportActionBar().setTitle(R.string.tutorial_actionbar_title);
        getSupportActionBar().setHomeButtonEnabled(true);

        tutorialWebview = (WebView) findViewById(R.id.tutorial_webview);
        tutorialWebview.setWebViewClient(new WebViewClient());

        tutorialWebSettings = tutorialWebview.getSettings();
        tutorialWebSettings.setJavaScriptEnabled(true);
        tutorialWebSettings.setSupportZoom(true);
        tutorialWebSettings.setLoadWithOverviewMode(true);
        tutorialWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        tutorialWebview.loadUrl(getResources().getString(R.string.main_request_btn01_url));
    }
}
