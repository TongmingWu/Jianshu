package com.tongming.jianshu.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tongming.jianshu.R;
import com.tongming.jianshu.adapter.GridAdapter;
import com.tongming.jianshu.adapter.SearchRecAdapter;
import com.tongming.jianshu.adapter.onRecyclerViewItemClickListener;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.bean.SearchResult;
import com.tongming.jianshu.presenter.SearchPresenterCompl;
import com.tongming.jianshu.util.ToastUtil;
import com.tongming.jianshu.view.RecyclerViewDivider;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/18.
 */
public class SearchActivity extends BaseActivity implements ISearchView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rl_user)
    RelativeLayout rl_user;
    @BindView(R.id.rl_collection)
    RelativeLayout rl_collection;
    @BindView(R.id.cv_notebooks)
    CardView notebooks;
    @BindView(R.id.gv_user)
    GridView gv_user;
    @BindView(R.id.gv_collection)
    GridView gv_collection;
    @BindView(R.id.tv_load_all)
    TextView load_all;
    @BindView(R.id.rv_search)
    RecyclerView recyclerView;
    @BindView(R.id.ll_root)
    LinearLayout root;
    @BindView(R.id.progressbar)
    ProgressBar bar;

    private static final String TAG = SearchActivity.class.getSimpleName();
    private SearchPresenterCompl compl;
    private String query;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        handleIntent(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        /*String query = intent.getStringExtra(SearchManager.QUERY);
        SearchRecentSuggestions suggestions = new SearchRecentSuggestions(
                this, SearchSuggestionProvider.AUTHORITY, SearchSuggestionProvider.MODE
        );
        suggestions.saveRecentQuery(query, null);*/
        query = getIntent().getStringExtra("query");
        toolbar.setTitle("搜索：" + query);
        root.setVisibility(View.GONE);
        if (bar.getVisibility() == View.GONE) {
            bar.setVisibility(View.VISIBLE);
        }
        compl = new SearchPresenterCompl(this);
        compl.search(query);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initViews() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerViewDivider(
                this, LinearLayoutManager.VERTICAL, 3, getResources().getColor(R.color.divide_gray)
        ));
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void onSearch(final SearchResult result) {
        if (root.getVisibility() == View.GONE && bar.getVisibility() == View.VISIBLE) {
            root.setVisibility(View.VISIBLE);
            bar.setVisibility(View.GONE);
        }
        final SearchResult.UsersBean users = result.getUsers();
        final SearchResult.CollectionsBean collections = result.getCollections();
        SearchResult.NotesBean notes = result.getNotes();
        gv_user.setAdapter(new GridAdapter(this, users));
        gv_collection.setAdapter(new GridAdapter(this, collections));
        SearchRecAdapter recAdapter = new SearchRecAdapter(this, notes);
        recAdapter.setItemClickListener(new onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String slug) {
                Intent intent = new Intent(SearchActivity.this, ArticleDetailActivity.class);
                intent.putExtra("slug", slug);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SearchActivity.this).toBundle());
            }
        });
        recyclerView.setAdapter(recAdapter);
        //获取更多用户信息
        rl_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, RelevantActivity.class);
                intent.putExtra("list", users);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SearchActivity.this).toBundle());
            }
        });
        //获取更多专题信息
        rl_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, RelevantActivity.class);
                intent.putExtra("list", collections);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SearchActivity.this).toBundle());
            }
        });
        //获取文集信息
        notebooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, RelevantActivity.class);
                intent.putExtra("list", result.getNotebooks());
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SearchActivity.this).toBundle());
            }
        });
        gv_user.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String slug = users.getEntries().get(position).getSlug();
                Intent intent = new Intent(SearchActivity.this, UserActivity.class);
                intent.putExtra("slug", slug);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SearchActivity.this).toBundle());
            }
        });
        gv_collection.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String slug = collections.getEntries().get(position).getSlug();
                Intent intent = new Intent(SearchActivity.this, TopicDetailActivity.class);
                intent.putExtra("slug", slug);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SearchActivity.this).toBundle());
            }
        });
    }

    @Override
    public void onFailed(int code) {
        ToastUtil.showToast(this, "搜索失败");
        compl.search(query);
        ToastUtil.showToast(this, "正在重新搜索");
    }
}
