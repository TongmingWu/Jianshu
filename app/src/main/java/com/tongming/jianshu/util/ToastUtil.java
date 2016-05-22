package com.tongming.jianshu.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Tongming on 2016/2/14.
 */
public class ToastUtil {
    public static void showToast(Context ctx,String text){
        Toast.makeText(ctx,text,Toast.LENGTH_SHORT).show();
    }
}
