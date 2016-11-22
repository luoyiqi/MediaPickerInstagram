package com.octopepper.mediapickerinstagram.commons.modules;

import android.content.Context;
import android.content.Intent;

import com.octopepper.mediapickerinstagram.components.editor.EditorActivity;

public class NavigatorEditorModule {

    private Context mContext;

    public NavigatorEditorModule(Context context) {
        this.mContext = context;
    }

    public void goTo() {
        Intent intent = new Intent(mContext, EditorActivity.class);
        mContext.startActivity(intent);
    }

}
