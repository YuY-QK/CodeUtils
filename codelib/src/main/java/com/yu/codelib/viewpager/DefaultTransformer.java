package com.yu.codelib.viewpager;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by yu on 2020/08/12.
 *
 * 默认的竖向viewpage切换动画
 */
public class DefaultTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View view, float position) {
        float alpha = 0;
        if (0 <= position && position <= 1) {
            alpha = 1 - position;
        } else if (-1 < position && position < 0) {
            alpha = position + 1;
        }
        view.setAlpha(alpha);
        view.setTranslationX(view.getWidth() * -position);
        float yPosition = position * view.getHeight();
        view.setTranslationY(yPosition);
    }
}
