package com.tongming.jianshu.presenter;

import java.util.List;

/**
 * Created by Tongming on 2016/5/21.
 */
public interface IArticlePresneter {
    void getArticleList(String cid);

    void loadMore(List<String> ids, String page, int type);
}
