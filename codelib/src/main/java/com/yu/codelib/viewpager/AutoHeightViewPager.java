package com.yu.codelib.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by yu on 2020/08/12.
 */

public class AutoHeightViewPager extends ViewPager {

    public AutoHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoHeightViewPager(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        int count = getChildCount();
        for (int a = 0; a < count; a++) {
            View childView = getChildAt(a);
            if (childView != null) {
                childView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                int h = childView.getMeasuredHeight();
                if (h > height) {
                    height = h;
                }
            }

        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
