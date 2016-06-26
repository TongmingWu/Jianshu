package com.tongming.jianshu.fragment;

import com.tongming.jianshu.bean.UserTop;

/**
 * Created by Tongming on 2016/6/26.
 */
public interface ITopView {
    void onGetTop(UserTop top);
    void onFailed();
}
