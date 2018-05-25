package com.bqlab.themelab.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bqlab.themelab.R;

public class ContactActivity extends AppCompatActivity {

    Button contactFB;
    Button contactNB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getSupportActionBar().setTitle(R.string.contact_actionbar_title);
        getSupportActionBar().setHomeButtonEnabled(true);

        contactFB = (Button) findViewById(R.id.contact_btn_fb);
        contactNB = (Button) findViewById(R.id.contact_btn_nb);

        contactFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = getResources().getString(R.string.contact_btn_fb_url);
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
}
