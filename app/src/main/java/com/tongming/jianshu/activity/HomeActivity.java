package com.tongming.jianshu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.fragment.AttentionFragment;
import com.tongming.jianshu.fragment.HomeFragment;
import com.tongming.jianshu.fragment.MineFragment;
import com.tongming.jianshu.fragment.RemindFragment;
import com.tongming.jianshu.fragment.TougaoFragment;
import com.tongming.jianshu.util.ToastUtil;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.bnb)
    BottomNavigationBar navigationBar;


    private boolean isExit;

    private MyHandler mHandler = new MyHandler(this);
    private HomeFragment homeFragment;
    private AttentionFragment attentionFragment;
    private TougaoFragment tougaoFragment;
    private RemindFragment remindFragment;
    private MineFragment mineFragment;

    private class MyHandler extends Handler {
        private final WeakReference<HomeActivity> mActivity;

        private MyHandler(HomeActivity activity) {
            mActivity = new WeakReference<HomeActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            HomeActivity activity = mActivity.get();
            if (activity != null) {
                isExit = false;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        setDefaultFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initViews() {

        navigationBar.addItem(new BottomNavigationItem(R.drawable.cb_icon_discover_selected, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.cb_icon_guanzhu_normal, "关注"))
                .addItem(new BottomNavigationItem(R.drawable.cb_icon_pen_normal, "投稿"))
                .addItem(new BottomNavigationItem(R.drawable.cb_icon_tixing_normal, "提醒"))
                .addItem(new BottomNavigationItem(R.drawable.cb_icon_more_normal, "我的"))
                .initialise();
        navigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                //ToastUtil.showToast(HomeActivity.this, position + "");
                switch (position) {
                    case 0:
                        hideTab(transaction);
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                            transaction.add(R.id.rl_container, homeFragment, "homepage");
                        } else {
                            homeFragment = (HomeFragment) manager.findFragmentByTag("homepage");
                            transaction.show(homeFragment);
                        }
                        break;
                    case 1:
                        hideTab(transaction);
                        if (attentionFragment == null) {
                            attentionFragment = new AttentionFragment();
                            transaction.add(R.id.rl_container, attentionFragment, "attention");
                        } else {
                            attentionFragment = (AttentionFragment) manager.findFragmentByTag("attention");
                            transaction.show(attentionFragment);
                        }
                        break;
                    case 2:
                        hideTab(transaction);
                        if (tougaoFragment == null) {
                            tougaoFragment = new TougaoFragment();
                            transaction.add(R.id.rl_container, tougaoFragment, "tougao");
                        } else {
                            tougaoFragment = (TougaoFragment) manager.findFragmentByTag("tougao");
                            transaction.show(tougaoFragment);
                        }
                        break;
                    case 3:
                        hideTab(transaction);
                        if (remindFragment == null) {
                            remindFragment = new RemindFragment();
                            transaction.add(R.id.rl_container, remindFragment, "remind");
                        } else {
                            remindFragment = (RemindFragment) manager.findFragmentByTag("remind");
                            transaction.show(remindFragment);
                        }
                        break;
                    case 4:
                        hideTab(transaction);
                        if (mineFragment == null) {
                            mineFragment = new MineFragment();
                            transaction.add(R.id.rl_container, mineFragment, "mine");
                        } else {
                            mineFragment = (MineFragment) manager.findFragmentByTag("mine");
                            transaction.show(mineFragment);
                        }
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void hideTab(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (attentionFragment != null) {
            transaction.hide(attentionFragment);
        }
        if (tougaoFragment != null) {
            transaction.hide(tougaoFragment);
        }
        if (mineFragment != null) {
            transaction.hide(tougaoFragment);
        }
        if (remindFragment != null) {
            transaction.hide(remindFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.replace(R.id.rl_container, homeFragment,"homepage");
        transaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            ToastUtil.showToast(HomeActivity.this, "再点一次退出");
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);
        }
    }

}
