package com.tongming.jianshu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tongming.jianshu.R;
import com.tongming.jianshu.bean.SearchResult;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tongming on 2016/6/19.
 */
public class SearchRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private SearchResult.NotesBean notes;
    private Context context;
    private onRecyclerViewItemClickListener itemClickListener = null;

    public SearchRecAdapter(Context context, SearchResult.NotesBean notes) {
        this.notes = notes;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_search_note, null);
        view.setOnClickListener(this);
        return new CusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CusViewHolder) {
            SearchResult.NotesBean.EntriesBean bean = notes.getEntries().get(position);
            holder.itemView.setTag(bean.getSlug());
            ((CusViewHolder) holder).title.setText(Html.fromHtml(bean.getTitle()));
            ((CusViewHolder) holder).content.setText(Html.fromHtml(bean.getContent()));
        }
    }

    @Override
    public int getItemCount() {
        if (notes.getTotal_count() < 3) {
            return notes.getTotal_count();
        } else {
            return 3;
        }
    }

    public void setItemClickListener(onRecyclerViewItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (itemClickListener != null) {
            itemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    class CusViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView title;
        @BindView(R.id.item_content)
        TextView content;

        public CusViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
