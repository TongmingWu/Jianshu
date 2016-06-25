package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.activity.ISearchView;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.SearchResult;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/6/19.
 */
public class SearchPresenterCompl {
    private ISearchView searchView;
    private Handler mHandler;

    public SearchPresenterCompl(ISearchView searchView) {
        this.searchView = searchView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void search(String query) {
        OkHttpClient client = BaseApplication.client;
        final Gson gson = BaseApplication.gson;
        Request request = new Request.Builder().url(URLUtil.SEARCH + query).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final SearchResult result = gson.fromJson(response.body().string(),
                        new TypeToken<SearchResult>(){}.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        searchView.onSearch(result);
                        response.body().close();
                    }
                });
            }
        });
    }
}
