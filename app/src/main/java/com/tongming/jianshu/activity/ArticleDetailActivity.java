package com.tongming.jianshu.activity;

import android.support.v7.widget.Toolbar;

import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/5/22.
 */
public class ArticleDetailActivity extends BaseActivity {
    @BindView(R.id.tl_detail)
    Toolbar toolbar;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void initViews() {

    }
}
