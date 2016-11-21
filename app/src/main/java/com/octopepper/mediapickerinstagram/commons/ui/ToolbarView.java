package com.octopepper.mediapickerinstagram.commons.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.octopepper.mediapickerinstagram.R;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToolbarView extends RelativeLayout {

    @BindView(R.id.mTitle)
    CustomTextView mTitle;
    @BindView(R.id.mIconBack)
    CustomTextView mIconBack;
    @BindView(R.id.mIconNext)
    CustomTextView mIconNext;

    private WeakReference<OnClickBackListener> mWrBackMenuListener;
    private WeakReference<OnClickNextListener> mWrNextListener;
    private WeakReference<OnClickTitleListener> mWrTitleListener;

    @OnClick(R.id.mIconBack)
    void onClickBack() {
        mWrBackMenuListener.get().onClickBack();
    }

    @OnClick(R.id.mTitle)
    void onClickTitle() {
        mWrTitleListener.get().onClickTitle();
    }

    @OnClick(R.id.mIconNext)
    void onClickNext() {
        mWrNextListener.get().onClickNext();
    }

    private void init(Context context) {
        View view = View.inflate(context, R.layout.toolbar_view, this);
        ButterKnife.bind(this, view);
    }

    public ToolbarView(Context context) {
        super(context);
        init(context);
    }

    public ToolbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ToolbarView setOnClickBackMenuListener(OnClickBackListener listener) {
        this.mWrBackMenuListener = new WeakReference<>(listener);
        return this;
    }

    public ToolbarView setOnClickTitleListener(OnClickTitleListener listener) {
        this.mWrTitleListener = new WeakReference<>(listener);
        return this;
    }

    public ToolbarView setOnClickNextListener(OnClickNextListener listener) {
        this.mWrNextListener = new WeakReference<>(listener);
        return this;
    }

    public ToolbarView setTitle(String title) {
        mTitle.setText(title);
        return this;
    }

    public ToolbarView hideNext() {
        mIconNext.setVisibility(GONE);
        return this;
    }

    public ToolbarView showNext() {
        mIconNext.setVisibility(VISIBLE);
        return this;
    }

    public interface OnClickBackListener {
        void onClickBack();
    }

    public interface OnClickNextListener {
        void onClickNext();
    }

    public interface OnClickTitleListener {
        void onClickTitle();
    }

}
