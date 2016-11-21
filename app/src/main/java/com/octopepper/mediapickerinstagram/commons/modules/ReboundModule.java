package com.octopepper.mediapickerinstagram.commons.modules;

import android.widget.ImageView;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;

public class ReboundModule {

    private SpringSystem mSpringSystem = null;
    private Spring mSpring = null;

    private ReboundModule() {
    }

    public static ReboundModule getInstance() {
        return new ReboundModule();
    }

    public void init(ImageView imageView) {
        if (mSpringSystem == null) {
            mSpringSystem = SpringSystem.create();
            if (mSpring == null) {
                mSpring = mSpringSystem.createSpring();
            }
        }
        addListener(imageView);
    }

    public void setEndValue(int endValue) {
        mSpring.setEndValue(endValue);
    }

    private void addListener(final ImageView imageView) {
        mSpring.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                float value = (float) spring.getCurrentValue();
                float scale = 1f - (value * 0.1f);
                imageView.setScaleX(scale);
                imageView.setScaleY(scale);
            }
        });
    }
}