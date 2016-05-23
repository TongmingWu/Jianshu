package com.tongming.jianshu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.ImageButton;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.base.BaseFragment;
import com.tongming.jianshu.fragment.HotArticleFragment;
import com.tongming.jianshu.fragment.NormalArticleFragment;
import com.tongming.jianshu.util.ToastUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.ib_contribute)
    ImageButton contribute;

    @BindView(R.id.ib_search)
    ImageButton search;

    @BindView(R.id.main_tab)
    TabLayout tabLayout;

    @BindView(R.id.tl_content)
    TabLayout tl_content;

    @BindView(R.id.vp_article)
    ViewPager vp_article;

    @BindView(R.id.bnb)
    BottomNavigationBar navigationBar;

    private String[] TAB = {"热门", "新上榜", "日报", "七日热门", "三十日热门", "市集", "有奖活动", "简书出版", "简书博客"};

    private boolean isExit;

    private MyHandler mHandler = new MyHandler(this);

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
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initViews() {
        tabLayout.addTab(tabLayout.newTab().setText("文章"));
        tabLayout.addTab(tabLayout.newTab().setText("专题"));
        final List<String> tabTitles = new ArrayList<String>();
        Collections.addAll(tabTitles, TAB);
        final List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HotArticleFragment());
        for (int i = 0; i < tabTitles.size() - 1; i++) {
            fragmentList.add(new NormalArticleFragment());
        }
        vp_article.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

                                  @Override
                                  public CharSequence getPageTitle(int position) {
                                      return tabTitles.get(position);
                                  }

                                  @Override
                                  public Fragment getItem(int position) {
                                      return fragmentList.get(position);
                                  }

                                  @Override
                                  public int getCount() {
                                      return tabTitles.size();
                                  }
                              }
        );
        tl_content.setupWithViewPager(vp_article);
        navigationBar.addItem(new BottomNavigationItem(R.drawable.cb_icon_discover_selected, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.cb_icon_guanzhu_normal, "关注"))
                .addItem(new BottomNavigationItem(R.drawable.cb_icon_pen_normal, "投稿"))
                .addItem(new BottomNavigationItem(R.drawable.cb_icon_tixing_normal, "提醒"))
                .addItem(new BottomNavigationItem(R.drawable.cb_icon_more_normal, "更多"))
                .initialise();
        navigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
//                navigationBar.selectTab(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
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
