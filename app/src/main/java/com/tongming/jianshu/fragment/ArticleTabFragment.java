package com.tongming.jianshu.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/13.
 */
public class ArticleTabFragment extends BaseFragment {

    @BindView(R.id.tl_content)
    TabLayout tl_content;

    @BindView(R.id.vp_article)
    ViewPager vp_article;

    private String[] TAB = {"热门", "新上榜", "日报", "七日热门", "三十日热门", "市集", "有奖活动", "简书出版", "简书博客"};

    @Override
    protected void initViews() {
        final List<String> tabTitles = new ArrayList<>();
        Collections.addAll(tabTitles, TAB);
        final List<BaseFragment> fragmentList = new ArrayList<>();
        //fragmentList.add(new ArticleFragment());
        for (int i = 0; i < tabTitles.size(); i++) {
            fragmentList.add(ArticleFragment.newInstance(i));
        }
        vp_article.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
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
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article_tab;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
