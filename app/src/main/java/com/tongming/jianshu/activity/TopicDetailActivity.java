package com.tongming.jianshu.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.bean.ColDetail;
import com.tongming.jianshu.presenter.TopicDetailPreCompl;
import com.tongming.jianshu.view.GlideGircleTransform;

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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_topic_detail;
    }

    @Override
    public void initViews() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        TopicDetailPreCompl compl = new TopicDetailPreCompl(this);
        compl.getTopicDetail(getIntent().getStringExtra("slug"));
    }

    @Override
    public void onGetDetail(ColDetail colDetail) {
        root.setVisibility(View.VISIBLE);
        Glide.with(this).load(colDetail.getTopic_avatar()).placeholder(R.drawable.tx_image_1).transform(new GlideGircleTransform(this)).into(avatar);
        title.setText(colDetail.getTitle());
        admin.setText(colDetail.getAdmin_list().get(0));
        collection.setText(" + 关注 | " + colDetail.getFollow_num());
        num.setText("编 " + colDetail.getArticle_num() + "篇文章");
        desc.setText(Html.fromHtml(colDetail.getDesc()));
    }
}
