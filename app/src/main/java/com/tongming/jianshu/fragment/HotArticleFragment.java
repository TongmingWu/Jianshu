package com.tongming.jianshu.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.adapter.ArticleRecylerViewAdapter;
import com.tongming.jianshu.adapter.HeaderAndFooterRecyclerViewAdapter;
import com.tongming.jianshu.base.BaseFragment;
import com.tongming.jianshu.bean.ArticleList;
import com.tongming.jianshu.presenter.ArticlePresenterCompl;
import com.tongming.jianshu.util.RecyclerViewUtil;
import com.tongming.jianshu.util.ToastUtil;
import com.tongming.jianshu.view.RecyclerViewDivider;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/5/21.
 */
public class HotArticleFragment extends BaseFragment implements IArticleView {

    private static final String TAG = "HOT";
    private boolean isPrepared = false;
    private boolean flag = false;

    @BindView(R.id.hot_swipe)
    SwipeRefreshLayout refreshLayout;
    /*@BindView(R.id.banner)
    ConvenientBanner banner;*/
    @BindView(R.id.rv_hot)
    RecyclerView recyclerView;
    private ArticleRecylerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ButterKnife.bind(this, mRootView);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.VERTICAL, 5, getResources().getColor(R.color.divide_gray)
        ));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article_hot;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {
        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        if (!flag) {
            refreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    refreshLayout.setRefreshing(true);
                }
            });
            ArticlePresenterCompl compl = new ArticlePresenterCompl(this);
            compl.getHotArticle();
            flag = true;
        }
    }

    @Override
    public void onGetArticle(ArticleList list) {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        });

        adapter = new ArticleRecylerViewAdapter(getActivity(), list);
        //点击文章的事件监听
        adapter.setOnItemClickListener(new ArticleRecylerViewAdapter.onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String slug) {
                ToastUtil.showToast(getActivity(), slug);

            }
        });
        //添加header
        HeaderAndFooterRecyclerViewAdapter mAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        recyclerView.setAdapter(mAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ConvenientBanner banner = (ConvenientBanner) View.inflate(getActivity(), R.layout.item_banner, null);
        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new Holder<String>() {
                    private ImageView imageView;

                    @Override
                    public View createView(Context context) {
                        imageView = new ImageView(context);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        return imageView;
                    }

                    @Override
                    public void UpdateUI(Context context, int position, String data) {
                        Glide.with(context).load(data).into(imageView);
                    }
                };
            }
        }, list.getBanner()).setPageIndicator(new int[]{R.drawable.point_bg_normal, R.drawable.point_bg_enable})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        banner.setCanLoop(true);
        final float scale = getActivity().getResources().getDisplayMetrics().density;
        int height = (int) (180 * scale + 0.5f);
        banner.setLayoutParams(new LinearLayoutCompat.LayoutParams(getActivity().getWindowManager().getDefaultDisplay().getWidth(), height));
        RecyclerViewUtil.setHeaderView(recyclerView, banner);

    }
}
