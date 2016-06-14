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
import com.tongming.jianshu.bean.Collection;
import com.tongming.jianshu.view.GlideGircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tongming on 2016/6/13.
 */
public class TopicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context context;
    private Collection collection;
    private LayoutInflater inflater;
    private onRecyclerViewItemClickListener itemClickListener = null;

    public TopicAdapter(Context context, Collection collection) {
        this.context = context;
        this.collection = collection;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_topic, parent, false);
        view.setOnClickListener(this);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopicViewHolder) {
            Collection.ResultsBean bean = collection.getResults().get(position);
            holder.itemView.setTag(bean.getSlug());
            Glide.with(context)
                    .load(bean.getAvatar())
                    .placeholder(R.drawable.tx_image_3)
                    .transform(new GlideGircleTransform(context))
                    .into(((TopicViewHolder) holder).iv);
            ((TopicViewHolder) holder).author.setText(bean.getTitle());
            ((TopicViewHolder) holder).article_num.setText(bean.getArticle_num() + "篇文章·");
            ((TopicViewHolder) holder).att_num.setText(bean.getAtt_num() + "人关注");
            ((TopicViewHolder) holder).desc.setText(bean.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return collection.getResults().size();
    }

    @Override
    public void onClick(View v) {
        if (itemClickListener != null) {
            itemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    public void setItemClickListener(onRecyclerViewItemClickListener listener) {
        this.itemClickListener = listener;
    }

    class TopicViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_topic)
        ImageView iv;
        @BindView(R.id.topic_author)
        TextView author;
        @BindView(R.id.topic_article_num)
        TextView article_num;
        @BindView(R.id.topic_attention_num)
        TextView att_num;
        @BindView(R.id.topic_desc)
        TextView desc;

        public TopicViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
