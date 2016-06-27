package com.tongming.jianshu.util;

import android.content.Context;

/**
 * Created by Tongming on 2016/6/26.
 */
public class DMUtil {
    public static int getScale(Context context, int num) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (num * scale + 0.5f);
    }
}
