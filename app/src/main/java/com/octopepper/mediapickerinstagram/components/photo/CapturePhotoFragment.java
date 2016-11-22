package com.octopepper.mediapickerinstagram.components.photo;

/*
 * Created by Guillaume on 17/11/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.octopepper.mediapickerinstagram.R;
import com.octopepper.mediapickerinstagram.commons.modules.ReboundModule;
import com.octopepper.mediapickerinstagram.commons.modules.ReboundModuleDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CapturePhotoFragment extends Fragment implements ReboundModuleDelegate {

    @BindView(R.id.mBtnTakePhoto)
    ImageView mBtnTakePhoto;

    private ReboundModule mReboundModule = ReboundModule.getInstance(this);

    public static CapturePhotoFragment newInstance() {
        return new CapturePhotoFragment();
    }

    private void initViews() {
        mReboundModule.init(mBtnTakePhoto);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.capture_photo_view, container, false);
        ButterKnife.bind(this, v);
        initViews();
        return v;
    }

    @Override
    public void onTouchActionUp() {

    }
}
