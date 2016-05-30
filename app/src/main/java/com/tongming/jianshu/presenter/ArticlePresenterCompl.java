package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.activity.ArticleDetailActivity;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.ArticleList;
import com.tongming.jianshu.fragment.IArticleView;
import com.tongming.jianshu.util.LogUtil;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;
import java.util.List;

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
    OkHttpClient client = BaseApplication.client;
    final Gson gson = BaseApplication.gson;

    public ArticlePresenterCompl(IArticleView mArticleView) {
        this.mArticleView = mArticleView;
        mHandler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void getArticleList(String cid) {
        Request request = new Request.Builder().url(URLUtil.CATEGORY + cid).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //LogUtil.d("Article",response.body().string());
                final ArticleList list = gson.fromJson(response.body().string(), new TypeToken<ArticleList>() {
                }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mArticleView.onGetArticle(list);
                        LogUtil.d(ArticleDetailActivity.class.getSimpleName(), "获取文章数据成功");
                    }
                });
            }
        });
    }

    @Override
    public void loadMore(List<String> ids, int type) {
        Request request = null;
        if(type==0){
            request = new Request.Builder().url(URLUtil.getMore(ids)).build();
        }else {
            request = new Request.Builder().url(URLUtil.LOAD_NORMAL+ids.get(0)).build();
        }
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final ArticleList list = gson.fromJson(response.body().string(),
                        new TypeToken<ArticleList>() {
                        }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("Article", "上拉加载数据成功");
                        mArticleView.onLoadMore(list);
                    }
                });
            }
        });
    }
}
