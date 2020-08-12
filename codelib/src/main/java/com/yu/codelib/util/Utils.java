package com.yu.codelib.util;

import android.content.Context;

/**
 * Created by yu on 2020/8/12.
 * 工具类
 */
public class Utils {

    /**
     * dp转px
     *
     * @param dpValue dp值
     * @return px值
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
