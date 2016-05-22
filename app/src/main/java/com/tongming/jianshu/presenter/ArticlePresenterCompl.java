package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.ArticleList;
import com.tongming.jianshu.fragment.IArticleView;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Tongming on 2016/5/21.
 */
public class ArticlePresenterCompl implements IArticlePresneter {
    private IArticleView mArticleView;
    private Handler mHandler;

    public ArticlePresenterCompl(IArticleView mArticleView) {
        this.mArticleView = mArticleView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getArticle(String category) {

    }

    @Override
    public void getHotArticle() {
        OkHttpClient client = BaseApplication.client;
        final Gson gson = BaseApplication.gson;
        Request request = new Request.Builder().url(URLUtil.HOT).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final ArticleList list = gson.fromJson(response.body().string(), new TypeToken<ArticleList>() {
                }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mArticleView.onGetArticle(list);
                    }
                });
            }
        });
    }
}
