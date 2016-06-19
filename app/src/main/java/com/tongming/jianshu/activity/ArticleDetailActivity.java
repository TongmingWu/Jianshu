package com.tongming.jianshu.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.base.BaseApplication;
import com.tongming.jianshu.bean.Detail;
import com.tongming.jianshu.presenter.DetailPresenterCompl;
import com.tongming.jianshu.view.GlideGircleTransform;
import com.tongming.jianshu.view.HtmlTextView;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/5/22.
 */
public class ArticleDetailActivity extends BaseActivity implements IDetailView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_avatar)
    ImageView avatar;
    @BindView(R.id.tv_author)
    TextView author;
    @BindView(R.id.tv_date)
    TextView date;
    @BindView(R.id.tv_content)
    HtmlTextView content;
    @BindView(R.id.author_date)
    TextView author_date;
    @BindView(R.id.tv_comment_count)
    TextView comment_count;
    @BindView(R.id.tv_like_count)
    TextView like_count;
    @BindView(R.id.sl_content)
    ScrollView scrollView;
    @BindView(R.id.progressbar)
    ProgressBar bar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
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
        scrollView.setVisibility(View.GONE);
        bar.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        String slug = intent.getStringExtra("slug");
        DetailPresenterCompl compl = new DetailPresenterCompl(this);
        compl.getDetail(slug);
    }

    @Override
    public void onGetDetail(Detail detail) {
        if (scrollView.getVisibility() == View.GONE && bar.getVisibility() == View.VISIBLE) {
            scrollView.setVisibility(View.VISIBLE);
            bar.setVisibility(View.GONE);
        }
        Glide.with(this).load(detail.getAuthor().getAvatar()).placeholder(R.drawable.tx_image_1).transform(new GlideGircleTransform(this)).into(avatar);
        author.setText(detail.getAuthor().getNickname());
        date.setText(detail.getArticle().getCreated_at());
        content.setHtmlFromString(detail.getArticle().getContent(), false);
        author_date.setText("由" + detail.getAuthor().getNickname() + "于" + detail.getArticle().getCreated_at() + "创作");
        comment_count.setText(detail.getArticle().getComments_count() + "");
        like_count.setText(detail.getArticle().getLikes_count() + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.imageLoader.clearMemoryCache();
    }
}
