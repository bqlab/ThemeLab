package com.bqlab.themelab.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bqlab.themelab.R;
import com.bqlab.themelab.custom.ApplicationDetector;

import java.util.Objects;

public class ContactActivity extends AppCompatActivity {

    Button contactFB;
    Button contactIG;
    Button contactNB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setActionBar();
        init();
    }

    private void init() {
        contactFB = (Button) findViewById(R.id.contact_btn_fb);
        contactIG = (Button) findViewById(R.id.contact_btn_ig);
        contactNB = (Button) findViewById(R.id.contact_btn_nb);

        contactFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (new ApplicationDetector(ContactActivity.this).hasApplication("com.facebook.katana")) {
                    String url = getResources().getString(R.string.app_fb_homepage);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } else {
                    String url = getResources().getString(R.string.app_homepage);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }
            }
        });
        contactIG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = getResources().getString(R.string.contact_btn_ig_url);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
        contactNB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = getResources().getString(R.string.contact_btn_nb_url);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
    }

    private void setActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.contact_actionbar_title);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
