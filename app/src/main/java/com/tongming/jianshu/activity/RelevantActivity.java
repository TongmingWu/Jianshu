package com.tongming.jianshu.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tongming.jianshu.R;
import com.tongming.jianshu.adapter.HeaderAndFooterRecyclerViewAdapter;
import com.tongming.jianshu.adapter.RelevantAdapter;
import com.tongming.jianshu.adapter.onRecyclerViewItemClickListener;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.bean.SearchResult;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/19.
 */
public class RelevantActivity extends BaseActivity {
    String TAG = RelevantActivity.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_relevant)
    RecyclerView recyclerView;

    private SearchResult.UsersBean users;
    private SearchResult.CollectionsBean collections;
    private SearchResult.NotebooksBean notebooks;
    private RelevantAdapter adapter;
    private TextView footer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_relevant;
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        Parcelable extra = intent.getParcelableExtra("list");
        if (extra instanceof SearchResult.UsersBean) {
            this.users = (SearchResult.UsersBean) extra;
            toolbar.setTitle("相关用户");
            adapter = new RelevantAdapter(users, this);
            adapter.setItemClickListener(new onRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, String slug) {
                    Intent i = new Intent(RelevantActivity.this, UserActivity.class);
                    i.putExtra("slug", slug);
                    startActivity(i, ActivityOptions.makeSceneTransitionAnimation(RelevantActivity.this).toBundle());
                }
            });
        } else if (extra instanceof SearchResult.CollectionsBean) {
            this.collections = (SearchResult.CollectionsBean) extra;
            toolbar.setTitle("相关专题");
            adapter = new RelevantAdapter(collections, this);
            adapter.setItemClickListener(new onRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, String slug) {
                    Intent i = new Intent(RelevantActivity.this, TopicDetailActivity.class);
                    i.putExtra("slug", slug);
                    startActivity(i,ActivityOptions.makeSceneTransitionAnimation(RelevantActivity.this).toBundle());
                }
            });
        } else {
            this.notebooks = (SearchResult.NotebooksBean) extra;
            toolbar.setTitle("相关文集");
            adapter = new RelevantAdapter(notebooks, this);
            adapter.setItemClickListener(new onRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, String slug) {

                }
            });
        }
        final HeaderAndFooterRecyclerViewAdapter footerAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        footer = new TextView(this);
        footer.setText("--  end  --");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        WindowManager manager = getWindowManager();
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        params.leftMargin = metrics.widthPixels / 2 - 46;   //92为footer的测量宽度
        footer.setLayoutParams(params);
        footerAdapter.addFooterView(footer);
        recyclerView.setAdapter(footerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
