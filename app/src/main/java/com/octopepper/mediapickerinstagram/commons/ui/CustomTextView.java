package com.octopepper.mediapickerinstagram.commons.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.octopepper.mediapickerinstagram.R;

public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);

        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTextView_customFont:
                    String customFontName = a.getString(attr);
                    Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + customFontName + ".ttf");
                    setTypeface(tf);
                    break;
                default:
                    break;
            }
        }
        a.recycle();
    }

}