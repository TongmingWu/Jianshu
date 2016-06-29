package com.tongming.jianshu.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.tongming.jianshu.R;
import com.tongming.jianshu.activity.SearchViewActivity;
import com.tongming.jianshu.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/5/25.
 */
public class HomeFragment extends BaseFragment {

    private static final String TAG = HomeFragment.class.getSimpleName();
    @BindView(R.id.ib_contribute)
    ImageButton contribute;

    @BindView(R.id.ib_search)
    ImageButton search;

    @BindView(R.id.main_tab)
    TabLayout tabLayout;

    @BindView(R.id.ll_root)
    LinearLayout root;


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
        //搜索框
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchViewActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(getActivity(), search, "transition").toBundle());
            }
        });
    }

    private void setDefaultFragment() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        articleTabFragment = new ArticleTabFragment();
        transaction.replace(R.id.rl_article, articleTabFragment, "article");
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
