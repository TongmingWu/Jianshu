package com.tongming.jianshu.view;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Tongming on 2016/5/23.
 */
public class HtmlTextView extends TextView {
    public HtmlTextView(Context context) {
        super(context);
    }

    public HtmlTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HtmlTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private static String convertStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }

    //将html文本转换为spannable
    public void setHtmlFromString(String html, boolean useLocalDrawables) {
        Html.ImageGetter imageGetter;

        if (useLocalDrawables) {
            imageGetter = new LocalImageGetter();
        } else {
            imageGetter = new HtmlImageParser(getContext(), this);
        }

        setText(Html.fromHtml(html, imageGetter, new HtmlTagHandler()));

        setMovementMethod(LinkMovementMethod.getInstance());
        //setTextColor(getResources().getColor(android.R.color.secondary_text_dark_nodisable));
    }
}
