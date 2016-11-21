package com.octopepper.mediapickerinstagram.components.photo;

/*
 * Created by Guillaume on 17/11/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.octopepper.mediapickerinstagram.R;

public class CapturePhotoFragment extends Fragment {

    public static CapturePhotoFragment newInstance() {
        return new CapturePhotoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.capture_photo_view, container, false);
    }

}
