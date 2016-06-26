package com.tongming.jianshu.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.base.BaseFragment;
import com.tongming.jianshu.bean.UserLatest;
import com.tongming.jianshu.bean.UserTimeLine;
import com.tongming.jianshu.bean.UserTop;
import com.tongming.jianshu.fragment.UserArticleFragment;
import com.tongming.jianshu.fragment.UserMoreFragment;
import com.tongming.jianshu.fragment.UserTimeLineFragment;
import com.tongming.jianshu.presenter.UserPresenterCompl;
import com.tongming.jianshu.util.LogUtil;
import com.tongming.jianshu.util.ToastUtil;
import com.tongming.jianshu.view.GlideGircleTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/19.
 */
public class UserActivity extends BaseActivity implements IUserView {
    private static final String TAG = UserActivity.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.avatar)
    ImageView avatar;
    @BindView(R.id.tv_about)
    TextView about;
    @BindView(R.id.tv_num)
    TextView num;
    @BindView(R.id.progressbar)
    ProgressBar bar;
    @BindView(R.id.user_tab)
    TabLayout tabLayout;
    /*@BindView(R.id.ll_root)
    LinearLayout root;*/
    @BindView(R.id.vp_user)
    ViewPager viewPager;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public void initViews() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
//        root.setVisibility(View.GONE);
        bar.setVisibility(View.VISIBLE);
        String slug = getIntent().getStringExtra("slug");
        final String[] titles = new String[]{"动态", "文章", "更多"};
        final List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(UserTimeLineFragment.newInstance(slug));
        fragmentList.add(UserArticleFragment.newInstance(slug));
        fragmentList.add(new UserMoreFragment());
        viewPager.setAdapter(new FragmentStatePagerAdapter((getSupportFragmentManager())) {
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
                return fragmentList.size();
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
        UserPresenterCompl compl = new UserPresenterCompl(this);
        compl.getLatest(slug);
    }

    /*
    * 重新设置ViewPager的高度
    * 原因:ScrollView嵌套ViewPager不显示
    * */
    public void resetViewPagerHeight(int position) {
        View child = viewPager.getChildAt(position);
        if (child != null) {
            child.measure(0, 0);
            int h = child.getMeasuredHeight();
            LogUtil.d(TAG, h + "");
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewPager.getLayoutParams();
            params.height = h + 50;
            viewPager.setLayoutParams(params);
        }
    }

    @Override
    public void onGetLatest(UserLatest latest) {
        if (bar.getVisibility() == View.VISIBLE) {
//            root.setVisibility(View.VISIBLE);
            bar.setVisibility(View.GONE);
        }
        toolbar.setTitle(latest.getNickname());
        Glide.with(this)
                .load(latest.getAvatar())
                .placeholder(R.drawable.tx_image_1)
                .transform(new GlideGircleTransform(this))
                .into(avatar);
        if (("None").equals(latest.getAbout())) {
            about.setText("这家伙很懒,什么都没有留下");
        } else {
            about.setText(latest.getAbout().replace(' ', '\n'));
        }
        num.setText("写了" + latest.getWord_age() + "个字  " + "获得了" + latest.getLike_num() + "个喜欢");
        FragmentStatePagerAdapter adapter = (FragmentStatePagerAdapter) viewPager.getAdapter();
        UserArticleFragment articleFragment = (UserArticleFragment) adapter.instantiateItem(viewPager, 1);
        articleFragment.setArticles(latest);
        UserMoreFragment moreFragment = (UserMoreFragment) adapter.instantiateItem(viewPager, 2);
        moreFragment.setInfo(latest);
    }

    @Override
    public void onGetTop(UserTop top) {

    }

    @Override
    public void onGetTimeLine(UserTimeLine timeLine) {

    }

    @Override
    public void onGetFailed(int code) {
        switch (code) {
            case 404:
                ToastUtil.showToast(this, "真不巧呢，您所找的用户不存在。");
                finish();
                break;
            case 500:
                ToastUtil.showToast(this, "服务器出现了一点错误，请重新试一下");
                finish();
                break;
            default:
                break;
        }
    }
}
