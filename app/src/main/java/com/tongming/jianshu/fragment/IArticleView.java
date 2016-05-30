package com.tongming.jianshu.fragment;

import com.tongming.jianshu.bean.ArticleList;

/**
 * Created by Tongming on 2016/5/21.
 */
public interface IArticleView {
    void onGetArticle(ArticleList list);
    void onLoadMore(ArticleList list);
}
