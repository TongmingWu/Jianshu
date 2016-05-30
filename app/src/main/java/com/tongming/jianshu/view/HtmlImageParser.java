package com.tongming.jianshu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tongming.jianshu.base.BaseApplication;

/**
 * Created by Tongming on 2016/5/23.
 */
public class HtmlImageParser implements Html.ImageGetter {
    private Context context;
    private TextView textView;
    private int width;
    private int height;

    public HtmlImageParser(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
        width = context.getResources().getDisplayMetrics().widthPixels; //获取屏幕的宽
        height = context.getResources().getDisplayMetrics().heightPixels;
    }


    @Override
    public Drawable getDrawable(String source) {
        final UrlDrawable urlDrawable = new UrlDrawable();
        BaseApplication.imageLoader.loadImage(source,
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        float scaleWidth = ((float) width) / loadedImage.getWidth();//缩放比例
                        float scaleHeight = ((float) height) / loadedImage.getHeight();
                        Matrix matrix = new Matrix();
                        matrix.postScale(scaleWidth, scaleWidth);

                        /*ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        loadedImage.comress(Bitmap.CompressFormat.JPEG, 50, bos);
                        String base = Basep64.encodeToString(bos.toByteArray(), Base64.DEFAULT);
                        byte[] bytes = Base64.decode(base, 0);
                        loadedImage = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);*/
                        loadedImage = Bitmap.createBitmap(loadedImage, 0, 0, loadedImage.getWidth(), loadedImage.getHeight(), matrix, true);
                        urlDrawable.bitmap = loadedImage;
                        urlDrawable.setBounds(0, 0, loadedImage.getWidth(), loadedImage.getHeight());
                        textView.invalidate();
                        textView.setText(textView.getText());
                    }
                });
        return urlDrawable;
    }
}
