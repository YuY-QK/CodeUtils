package com.yu.codelib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.orhanobut.logger.Logger;
import com.yu.codelib.util.Utils;

import pl.droidsonroids.gif.GifDrawable;

/**
 * Created by MSH on 2017/2/7.
 */

public class GifLoadingView extends FrameLayout {

    private Handler handler;
    private GifDrawable gifDrawable;
    private ImageView imageView;

    public GifLoadingView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public GifLoadingView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GifLoadingView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
//        View contentView = LayoutInflater.from(context).inflate(R.layout.item_ptr_loading, this, false);
//        GifImageView ivGif = (GifImageView) contentView.findViewById(R.id.iv_gif);
//        gifDrawable = (GifDrawable) ivGif.getDrawable();

        imageView = new ImageView(context);
//        imageView.setBackgroundColor(Color.BLACK);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                Utils.dp2px(context, 35), Utils.dp2px(context,35)));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(imageView);
        addView(frameLayout);

    }


    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
//        if (visibility == View.VISIBLE) {
//            gifDrawable.start();
//        } else {
//            gifDrawable.stop();
//        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.e("---" + "：" + "result=" + (Looper.myLooper() == Looper.getMainLooper()));
        if (Looper.myLooper() == Looper.getMainLooper()) {

            GlideApp.with(getContext())
                    .asGif()
                    .load(R.drawable.anim_loading_bg_white)
                    .override(Utils.dp2px(getContext(), 35), Utils.dp2px(getContext(), 35))
                    .into(imageView);
//            gifDrawable.start();
        }

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}

