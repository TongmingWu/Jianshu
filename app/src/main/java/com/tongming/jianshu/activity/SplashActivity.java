package com.tongming.jianshu.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseActivity;

/**
 * Created by Tongming on 2016/5/20.
 */
public class SplashActivity extends BaseActivity {

    private Handler handler;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initViews() {
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(
                        SplashActivity.this, HomeActivity.class
                ), ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
            }
        }, 3000);

    }
}
