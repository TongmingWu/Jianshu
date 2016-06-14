package com.tongming.jianshu.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageButton;

import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/5/25.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.ib_contribute)
    ImageButton contribute;

    @BindView(R.id.ib_search)
    ImageButton search;

    @BindView(R.id.main_tab)
    TabLayout tabLayout;


    private String[] TAB = {"热门", "新上榜", "日报", "七日热门", "三十日热门", "市集", "有奖活动", "简书出版", "简书博客"};
    private ArticleTabFragment articleTabFragment;
    private TopicFragment topicFragment;

    @Override
    protected void initViews() {
        tabLayout.addTab(tabLayout.newTab().setText("文章"));
        tabLayout.addTab(tabLayout.newTab().setText("专题"));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        if (topicFragment != null) {
                            transaction.hide(topicFragment);
                        }
                        if (articleTabFragment == null) {
                            articleTabFragment = new ArticleTabFragment();
                            transaction.add(R.id.rl_article, articleTabFragment, "article");
                        } else {
                            articleTabFragment = (ArticleTabFragment) manager.findFragmentByTag("article");
                            transaction.show(articleTabFragment);
                        }
                        break;
                    case 1:
                        if (articleTabFragment != null) {
                            transaction.hide(articleTabFragment);
                        }
                        if (topicFragment == null) {
                            topicFragment = new TopicFragment();
                            transaction.add(R.id.rl_article, topicFragment, "topic");
                        } else {
                            topicFragment = (TopicFragment) manager.findFragmentByTag("topic");
                            transaction.show(topicFragment);
                        }
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setDefaultFragment() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        articleTabFragment = new ArticleTabFragment();
        transaction.replace(R.id.rl_article, articleTabFragment,"article");
        transaction.commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {
        setDefaultFragment();
    }

    @Override
    protected void lazyLoad() {

    }
}
