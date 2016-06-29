package com.tongming.jianshu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.bean.UserTimeLine;
import com.tongming.jianshu.view.GlideGircleTransform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tongming on 2016/6/25.
 */
public class TimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final String CATEGORY_COMMENT = "comment";
    private final String CATEGORY_ISSUE = "issue";
    private final String CATEGORY_ATTENTION = "attention";
    private final String CATEGORY_LIKE_COMMENT = "like-comment";
    private UserTimeLine timeLine;
    private Context context;

    public TimeLineAdapter(UserTimeLine timeLine, Context context) {
        this.timeLine = timeLine;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_timeline, null);
        return new LineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LineViewHolder) {
            UserTimeLine.TrendsBean bean = timeLine.getTrends().get(position);
            Glide.with(context)
                    .load(bean.getAvatar())
                    .transform(new GlideGircleTransform(context))
                    .into(((LineViewHolder) holder).avatar);
            switch (bean.getCategory()) {
                case CATEGORY_COMMENT: //评论类型
                    ((LineViewHolder) holder).category.setImageResource(R.drawable.dt_icon_talk);
                    break;
                case CATEGORY_ISSUE:      //发表文章类型
                    ((LineViewHolder) holder).category.setImageResource(R.drawable.dt_icon_fabiao);
                    break;
                case CATEGORY_ATTENTION:   //关注/喜欢类型
                    ((LineViewHolder) holder).category.setImageResource(R.drawable.dt_icon_like);
                    break;
                case CATEGORY_LIKE_COMMENT: //喜欢的评论
                    ((LineViewHolder) holder).category.setImageResource(R.drawable.dt_icon_like);
                    break;
                default:
                    break;
            }
            String[] strings = bean.getAction().split(" ");
            strings[0] = "<font color=\"#33b5e5\">" + strings[0] + "</font> ";
            strings[2] = " <font color=\"#33b5e5\">" + strings[2] + "</font>";
            String all = "";
            for (String s : strings) {
                all += s;
            }
            ((LineViewHolder) holder).action.setText(Html.fromHtml(all));
            if (bean.getContent() != null) {
                if (!bean.getContent().trim().equals("")) {
                    ((LineViewHolder) holder).content.setVisibility(View.VISIBLE);
                    //TODO : 表情的问题
                    Pattern pattern = Pattern.compile("@.*? ");
                    Matcher m = pattern.matcher(bean.getContent());
                    if (m.find()) {
                        String content = bean.getContent().replace(m.group(0), "");
                        String reply = "<font color=\"#33b5e5\">" + m.group(0) + "</font> ";
                        ((LineViewHolder) holder).content.setText(Html.fromHtml(reply + content));
                    }
                    //((LineViewHolder) holder).content.setHtmlFromString(bean.getContent(),false);
                }
            }
            ((LineViewHolder) holder).date.setText(bean.getDate());
        }
    }

    @Override
    public int getItemCount() {
        return timeLine.getTrends().size();
    }

    class LineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_tl_avatar)
        ImageView avatar;
        @BindView(R.id.tl_category)
        ImageView category;
        /* @BindView(R.id.tv_timeline_author)
         TextView author;
         @BindView(R.id.tv_timeline_what)
         TextView what;*/
        @BindView(R.id.tv_timeline_action)
        TextView action;
        @BindView(R.id.tv_timeline_content)
        TextView content;
        @BindView(R.id.tv_timeline_date)
        TextView date;

        public LineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
