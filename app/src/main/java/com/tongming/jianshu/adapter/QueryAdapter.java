package com.tongming.jianshu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tongming.jianshu.R;

import java.util.Set;

/**
 * Created by Tongming on 2016/6/27.
 */
public class QueryAdapter extends BaseAdapter {
    private Set<String> querySet;
    private Context context;

    public QueryAdapter(Set<String> querySet, Context context) {
        this.querySet = querySet;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (querySet.size() < 5) {
            return querySet.size();
        } else {
            return 5;
        }
    }

    @Override
    public Object getItem(int position) {
        return querySet.toArray()[querySet.size() - position - 1];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*TextView textView = new TextView(context);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        lp.leftMargin = 15;
        lp.topMargin = 15;
        textView.setLayoutParams(lp);*/
        convertView = View.inflate(context, R.layout.item_query,null);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_item_query);
        Object[] array = querySet.toArray();
        textView.setText((String) array[array.length - position - 1]);
        return convertView;
    }
}
