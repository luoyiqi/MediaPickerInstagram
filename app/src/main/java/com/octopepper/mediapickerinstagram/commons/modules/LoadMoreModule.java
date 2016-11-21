package com.octopepper.mediapickerinstagram.commons.modules;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class LoadMoreModule {

    private RecyclerView recyclerView;
    private LoadMoreModuleDelegate delegate;

    private static final Object TAG = new Object();
    private static final int SETTLING_DELAY = 300;

    private Picasso sPicasso = null;
    private Runnable mSettlingResumeRunnable = null;

    public void LoadMoreUtils(RecyclerView r, LoadMoreModuleDelegate d, Context context) {
        this.recyclerView = r;
        this.delegate = d;

        if (sPicasso == null) {
            sPicasso = Picasso.with(context.getApplicationContext());
        }

        addListener();
    }

    private void addListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (llm.findFirstVisibleItemPosition() >= (llm.getItemCount() / 5)) {
                    delegate.shouldLoadMore();
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
                if (scrollState == RecyclerView.SCROLL_STATE_IDLE) {
                    recyclerView.removeCallbacks(mSettlingResumeRunnable);
                    sPicasso.resumeTag(TAG);

                } else if (scrollState == RecyclerView.SCROLL_STATE_SETTLING) {
                    mSettlingResumeRunnable = new Runnable() {
                        @Override
                        public void run() {
                            sPicasso.resumeTag(TAG);
                        }
                    };

                    recyclerView.postDelayed(mSettlingResumeRunnable, SETTLING_DELAY);
                } else {
                    sPicasso.pauseTag(TAG);
                }
            }
        });
    }

}
