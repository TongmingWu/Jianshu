package com.tongming.jianshu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.bean.SearchResult;
import com.tongming.jianshu.view.GlideGircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tongming on 2016/6/19.
 */
public class RelevantAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private SearchResult.UsersBean users = null;
    private SearchResult.CollectionsBean collections = null;
    private SearchResult.NotebooksBean notebooks = null;
    private Context context;

    public RelevantAdapter(SearchResult.NotebooksBean notebooks, Context context) {
        this.context = context;
        this.notebooks = notebooks;
    }

    public RelevantAdapter(SearchResult.CollectionsBean collections, Context context) {
        this.collections = collections;
        this.context = context;
    }

    public RelevantAdapter(SearchResult.UsersBean users, Context context) {
        this.users = users;
        this.context = context;
    }

    onRecyclerViewItemClickListener listener = null;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item_relevant,null);
        view.setOnClickListener(this);
        return new RelevantHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RelevantHolder) {
            if (users != null) {
                SearchResult.UsersBean.EntriesBean user = users.getEntries().get(position);
                holder.itemView.setTag(user.getSlug());
                ((RelevantHolder) holder).title.setText(user.getNickname());
                ((RelevantHolder) holder).desc.setText("写了" + user.getTotal_wordage() + "字  " + "获得了" + user.getTotal_likes_count() + "个喜欢");
                Glide.with(context)
                        .load(user.getAvatar_url())
                        .placeholder(R.drawable.tx_image_1)
                        .transform(new GlideGircleTransform(context))
                        .into(((RelevantHolder) holder).avatar);
            } else if (collections != null) {
                SearchResult.CollectionsBean.EntriesBean collection = collections.getEntries().get(position);
                holder.itemView.setTag(collection.getSlug());
                ((RelevantHolder) holder).title.setText(collection.getTitle());
                ((RelevantHolder) holder).desc.setText(collection.getEditors().get(0).getNickname() + " · " +
                        collection.getPublic_notes_count() + "篇文章 · " + collection.getLikes_count() + "人");
                Glide.with(context)
                        .load(collection.getAvatar())
                        .placeholder(R.drawable.tx_image_1)
                        .transform(new GlideGircleTransform(context))
                        .into(((RelevantHolder) holder).avatar);
            } else {
                SearchResult.NotebooksBean.EntriesBean notebook = notebooks.getEntries().get(position);
                holder.itemView.setTag(notebook.getId());
                ((RelevantHolder) holder).title.setText(notebook.getName());
                ((RelevantHolder) holder).desc.setText(notebook.getUser().getNickname() + " · " +
                        notebook.getPublic_notes_count() + "篇文章 · " + notebook.getSubscribers_count() + "人");
                Glide.with(context)
                        .load(R.drawable.wenji_icon_for_search)
                        .transform(new GlideGircleTransform(context))
                        .into(((RelevantHolder) holder).avatar);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (users != null) {
            return users.getEntries().size();
        } else if (collections != null) {
            return collections.getEntries().size();
        } else {
            return notebooks.getEntries().size();
        }
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onItemClick(v, (String) v.getTag());
        }
    }

    public void setItemClickListener(onRecyclerViewItemClickListener listener) {
        this.listener = listener;
    }

    class RelevantHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.desc)
        TextView desc;

        public RelevantHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
