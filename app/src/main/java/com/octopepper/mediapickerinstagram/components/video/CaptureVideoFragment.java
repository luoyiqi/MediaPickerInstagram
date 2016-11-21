package com.octopepper.mediapickerinstagram.components.video;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.octopepper.mediapickerinstagram.R;

public class CaptureVideoFragment extends Fragment {

    public static CaptureVideoFragment newInstance() {
        return new CaptureVideoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.capture_video_view, container, false);
    }

}
