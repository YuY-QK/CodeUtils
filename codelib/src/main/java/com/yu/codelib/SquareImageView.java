package com.tojoy.airtraffic.internal.widget;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by zhaodanyang on 2017/5/31.
 */

public class SquareImageView extends androidx.appcompat.widget.AppCompatImageView {

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            //如果宽度是精确的，就把ImageView的宽度和高度都用宽度的值
            setMeasuredDimension(widthSize, widthSize);
        } else if (heightMode == MeasureSpec.EXACTLY) {
            //如果高度是精确的，就把ImageView的宽度和高度都用高度的值
            setMeasuredDimension(heightSize, heightSize);
        } else {
            //如果宽度和高度都不是精确的，就使用父类的测量
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

    }
}
