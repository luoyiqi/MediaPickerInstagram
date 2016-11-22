/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.octopepper.mediapickerinstagram.commons.cameraview.api9;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.octopepper.mediapickerinstagram.R;
import com.octopepper.mediapickerinstagram.commons.cameraview.base.PreviewImpl;

public class SurfaceViewPreview extends PreviewImpl {

    final SurfaceView mSurfaceView;

    public SurfaceViewPreview(Context context, ViewGroup parent) {
        final View view = View.inflate(context, R.layout.surface_view, parent);
        mSurfaceView = (SurfaceView) view.findViewById(R.id.surface_view);
        final SurfaceHolder holder = mSurfaceView.getHolder();
        //noinspection deprecation
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder h) {
            }

            @Override
            public void surfaceChanged(SurfaceHolder h, int format, int width, int height) {
                setSize(width, height);
                if (!ViewCompat.isInLayout(mSurfaceView)) {
                    dispatchSurfaceChanged();
                }
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder h) {
                setSize(0, 0);
            }
        });
    }

    @Override
    public Surface getSurface() {
        return getSurfaceHolder().getSurface();
    }

    @Override
    public SurfaceHolder getSurfaceHolder() {
        return mSurfaceView.getHolder();
    }

    @Override
    public View getView() {
        return mSurfaceView;
    }

    @Override
    public Class getOutputClass() {
        return SurfaceHolder.class;
    }

    @Override
    public void setDisplayOrientation(int displayOrientation) {
    }

    @Override
    public boolean isReady() {
        return getWidth() != 0 && getHeight() != 0;
    }

}
