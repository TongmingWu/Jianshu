package com.tongming.jianshu.base;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by Tongming on 2016/5/20.
 */
public class BaseApplication extends Application {
    public static OkHttpClient client;
    public static Gson gson;
    public static ImageLoader imageLoader;
    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(configuration);
        File cacheFile = new File(getCacheDir().getPath());
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(cacheFile, cacheSize);
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .cache(cache)
                .build();
        gson = new GsonBuilder().create();
    }
}
