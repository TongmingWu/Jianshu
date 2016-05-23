package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.activity.IDetailView;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.Detail;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/5/22.
 */
public class DetailPresenterCompl implements IDetailPresenter {
    private IDetailView mDetailView;
    private Handler mHandler;

    public DetailPresenterCompl(IDetailView mDetailView) {
        this.mDetailView = mDetailView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getDetail(String slug) {
        OkHttpClient client = BaseApplication.client;
        final Gson gson = BaseApplication.gson;
        final Request request = new Request.Builder().url(URLUtil.DETAIL + slug).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Detail detail = gson.fromJson(response.body().string(),
                        new TypeToken<Detail>() {
                        }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mDetailView.onGetDetail(detail);
                    }
                });
            }
        });
    }
}
