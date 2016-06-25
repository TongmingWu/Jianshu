package com.tongming.jianshu.fragment;

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
import com.tongming.jianshu.bean.UserLatest;
import com.tongming.jianshu.view.RecyclerViewDivider;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/21.
 */
public class UserArticleFragment extends BaseFragment {
    private static final String TAG = UserArticleFragment.class.getSimpleName();
    private UserLatest articles;
    @BindView(R.id.spinner)
    AppCompatSpinner spinner;
    @BindView(R.id.tv_article_num)
    TextView num;
    @BindView(R.id.rv_user_article)
    RecyclerView recyclerView;

    @Override
    protected void initViews() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

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
            num.setText("文章(" + articles.getArticle_num() + ")");
            ArticleRecylerViewAdapter adapter = new ArticleRecylerViewAdapter(getActivity(), articles.getLatest_articles());
            adapter.setOnItemClickListener(new onRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, String slug) {
                    Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
                    intent.putExtra("slug", slug);
                    getActivity().startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapter);
            flag = false;
        }
    }
}
