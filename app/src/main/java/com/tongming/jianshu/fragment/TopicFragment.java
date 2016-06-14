package com.tongming.jianshu.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/13.
 */
public class TopicFragment extends BaseFragment {

    @BindView(R.id.tl_topic)
    TabLayout tabLayout;
    @BindView(R.id.vp_topic)
    ViewPager viewPager;
    String[] titles = {"热门", "推荐"};

    @Override
    protected void initViews() {
        final List<TopicDetailFragment> fragmentList = new ArrayList<>();
        fragmentList.add(TopicDetailFragment.getInstance(53));//热门
        fragmentList.add(TopicDetailFragment.getInstance(58));//推荐
        viewPager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return titles.length;
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
