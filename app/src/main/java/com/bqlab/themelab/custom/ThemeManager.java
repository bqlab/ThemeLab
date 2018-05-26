package com.bqlab.themelab.custom;

import android.content.Context;
import android.view.View;

import com.bqlab.themelab.R;
import com.bqlab.themelab.layout.ThemeView;

import java.util.ArrayList;
import java.util.Arrays;

public class ThemeManager {

    private Context context;

    private ArrayList<ThemeView> themes = new ArrayList<ThemeView>();

    public ThemeManager(Context context) {

        this.context = context;

        ThemeView c0003 = new ThemeView(context);
        c0003.setThemeName("iTalk(수동설치)");
        c0003.setThemeText("아이폰 메시지 테마의 구버전입니다. 아이폰을 부러워하지 마시고 이 테마를 설치해보세요.");
        c0003.setThemeDownloadButton(context, "c0003", "https://drive.google.com/file/d/16iFC_87Guum-bFOL-ebZvCl3CdStLc7X/view?usp=sharing");
        c0003.setThemePreviewButton(context, new ArrayList<Integer>(Arrays.asList(R.drawable.c0003_image01, R.drawable.c0003_image02, R.drawable.c0003_image03, R.drawable.c0003_image04)));
        c0003.setThemePreviewImage(R.drawable.c0003_s_image01, R.drawable.c0003_s_image02, R.drawable.c0003_s_image03, R.drawable.c0003_s_image04);
        c0003.setTags(new ArrayList<String>(Arrays.asList("스타일테마", "애플", "아이폰", "아이메시지", "imessage", "심플", "iphone", "심플테마", "아이폰테마", "italk")));
        c0003.setNoto(true);
        themes.add(c0003);

        ThemeView c0002 = new ThemeView(context);
        c0002.setThemeName("페이스톡(수동설치)");
        c0002.setThemeText("페이스북 테마의 구버전입니다. 페이스북의 세련된 인터페이스와 디자인을 카카오톡에 담았습니다.");
        c0002.setThemeDownloadButton(context, "c0002", "https://drive.google.com/file/d/1LSySQGOkTrPFjgSwBFuVutbD8-g-liDG/view?usp=sharing");
        c0002.setThemePreviewButton(context, new ArrayList<Integer>(Arrays.asList(R.drawable.c0002_image01, R.drawable.c0002_image02, R.drawable.c0002_image03, R.drawable.c0002_image04)));
        c0002.setThemePreviewImage(R.drawable.c0002_s_image01, R.drawable.c0002_s_image02, R.drawable.c0002_s_image03, R.drawable.c0002_s_image04);
        c0002.setTags(new ArrayList<String>(Arrays.asList("스타일테마", "페이스톡", "페이스북", "페북", "facebook", "심플", "블루", "심플테마", "카톡테마", "페북테마")));
        c0002.setNoto(true);
        themes.add(c0002);

        ThemeView c0001 = new ThemeView(context);
        c0001.setThemeName("인스타톡(수동설치)");
        c0001.setThemeText("인스타그램 테마의 구버전입니다. 인스타그램의 그라데이션과 심플함을 카카오톡에서 느껴보세요.");
        c0001.setThemeDownloadButton(context, "c0001", "https://drive.google.com/file/d/1PvtHXtH5qq5JJL6K_4h9PWUFA2-x7cg-/view?usp=sharing");
        c0001.setThemePreviewButton(context, new ArrayList<Integer>(Arrays.asList(R.drawable.c0001_image01, R.drawable.c0001_image02, R.drawable.c0001_image03, R.drawable.c0001_image04)));
        c0001.setThemePreviewImage(R.drawable.c0001_s_image01, R.drawable.c0001_s_image02, R.drawable.c0001_s_image03, R.drawable.c0001_s_image04);
        c0001.setTags(new ArrayList<String>(Arrays.asList("스타일테마", "인스타톡", "인스타그램", "인스타", "인별", "instagram", "심플", "심플테마", "카톡테마", "인스타테마")));
        c0001.setNoto(true);
        themes.add(c0001);
    }

    public int getThemeCount() {
        return themes.size();
    }

    public View getThemeView(int position) {
        ThemeView themeView = new ThemeView(context);
        themeView = this.themes.get(position);
        return themeView;
    }
}
