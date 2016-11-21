package com.octopepper.mediapickerinstagram.components.gallery;

/*
 * Created by Guillaume on 17/11/2016.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.octopepper.mediapickerinstagram.commons.adapters.RecyclerViewAdapterBase;
import com.octopepper.mediapickerinstagram.commons.adapters.ViewWrapper;

import java.io.File;
import java.lang.ref.WeakReference;

public class GridAdapter extends RecyclerViewAdapterBase<File, MediaItemView> {

    private final Context context;

    GridAdapter(Context context) {
        this.context = context;
    }

    private WeakReference<GridAdapterListener> mWrListener;

    void setListener(GridAdapterListener listener) {
        this.mWrListener = new WeakReference<>(listener);
    }

    @Override
    protected MediaItemView onCreateItemView(ViewGroup parent, int viewType) {
        return new MediaItemView(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<MediaItemView> viewHolder, final int position) {
        MediaItemView itemView = viewHolder.getView();
        itemView.bind(mItems.get(position));
        viewHolder.itemView.setOnClickListener(onClickItem(position));
    }

    private View.OnClickListener onClickItem(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClicked(position);
            }
        };
    }

    private void onItemClicked(int position) {
        mWrListener.get().onClickMediaItem(mItems.get(position));
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}