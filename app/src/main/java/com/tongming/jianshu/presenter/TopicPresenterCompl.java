package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.Collection;
import com.tongming.jianshu.fragment.ITopicView;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/6/13.
 */
public class TopicPresenterCompl implements ITopicPresenter {
    private Handler mHandler;
    private ITopicView topicView;

    public TopicPresenterCompl(ITopicView topicView) {
        this.topicView = topicView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getCollections(int type) {
        OkHttpClient client = BaseApplication.client;
        final Gson gson = BaseApplication.gson;
        Request request = new Request.Builder().url(URLUtil.COLLECTION + type).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                try {
                    final Collection collection = gson.fromJson(response.body().string(),
                            new TypeToken<Collection>() {
                            }.getType());
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            topicView.onGetCollections(collection);
                            response.body().close();
                        }
                    });
                }catch (JsonSyntaxException e){
                    topicView.onFailed(response.code());
                }
            }
        });
    }
}
