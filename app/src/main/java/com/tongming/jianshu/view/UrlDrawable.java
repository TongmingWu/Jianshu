package com.tongming.jianshu.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by Tongming on 2016/5/23.
 */
public class UrlDrawable extends BitmapDrawable {
    protected Bitmap bitmap;

    @Override
    public void draw(Canvas canvas) {
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0, 0, getPaint());
        }
    }
}
