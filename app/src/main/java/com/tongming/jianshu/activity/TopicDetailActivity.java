package com.tongming.jianshu.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.adapter.ArticleRecylerViewAdapter;
import com.tongming.jianshu.adapter.onRecyclerViewItemClickListener;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.bean.ColDetail;
import com.tongming.jianshu.presenter.TopicDetailPreCompl;
import com.tongming.jianshu.view.GlideGircleTransform;
import com.tongming.jianshu.view.RecyclerViewDivider;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/14.
 */
public class TopicDetailActivity extends BaseActivity implements ITopicDetailView {
    @BindView(R.id.tl_detail)
    Toolbar toolbar;
    @BindView(R.id.iv_avatar_topic)
    ImageView avatar;
    @BindView(R.id.topic_title)
    TextView title;
    @BindView(R.id.topic_num)
    TextView num;
    @BindView(R.id.topic_admin)
    TextView admin;
    @BindView(R.id.topic_collection)
    TextView collection;
    @BindView(R.id.topic_desc)
    TextView desc;
    @BindView(R.id.rv_topic_detail)
    RecyclerView recyclerView;
    @BindView(R.id.rl_root)
    LinearLayout root;
    @BindView(R.id.progressbar)
    ProgressBar bar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_topic_detail;
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
        recyclerView.addItemDecoration(new RecyclerViewDivider(
                this, LinearLayoutManager.VERTICAL, 3, getResources().getColor(R.color.divide_gray)
        ));
        recyclerView.setNestedScrollingEnabled(false);
        bar.setVisibility(View.VISIBLE);
        TopicDetailPreCompl compl = new TopicDetailPreCompl(this);
        compl.getTopicDetail(getIntent().getStringExtra("slug"));
    }

    @Override
    public void onGetDetail(ColDetail colDetail) {
        if(bar.getVisibility()==View.VISIBLE&&root.getVisibility()==View.GONE){
            root.setVisibility(View.VISIBLE);
            bar.setVisibility(View.GONE);
        }
        Glide.with(this)
                .load(colDetail.getTopic_avatar())
                .placeholder(R.drawable.tx_image_1)
                .transform(new GlideGircleTransform(this)).into(avatar);
        title.setText(colDetail.getTitle());
        admin.setText(colDetail.getAdmin_list().get(0));
        collection.setText(" + 关注 | " + colDetail.getFollow_num());
        num.setText("编 " + colDetail.getArticle_num() + "篇文章");
        desc.setText(Html.fromHtml(colDetail.getDesc()));
        ArticleRecylerViewAdapter adapter = new ArticleRecylerViewAdapter(this, colDetail.getArticle_list());
        adapter.setOnItemClickListener(new onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String slug) {
                Intent intent = new Intent(TopicDetailActivity.this, ArticleDetailActivity.class);
                intent.putExtra("slug", slug);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
