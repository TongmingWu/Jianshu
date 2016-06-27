package com.tongming.jianshu.fragment;

import com.tongming.jianshu.bean.Collection;

/**
 * Created by Tongming on 2016/6/13.
 */
public interface ITopicView {
    void onGetCollections(Collection collection);
    void onFailed(int code);
}
