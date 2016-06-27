package com.tongming.jianshu.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.tongming.jianshu.R;
import com.tongming.jianshu.adapter.CommentAdapter;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.bean.Comment;
import com.tongming.jianshu.presenter.CommentPresenterCompl;
import com.tongming.jianshu.util.ToastUtil;
import com.tongming.jianshu.view.RecyclerViewDivider;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/26.
 */
public class CommentActivity extends BaseActivity implements ICommentView {
    String TAG = CommentActivity.class.getSimpleName();
    @BindView(R.id.rv_comment)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.progressbar)
    ProgressBar bar;
    private CommentPresenterCompl compl;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_comment;
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
        bar.setVisibility(View.VISIBLE);
        compl = new CommentPresenterCompl(this);
        compl.getComment(getIntent().getStringExtra("nid"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerViewDivider(
                this, LinearLayoutManager.VERTICAL, 3, getResources().getColor(R.color.divide_gray)
        ));
    }

    @Override
    public void onGetComment(Comment comment) {
        if (bar.getVisibility() == View.VISIBLE) {
            bar.setVisibility(View.GONE);
        }
        CommentAdapter adapter = new CommentAdapter(comment, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailed(int code) {
        ToastUtil.showToast(this, "加载失败");
        compl.getComment(getIntent().getStringExtra("nid"));
        ToastUtil.showToast(this, "正在重新加载");
    }
}
