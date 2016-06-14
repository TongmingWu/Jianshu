package com.tongming.jianshu.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tongming.jianshu.R;

/**
 * Created by Tongming on 2016/6/5.
 */
public class LineOption extends RelativeLayout {
    private ImageView icon;
    private TextView desc;
    private TextView num;
    private int mImg;
    private String mNum;
    private String mDesc;

    public LineOption(Context context) {
        super(context);
    }

    public LineOption(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.item_option, this, true);
        //加载自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.LineOption);
        mImg = array.getResourceId(R.styleable.LineOption_view_src, R.drawable.btn_switch_close_night);
        mDesc = array.getString(R.styleable.LineOption_view_desc);
        mNum = array.getString(R.styleable.LineOption_view_num);
        array.recycle();
    }

    public LineOption(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        icon = (ImageView) findViewById(R.id.iv_jianyou);
        desc = (TextView) findViewById(R.id.item_tv_desc);
        num = (TextView) findViewById(R.id.item_tv_num);
        setIvView(mImg);
        if (!TextUtils.isEmpty(mDesc)) {
            setDesc(mDesc);
        }
        if (!TextUtils.isEmpty(mNum)) {
            setNum(mNum);
        }
    }

    public void setIvView(int id) {
        icon.setImageResource(id);
    }

    public void setDesc(String d) {
        desc.setText(d);
    }

    public void setNum(String n) {
        num.setText(n);
    }

    public ImageView getIcon() {
        return icon;
    }

    public TextView getDesc() {
        return desc;
    }

    public TextView getNum() {
        return num;
    }
}
