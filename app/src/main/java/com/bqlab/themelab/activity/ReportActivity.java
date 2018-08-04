package com.bqlab.themelab.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bqlab.themelab.R;

public class ReportActivity extends AppCompatActivity {

    WebView reportWebview;
    WebSettings reportWebSettings;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        getSupportActionBar().setTitle(R.string.report_actionbar_title);
        getSupportActionBar().setHomeButtonEnabled(true);

        reportWebview = (WebView) findViewById(R.id.report_webview);
        reportWebview.setWebViewClient(new WebViewClient());

        reportWebSettings = reportWebview.getSettings();
        reportWebSettings.setJavaScriptEnabled(true);
        reportWebSettings.setSupportZoom(true);
        reportWebSettings.setLoadWithOverviewMode(true);
        reportWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        reportWebview.loadUrl(getResources().getString(R.string.report_url));
    }
}
