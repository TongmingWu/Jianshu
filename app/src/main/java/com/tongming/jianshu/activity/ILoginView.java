package com.tongming.jianshu.activity;

import com.tongming.jianshu.bean.LoginUser;

/**
 * Created by Tongming on 2016/7/2.
 */
public interface ILoginView {
    void onSuccess(LoginUser user);
    void onFail(int type);
}
