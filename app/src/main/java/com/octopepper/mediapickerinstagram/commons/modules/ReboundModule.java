package com.octopepper.mediapickerinstagram.commons.modules;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;

public class ReboundModule {

    private ReboundModuleDelegate mDelegate;
    private SpringSystem mSpringSystem = null;
    private Spring mSpring = null;

    private ReboundModule(ReboundModuleDelegate delegate) {
        this.mDelegate = delegate;
    }

    public static ReboundModule getInstance(ReboundModuleDelegate delegate) {
        return new ReboundModule(delegate);
    }

    public void init(ImageView imageView) {
        if (mSpringSystem == null) {
            mSpringSystem = SpringSystem.create();
            if (mSpring == null) {
                mSpring = mSpringSystem.createSpring();
            }
        }
        addListener(imageView);
        imageView.setOnTouchListener(addOnTouchListener());
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

    private View.OnTouchListener addOnTouchListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mSpring.setEndValue(1);
                        break;
                    case MotionEvent.ACTION_UP:
                        mDelegate.onTouchActionUp();
                    case MotionEvent.ACTION_CANCEL:
                        mSpring.setEndValue(0);
                        break;
                }
                return true;
            }
        };
    }

}