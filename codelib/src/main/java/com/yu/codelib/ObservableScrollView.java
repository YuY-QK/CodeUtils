package com.tojoy.airtraffic.internal.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.core.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by heyueyang on 2017/9/21.
 * 监听scrollview的滑动状态
 */

public class ObservableScrollView extends NestedScrollView {

    private ScrollViewListener scrollViewListener;
    private int lastAction;

    private int lastY = 0;
    private int touchEventId = -9983761;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            View scroller = (View) msg.obj;
            if (msg.what == touchEventId) {
                if (lastY == scroller.getScrollY()) {
                    handleStop(scroller);
                } else {
                    handler.sendMessageDelayed(handler.obtainMessage(touchEventId, scroller), 5);
                    lastY = scroller.getScrollY();
                }
            }
        }
    };

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }

    public interface ScrollViewListener {
        void onScrollChanged(ObservableScrollView scrollView, int x, int y,
                             int oldx, int oldy);

        void stopScroll();

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        lastAction = ev.getAction();
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            handler.sendMessageDelayed(handler.obtainMessage(touchEventId, ObservableScrollView.this), 5);
        }
        return super.onTouchEvent(ev);
    }

    //处理真正的事件
    private void handleStop(Object view) {
        if (scrollViewListener != null) {
            scrollViewListener.stopScroll();
        }
    }

}