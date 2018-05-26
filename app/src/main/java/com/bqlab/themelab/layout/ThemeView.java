package com.bqlab.themelab.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bqlab.themelab.R;
import com.bqlab.themelab.activity.PreviewActivity;
import com.bqlab.themelab.custom.ApplicationDetector;

import java.util.ArrayList;
import java.util.List;

public class ThemeView extends LinearLayout {

    private int accur = 0;
    private boolean noto = false;

    private TextView themeTopName;
    private TextView themeTopText;
    private ImageView themeBody01;
    private ImageView themeBody02;
    private ImageView themeBody03;
    private ImageView themeBody04;
    private Button themeBottomPreview;
    private Button themeBottomDownload;
    private ArrayList<String> tags;

    public ThemeView(Context context) {
        super(context);
        init(null, 0);
    }

    public ThemeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ThemeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater.from(getContext()).inflate(R.layout.view_theme, this);

        themeTopName = (TextView) findViewById(R.id.theme_top_name);
        themeTopText = (TextView) findViewById(R.id.theme_top_text);

        themeBody01 = (ImageView) findViewById(R.id.theme_body_01);
        themeBody02 = (ImageView) findViewById(R.id.theme_body_02);
        themeBody03 = (ImageView) findViewById(R.id.theme_body_03);
        themeBody04 = (ImageView) findViewById(R.id.theme_body_04);

        themeBottomPreview = (Button) findViewById(R.id.theme_bottom_preview);
        themeBottomDownload = (Button) findViewById(R.id.theme_bottom_download);

        this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setThemeName(String themeName) {
        this.themeTopName.setText(themeName);
    }

    public void setThemeText(String themeText) {
        this.themeTopText.setText(themeText);
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setThemePreviewImage(int image1, int image2, int image3, int image4) {
        this.themeBody01.setBackground(getResources().getDrawable(image1));
        this.themeBody02.setBackground(getResources().getDrawable(image2));
        this.themeBody03.setBackground(getResources().getDrawable(image3));
        this.themeBody04.setBackground(getResources().getDrawable(image4));
    }

    public void setThemePreviewButton(final Context context, final ArrayList<Integer> imageIds) {
        themeBottomPreview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, PreviewActivity.class);
                i.putExtra("imageIds", imageIds);
                context.startActivity(i);
            }
        });
    }

    public void setThemeDownloadButton(final Context context, final String themeCode, final String url) {
        themeBottomDownload.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noto) {
                    AlertDialog.Builder a = new AlertDialog.Builder(context);
                    a.setMessage(getResources().getString(R.string.theme_download_noto));
                    a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            i.setPackage("com.google.android.apps.docs");
                            context.startActivity(i);
                        }
                    });
                    a.setNeutralButton(getResources().getString(R.string.theme_download_noto_detail), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.theme_download_noto_url))));
                        }
                    });
                    a.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    a.show();
                } else {
                    if (new ApplicationDetector(context).hasApplication("com.bqlab.themelab." + themeCode)) {
                        context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.bqlab.themelab." + themeCode));
                        Toast.makeText(context, "이미 테마가 설치되어 있습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1N-ZLON2onM1mvBIvjiD7UOLGl1USwyMp/view?usp=sharing"));
                        i.setPackage("com.google.android.apps.docs");
                        context.startActivity(i);
                        if (new ApplicationDetector(context).hasApplication("com.bqlab.themelab." + themeCode)) {
                            context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.bqlab.themelab." + themeCode));
                        }
                    }
                }
            }
        });
    }

    public void setAccuracy(int accur) {
        this.accur = accur;
    }

    public void setNoto(boolean noto) {
        this.noto = noto;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getAccuracy() {
        return accur;
    }
}