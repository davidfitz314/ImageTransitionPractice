package com.example.imagetransitionpractice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private View mTitleTextView;
    private boolean mTitleVisible = true;
    private Button mShowHideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitleTextView = findViewById(R.id.title_textview);
        mShowHideButton = findViewById(R.id.show_title_button);
    }

    public void goToHomeMenu(View view) {
        Intent goToHomeMenuIntent = new Intent(this, SecondScreen.class);
        startActivity(goToHomeMenuIntent);
    }

    public void showTitle(View view) {
        int cx = mTitleTextView.getWidth() / 2;
        int cy = mTitleTextView.getHeight() / 2;
        float finalRadius = (float) Math.hypot(cx, cy);

        if (!mTitleVisible) {
            Animator anim = ViewAnimationUtils.createCircularReveal(mTitleTextView, cx, cy, 0, finalRadius);
            mTitleTextView.setVisibility(View.VISIBLE);
            anim.start();
            mTitleVisible = true;
            mShowHideButton.setText(R.string.hide_description);
            return;
        } else {
            Animator anim = ViewAnimationUtils.createCircularReveal(mTitleTextView, cx, cy, finalRadius, 0);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation, boolean isReverse) {
                    super.onAnimationEnd(animation);
                    mTitleTextView.setVisibility(View.INVISIBLE);
                }
            });
            anim.start();
            mTitleVisible = false;
            mShowHideButton.setText(R.string.show_description);
            return;
        }
    }
}
