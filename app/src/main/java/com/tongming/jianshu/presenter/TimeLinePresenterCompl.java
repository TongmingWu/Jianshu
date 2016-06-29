package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.UserTimeLine;
import com.tongming.jianshu.fragment.ITimeLineView;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/6/25.
 */
public class TimeLinePresenterCompl {
    private ITimeLineView timeLineView;
    private Handler mHandler;

    public TimeLinePresenterCompl(ITimeLineView timeLineView) {
        this.timeLineView = timeLineView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void getTimeLine(String slug) {
        OkHttpClient client = BaseApplication.client;
        final Gson gson = BaseApplication.gson;
        Request request = new Request.Builder().url(URLUtil.getUserTimeline(slug)).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    final UserTimeLine timeLine = gson.fromJson(response.body().string(),
                            new TypeToken<UserTimeLine>() {
                            }.getType());
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            timeLineView.onGetTimeLine(timeLine);
                        }
                    });
                }
            }
        });
    }
}
