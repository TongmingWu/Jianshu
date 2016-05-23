package com.tongming.jianshu.fragment;

import android.os.Bundle;

import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseFragment;

/**
 * Created by Tongming on 2016/5/21.
 */
public class NormalArticleFragment extends BaseFragment {

    private int type;

    public NormalArticleFragment() {
    }

    public NormalArticleFragment(int type) {
        this.type = type;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
