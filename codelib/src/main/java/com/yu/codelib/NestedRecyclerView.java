package com.yu.codelib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by yu on 2020/08/12.
 * 是否可滑动的RecycleView
 */
public class NestedRecyclerView extends RecyclerView {
    public NestedRecyclerView(Context context) {
        super(context);
    }

    public NestedRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NestedRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return super.onInterceptTouchEvent(e);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (canScrollUp() || canScrollDown()) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean canScrollUp() {
        return this.canScrollVertically(-1);
    }

    public boolean canScrollDown() {
        return this.canScrollVertically(1);
    }

}
