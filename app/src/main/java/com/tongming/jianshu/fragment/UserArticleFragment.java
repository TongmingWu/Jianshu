package com.tongming.jianshu.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.tongming.jianshu.R;
import com.tongming.jianshu.activity.ArticleDetailActivity;
import com.tongming.jianshu.adapter.ArticleRecylerViewAdapter;
import com.tongming.jianshu.adapter.onRecyclerViewItemClickListener;
import com.tongming.jianshu.base.BaseFragment;
import com.tongming.jianshu.bean.Article;
import com.tongming.jianshu.bean.UserLatest;
import com.tongming.jianshu.bean.UserTop;
import com.tongming.jianshu.presenter.UserPresenterCompl;
import com.tongming.jianshu.util.ToastUtil;
import com.tongming.jianshu.view.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/21.
 */
public class UserArticleFragment extends BaseFragment implements ITopView {
    private static final String TAG = UserArticleFragment.class.getSimpleName();
    private UserLatest articles;
    private UserTop top;
    @BindView(R.id.spinner)
    AppCompatSpinner spinner;
    @BindView(R.id.tv_article_num)
    TextView num;
    @BindView(R.id.rv_user_article)
    RecyclerView recyclerView;
    private ArticleRecylerViewAdapter adapter;
    private List<Article> articleList = new ArrayList<>();
    private List<Article> tempList = new ArrayList<>();
    private boolean isFirst = false;

    public static UserArticleFragment newInstance(String slug) {
        UserArticleFragment fragment = new UserArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("slug", slug);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initViews() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        if (!flag && articles != null) {
                            articleList.clear();
                            articleList.addAll(articles.getLatest_articles());
                            adapter.notifyDataSetChanged();
                        }
                        break;
                    case 1:
                        if (!isFirst) {
                            recyclerView.setVisibility(View.INVISIBLE);
                            UserPresenterCompl compl = new UserPresenterCompl(UserArticleFragment.this);
                            compl.getTop(getArguments().getString("slug"));
                            isFirst = true;
                        } else {
                            articleList.clear();
                            articleList.addAll(top.getHot_articles());
                            adapter.notifyDataSetChanged();
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.VERTICAL, 3, getResources().getColor(R.color.divide_gray)
        ));
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_article;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {
    }

    public void setArticles(UserLatest articles) {
        this.articles = articles;
        flag = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isVisible || !isPrepared) {
            return;
        }
        if (flag) {
            articleList.addAll(articles.getLatest_articles());
            num.setText("文章(" + articles.getArticle_num() + ")");
            adapter = new ArticleRecylerViewAdapter(getActivity(), articleList);
            adapter.setOnItemClickListener(new onRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, String slug) {
                    Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
                    intent.putExtra("slug", slug);
                    getActivity().startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                }
            });
            recyclerView.setAdapter(adapter);
            flag = false;
        }
    }

    @Override
    public void onGetTop(UserTop top) {
        this.top = top;
        recyclerView.setVisibility(View.VISIBLE);
        ToastUtil.showToast(getActivity(), "加载热门文章成功");
        if (articleList != null && articleList.size() > 0) {
            articleList.clear();
            articleList.addAll(top.getHot_articles());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailed() {
        ToastUtil.showToast(getActivity(), "加载出错");
    }
}
