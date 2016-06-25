package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.activity.IUserView;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.UserLatest;
import com.tongming.jianshu.bean.UserTimeLine;
import com.tongming.jianshu.bean.UserTop;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/6/21.
 */
public class UserPresenterCompl implements IUserPresenter {
    private IUserView userView;
    private Handler mHandler;
    private OkHttpClient client = BaseApplication.client;
    private Gson gson = BaseApplication.gson;

    public UserPresenterCompl(IUserView userView) {
        this.userView = userView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getLatest(String slug) {
        final Request request = new Request.Builder().url(URLUtil.getUserLatest(slug)).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if(response.code()==200){
                    final UserLatest latest = gson.fromJson(response.body().string(),
                            new TypeToken<UserLatest>() {
                            }.getType());
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            userView.onGetLatest(latest);
                            response.body().close();
                        }
                    });
                }
                else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            userView.onGetFailed(response.code());
                        }
                    });
                }
            }
        });
    }

    @Override
    public void getTop(String slug) {
        Request request = new Request.Builder().url(URLUtil.getUserTop(slug)).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final UserTop top = gson.fromJson(response.body().string(),
                        new TypeToken<UserTop>() {
                        }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.onGetTop(top);
                    }
                });
            }
        });
    }

    @Override
    public void getTimeline(String slug) {
        Request request = new Request.Builder().url(URLUtil.getUserTimeline(slug)).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final UserTimeLine timeLine = gson.fromJson(response.body().string(),
                        new TypeToken<UserTimeLine>() {
                        }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.onGetTimeLine(timeLine);
                    }
                });
            }
        });
    }
}
