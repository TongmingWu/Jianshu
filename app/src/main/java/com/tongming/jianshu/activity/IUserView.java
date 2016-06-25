package com.tongming.jianshu.activity;

import com.tongming.jianshu.bean.UserLatest;
import com.tongming.jianshu.bean.UserTimeLine;
import com.tongming.jianshu.bean.UserTop;

/**
 * Created by Tongming on 2016/6/21.
 */
public interface IUserView {
    void onGetLatest(UserLatest latest);
    void onGetTop(UserTop top);
    void onGetTimeLine(UserTimeLine timeLine);
    void onGetFailed(int code);
}
