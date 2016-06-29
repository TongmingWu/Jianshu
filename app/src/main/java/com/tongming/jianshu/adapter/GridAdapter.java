package com.tongming.jianshu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.bean.SearchResult;
import com.tongming.jianshu.view.GlideGircleTransform;

/**
 * Created by Tongming on 2016/6/19.
 */
public class GridAdapter extends BaseAdapter {
    private SearchResult.UsersBean users;
    private SearchResult.CollectionsBean collections;
    private Context context;

    public GridAdapter(Context context, SearchResult.UsersBean users) {
        this.context = context;
        this.users = users;
    }

    public GridAdapter(Context context, SearchResult.CollectionsBean collections) {
        this.context = context;
        this.collections = collections;
    }

    @Override
    public int getCount() {
        if (users != null && users.getTotal_count() < 4) {
            return users.getTotal_count();
        } else if (collections != null && collections.getTotal_count() < 4) {
            return collections.getTotal_count();
        } else {
            return 4;
        }
    }

    @Override
    public Object getItem(int position) {
        if (users != null) {
            return users.getEntries().get(position);
        } else {
            return collections.getEntries().get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_grid, null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_avatar);
        TextView textView = (TextView) convertView.findViewById(R.id.item_desc);
        if (users != null) {
            Glide.with(context)
                    .load(users.getEntries().get(position).getAvatar_url())
                    .transform(new GlideGircleTransform(context))
                    .placeholder(R.drawable.tx_image_1)
                    .into(imageView);
            textView.setText(users.getEntries().get(position).getNickname());
        } else {
            Glide.with(context)
                    .load(collections.getEntries().get(position).getAvatar())
                    .transform(new GlideGircleTransform(context))
                    .placeholder(R.drawable.tx_image_1)
                    .into(imageView);
            textView.setText(collections.getEntries().get(position).getTitle());
        }
        return convertView;
    }
}
