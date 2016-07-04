package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.activity.ILoginView;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.LoginUser;
import com.tongming.jianshu.util.LogUtil;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/7/2.
 */
public class LoginPresenterCompl {
    private ILoginView loginView;
    private Handler mHandler;

    public LoginPresenterCompl(ILoginView loginView) {
        this.loginView = loginView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void doLogin(String number, String name, String pwd) {
        OkHttpClient client = BaseApplication.client;
        final Gson gson = BaseApplication.gson;
        FormBody body = new FormBody.Builder()
                .add("mobile_number", number)
                .add("name", name)
                .add("password", pwd)
                .build();
        Request request = new Request.Builder().url(URLUtil.LOGIN).post(body).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.code() == 200) {
                    final LoginUser user = gson.fromJson(
                            response.body().string(),
                            new TypeToken<LoginUser>() {
                            }.getType()
                    );
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            loginView.onSuccess(user);
                        }
                    });
                } else {
                    LogUtil.d(LoginPresenterCompl.class.getSimpleName(), response.code() + "");
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            loginView.onFail(response.code());
                        }
                    });
                }
            }
        });
    }
}
