package com.yu.codelib.text;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import java.util.List;


/**
 * Created by yu on 2020/08/12.
 */

public class AutoChangeTextView extends AppCompatTextView {
    private Handler mHander = new Handler();
    List<String> list;
    private int index = 0;
    private boolean startSwitch;

    public void setList(List<String> list) {
        this.list = list;
    }

    public AutoChangeTextView(Context context) {
        super(context);
    }

    public AutoChangeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoChangeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (list != null && list.size() > 0) {
            setText(list.get(index));
            index++;
        }
    }

    public void startChange() {
        if (!startSwitch) {//没有切换的时候才轮播
            mHander.postDelayed(new SwitchTask(), 3 * 1000);
        }
        startSwitch = true;
    }

    public void stopChange() {
        mHander.removeCallbacksAndMessages(null);
        startSwitch = false;
    }

    public String getCurrentData() {
        return list.get(index);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startChange();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopChange();
    }

    private class SwitchTask implements Runnable {
        @Override
        public void run() {
            if (list != null && list.size() > 0) {
                if (index >= list.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }
                setText(list.get(index));
                mHander.postDelayed(this, 3 * 1000);//继续调用延时轮播的逻辑,实现自动轮播

            }

        }
    }

}
