package com.tongming.jianshu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.bean.ArticleList;
import com.tongming.jianshu.view.GlideGircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tongming on 2016/5/21.
 */
public class ArticleRecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private LayoutInflater layoutInflater;
    private ArticleList list;

    public ArticleRecylerViewAdapter(Context context, ArticleList list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new CusViewHolder(layoutInflater.inflate(R.layout.item_article, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof CusViewHolder) {
            if (holder instanceof CusViewHolder) {
                ArticleList.ResultsBean bean = list.getResults().get(position);
                String time = bean.getDate().split(" ")[1];
                Glide.with(context).load(bean.getAvatar()).transform(new GlideGircleTransform(context)).into(((CusViewHolder) holder).avatar);
                Glide.with(context).load(bean.getImg()).into(((CusViewHolder) holder).cover);
                ((CusViewHolder) holder).author.setText(bean.getAuthor());
                ((CusViewHolder) holder).created.setText(time);
                ((CusViewHolder) holder).desc.setText(bean.getTitle());
                ((CusViewHolder) holder).count.setText(bean.getRead()
                        + "次阅读·" + bean.getComment() + "评论·" + bean.getFav() + "喜欢");
            }
        }
    }


    @Override
    public int getItemCount() {
        return list.getCount();
    }


    class CusViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.tv_author)
        TextView author;
        @BindView(R.id.tv_create_at)
        TextView created;
        @BindView(R.id.tv_desc)
        TextView desc;
        @BindView(R.id.tv_count)
        TextView count;
        @BindView(R.id.cover)
        ImageView cover;
//        @BindView(R.id.banner)
//        ConvenientBanner banner;

        public CusViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
