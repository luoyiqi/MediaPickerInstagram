package com.octopepper.mediapickerinstagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.octopepper.mediapickerinstagram.commons.adapters.ViewPagerAdapter;
import com.octopepper.mediapickerinstagram.commons.models.Session;
import com.octopepper.mediapickerinstagram.commons.models.enums.SourceType;
import com.octopepper.mediapickerinstagram.commons.modules.PermissionModule;
import com.octopepper.mediapickerinstagram.commons.ui.ToolbarView;
import com.octopepper.mediapickerinstagram.components.gallery.GalleryPickerFragment;
import com.octopepper.mediapickerinstagram.components.photo.CapturePhotoFragment;
import com.octopepper.mediapickerinstagram.components.video.CaptureVideoFragment;

import java.util.ArrayList;
import java.util.HashSet;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ToolbarView.OnClickTitleListener,
        ToolbarView.OnClickNextListener, ToolbarView.OnClickBackListener {

    @BindView(R.id.mMainTabLayout)
    TabLayout mMainTabLayout;
    @BindView(R.id.mMainViewPager)
    ViewPager mMainViewPager;
    @BindView(R.id.mToolbar)
    ToolbarView mToolbar;

    @BindString(R.string.tab_gallery)
    String _tabGallery;
    @BindString(R.string.tab_photo)
    String _tabPhoto;
    @BindString(R.string.tab_video)
    String _tabVideo;

    private Session mSession = Session.getInstance();
    private HashSet<SourceType> mSourceTypeSet = new HashSet<>();

    private void initViews() {
        PermissionModule permissionModule = new PermissionModule(this);
        permissionModule.checkPermissions();

        mToolbar.setOnClickBackMenuListener(this)
                .setOnClickTitleListener(this)
                .setOnClickNextListener(this);

        final ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getListFragment());
        mMainViewPager.setAdapter(pagerAdapter);

        mMainTabLayout.addOnTabSelectedListener(getViewPagerOnTabSelectedListener());
        mMainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mMainTabLayout));

        mMainViewPager.setCurrentItem(1);
    }

    private TabLayout.ViewPagerOnTabSelectedListener getViewPagerOnTabSelectedListener() {
        return new TabLayout.ViewPagerOnTabSelectedListener(mMainViewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                displayTitleByTab(tab);
                initNextButtonByTab(tab.getPosition());
            }
        };
    }

    private void displayTitleByTab(TabLayout.Tab tab) {
        if (tab.getText() != null) {
            String title = tab.getText().toString();
            mToolbar.setTitle(title);
        }
    }

    private void initNextButtonByTab(int position) {
        switch (position) {
            case 0:
                mToolbar.showNext();
                break;
            case 1:
                mToolbar.hideNext();
                break;
            case 2:
                mToolbar.hideNext();
                break;
            default:
                mToolbar.hideNext();
                break;
        }
    }

    private ArrayList<Fragment> getListFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        if (mSourceTypeSet.contains(SourceType.Gallery)) {
            fragments.add(GalleryPickerFragment.newInstance());
            mMainTabLayout.addTab(mMainTabLayout.newTab().setText(_tabGallery));
        }

        if (mSourceTypeSet.contains(SourceType.Photo)) {
            fragments.add(CapturePhotoFragment.newInstance());
            mMainTabLayout.addTab(mMainTabLayout.newTab().setText(_tabPhoto));
        }

        if (mSourceTypeSet.contains(SourceType.Video)) {
            fragments.add(CaptureVideoFragment.newInstance());
            mMainTabLayout.addTab(mMainTabLayout.newTab().setText(_tabVideo));
        }

        return fragments;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
        ButterKnife.bind(this);

        // If you want to start activity with custom Tab
        mSourceTypeSet.add(SourceType.Gallery);
        mSourceTypeSet.add(SourceType.Photo);
        mSourceTypeSet.add(SourceType.Video);

        initViews();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onClickBack() {

    }

    @Override
    public void onClickNext() {
        // Fetch file to upload
        mSession.getFileToUpload();
    }

    @Override
    public void onClickTitle() {

    }
}
