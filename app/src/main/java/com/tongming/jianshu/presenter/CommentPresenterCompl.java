package com.tongming.jianshu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.tongming.jianshu.activity.ICommentView;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.Comment;
import com.tongming.jianshu.util.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/6/26.
 */
public class CommentPresenterCompl {
    private ICommentView commentView;
    private Handler mHandler;

    public CommentPresenterCompl(ICommentView commentView) {
        this.commentView = commentView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void getComment(final String nid) {
        OkHttpClient client = BaseApplication.client;
        final Gson gson = BaseApplication.gson;
        Request request = new Request.Builder().url(URLUtil.COMMENT + nid).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    try {
                        final Comment comment = gson.fromJson(response.body().string(),
                                new TypeToken<Comment>() {
                                }.getType());
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                commentView.onGetComment(comment);
                            }
                        });
                    } catch (JsonSyntaxException e) {
                        commentView.onFailed(response.code());
                    }
                }
            }
        });
    }
}
