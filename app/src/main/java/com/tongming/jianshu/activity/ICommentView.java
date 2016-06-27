package com.tongming.jianshu.activity;

import com.tongming.jianshu.bean.Comment;

/**
 * Created by Tongming on 2016/6/26.
 */
public interface ICommentView {
    void onGetComment(Comment comment);
    void onFailed(int code);
}
