package com.tongming.jianshu.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tongming.jianshu.R;
import com.tongming.jianshu.activity.TopicDetailActivity;
import com.tongming.jianshu.adapter.HeaderAndFooterRecyclerViewAdapter;
import com.tongming.jianshu.adapter.TopicAdapter;
import com.tongming.jianshu.adapter.onRecyclerViewItemClickListener;
import com.tongming.jianshu.base.BaseFragment;
import com.tongming.jianshu.bean.Collection;
import com.tongming.jianshu.presenter.TopicPresenterCompl;
import com.tongming.jianshu.util.RecyclerViewUtil;
import com.tongming.jianshu.util.ToastUtil;
import com.tongming.jianshu.view.RecyclerViewDivider;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/13.
 */
public class TopicDetailFragment extends BaseFragment implements ITopicView {
    private int type;
    @BindView(R.id.rv_topic)
    RecyclerView recyclerView;
    @BindView(R.id.srl_topic)
    SwipeRefreshLayout refreshLayout;
    boolean flag;
    private TopicPresenterCompl compl;

    public static TopicDetailFragment getInstance(int type) {
        TopicDetailFragment fragment = new TopicDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initViews() {
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
        recyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.VERTICAL, 3, getResources().getColor(R.color.divide_gray)
        ));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_topic_detail;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    @Override
    protected void lazyLoad() {
        if (!isVisible || !isPrepared) {
            return;
        }
        if (!flag) {
            refreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    refreshLayout.setRefreshing(true);
                }
            });
            compl = new TopicPresenterCompl(this);
            type = getArguments().getInt("type");
            compl.getCollections(type);
        }
    }

    @Override
    public void onGetCollections(final Collection collection) {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        });
        TopicAdapter topicAdapter = new TopicAdapter(getActivity(), collection);
        topicAdapter.setItemClickListener(new onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String slug) {
                Intent intent = new Intent(getActivity(), TopicDetailActivity.class);
                intent.putExtra("slug", slug);
                getActivity().startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
            }
        });
        HeaderAndFooterRecyclerViewAdapter viewAdapter = new HeaderAndFooterRecyclerViewAdapter(topicAdapter);
        recyclerView.setAdapter(viewAdapter);
        if (type == 53) {
            View view = View.inflate(getActivity(), R.layout.header_topic, null);
            RecyclerViewUtil.setHeaderView(recyclerView, view);
//            recyclerView.setAdapter(topicAdapter);//测试
        }
    }

    @Override
    public void onFailed(int code) {
        ToastUtil.showToast(getActivity(), "请求失败");
        compl.getCollections(type);
        ToastUtil.showToast(getActivity(), "正在重新请求");
    }
}
