package com.tongming.jianshu.activity;

import com.tongming.jianshu.bean.ColDetail;

/**
 * Created by Tongming on 2016/6/14.
 */
public interface ITopicDetailView {
    void onGetDetail(ColDetail colDetail);
    void onGetFailed(int code);
}
