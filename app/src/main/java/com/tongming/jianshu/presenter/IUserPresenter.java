package com.tongming.jianshu.presenter;

/**
 * Created by Tongming on 2016/6/21.
 */
public interface IUserPresenter {
    void getLatest(String slug);
    void getTop(String slug);
    void getTimeline(String slug);
}
