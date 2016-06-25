package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.activity.ITopicDetailView;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.ColDetail;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/6/14.
 */
public class TopicDetailPreCompl {
    private Handler mHandler;
    private ITopicDetailView topicDetailView;

    public TopicDetailPreCompl(ITopicDetailView topicDetailView) {
        this.topicDetailView = topicDetailView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void getTopicDetail(String slug) {
        OkHttpClient client = BaseApplication.client;
        final Gson gson = BaseApplication.gson;
        Request request = new Request.Builder().url(URLUtil.COLLECTION_DETAIL + slug).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if(response.code()==200){
                    final ColDetail colDetail = gson.fromJson(response.body().string(),
                            new TypeToken<ColDetail>() {
                            }.getType());
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            topicDetailView.onGetDetail(colDetail);
                            response.body().close();
                        }
                    });
                }else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            topicDetailView.onGetFailed(response.code());
                        }
                    });
                }
            }
        });
    }
}
