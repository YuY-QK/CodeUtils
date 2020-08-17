package com.tojoy.airtraffic.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;


/**
 *
 * Created by tangyang on 2017/8/24.
 */
public class MyImageSpan extends ImageSpan {

    Drawable d;

    public MyImageSpan(Context arg0,int arg1) {
        super(arg0, arg1);
    }

    public void setDrawable (Drawable drawable ){
        this.d = drawable;
    }

    public int getSize(Paint paint, CharSequence text, int start, int end,
                       Paint.FontMetricsInt fm) {
        Rect rect = d.getBounds();
        if (fm != null) {
            Paint.FontMetricsInt fmPaint=paint.getFontMetricsInt();
            int fontHeight = fmPaint.bottom - fmPaint.top;
            int drHeight=rect.bottom-rect.top;

            int top= drHeight/2 - fontHeight/4;
            int bottom=drHeight/2 + fontHeight/4;

            fm.ascent=-bottom;
            fm.top=-bottom;
            fm.bottom=top;
            fm.descent=top;
        }
        return rect.right;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end,
                     float x, int top, int y, int bottom, Paint paint) {
        canvas.save();
        int transY = 0;
        transY = ((bottom-top) - d.getBounds().bottom)/2+top;
        canvas.translate(x, transY);
        d.draw(canvas);
        canvas.restore();
    }
}