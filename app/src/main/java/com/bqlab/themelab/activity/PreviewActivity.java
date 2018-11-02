package com.bqlab.themelab.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.bqlab.themelab.R;

import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity {

    ImageView previewImage;
    ArrayList<Integer> previewArray = new ArrayList<Integer>();

    private GestureDetectorCompat gestureDetectorCompat;

    protected int arrayIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class PreviewImageViewer extends GestureDetector.SimpleOnGestureListener {
        int arrayEdge = previewArray.size() - 1;

        public boolean onFling(MotionEvent e1, MotionEvent e2, float vx, float vy) {
            if (e1.getX() > e2.getX()) {
                if (arrayIndex < arrayEdge) {
                    arrayIndex += 1;
                } else {
                    arrayIndex = 0;
                }
                previewImage.setBackground(getResources().getDrawable(previewArray.get(arrayIndex)));
            } else {
                if (arrayIndex > 0) {
                    arrayIndex -= 1;
                } else {
                    arrayIndex = arrayEdge;
                }
                previewImage.setBackground(getResources().getDrawable(previewArray.get(arrayIndex)));
            }
            return true;
        }
    }

    private void init() {
        Intent intent = getIntent();
        previewArray = intent.getIntegerArrayListExtra("imageIds");

        gestureDetectorCompat = new GestureDetectorCompat(this, new PreviewImageViewer());

        previewImage = (ImageView) findViewById(R.id.preview_image);
        previewImage.setBackground(getResources().getDrawable(previewArray.get(arrayIndex)));
    }
}
