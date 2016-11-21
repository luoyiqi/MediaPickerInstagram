package com.octopepper.mediapickerinstagram.components.gallery;

/*
 * Created by Guillaume on 17/11/2016.
 */

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.octopepper.mediapickerinstagram.R;
import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MediaItemView extends RelativeLayout {

    @BindView(R.id.mMediaThumb)
    ImageView mMediaThumb;

    public MediaItemView(Context context) {
        super(context);
        View v = View.inflate(context, R.layout.media_item_view, this);
        ButterKnife.bind(this, v);
    }

    public void bind(File file) {
        Picasso.with(getContext())
                .load(Uri.fromFile(file))
                .resize(350, 350)
                .centerCrop()
                .placeholder(R.drawable.placeholder_media)
                .error(R.drawable.placeholder_error_media)
                .noFade()
                .into(mMediaThumb);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

}
