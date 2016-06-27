package com.tongming.jianshu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.bean.Comment;
import com.tongming.jianshu.util.DMUtil;
import com.tongming.jianshu.view.GlideGircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tongming on 2016/6/26.
 */
public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Comment comment;
    private Context context;

    public CommentAdapter(Comment comment, Context context) {
        this.comment = comment;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_comment, null);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CommentViewHolder) {
            int index = getItemCount() - position - 1;
            Comment.ReviewListBean bean = comment.getReview_list().get(index);
            Glide.with(context)
                    .load(bean.getAvatar())
                    .transform(new GlideGircleTransform(context))
                    .into(((CommentViewHolder) holder).avatar);
            ((CommentViewHolder) holder).nickname.setText(bean.getAuthor());
            ((CommentViewHolder) holder).floor.setText(bean.getFloor() + "楼 · ");
            ((CommentViewHolder) holder).date.setText(bean.getDate());
            ((CommentViewHolder) holder).content.setText(bean.getContent());

            for (int i = 0; i < bean.getChild_list().size(); i++) {
                Comment.ReviewListBean.ChildListBean listBean = bean.getChild_list().get(i);

                //容器
                RelativeLayout inner = new RelativeLayout(context);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                );
                int scale = DMUtil.getScale(context, 10);
                params.topMargin = DMUtil.getScale(context, 10);
                params.addRule(RelativeLayout.BELOW, R.id.tv_comment_content);
                inner.setPadding(scale, scale, scale, scale);
                inner.setLayoutParams(params);

                //虚线
                TextView xuxian = new TextView(context);
                ViewGroup.LayoutParams line = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 3
                );
//                xuxian.setBackgroundResource(R.drawable.xuxian);
                xuxian.setLayoutParams(line);
                int xuxian_id = View.generateViewId();
                xuxian.setId(xuxian_id);
                inner.addView(xuxian);

                //内容
                TextView content = new TextView(context);
                RelativeLayout.LayoutParams con = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                con.topMargin = DMUtil.getScale(context, 10);
                String name = "<font color=\"#33b5e5\">" + listBean.getName() + "</font>";
                content.setText(Html.fromHtml(
                        name + "：" + listBean.getReplay()
                ));
                int content_id = View.generateViewId();
                content.setId(content_id);
                con.addRule(RelativeLayout.BELOW, xuxian_id);
                content.setLayoutParams(con);
                inner.addView(content);

                ((CommentViewHolder) holder).root.addView(inner);
            }

            /*if (bean.getChild_list().size() != 0) {
                ((CommentViewHolder) holder).inner.setVisibility(View.VISIBLE);
                String name = "<font color=\"#33b5e5\">" + bean.getChild_list().get(0).getName() + "</font>";
                ((CommentViewHolder) holder).inner_content.setText(Html.fromHtml(
                        name + "：" + bean.getChild_list().get(0).getReplay()
                ));
            }*/
        }
    }

    @Override
    public int getItemCount() {
        return comment.getResults();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_comment_avatar)
        ImageView avatar;
        @BindView(R.id.tv_comment_nickname)
        TextView nickname;
        @BindView(R.id.tv_comment_floor)
        TextView floor;
        @BindView(R.id.tv_comment_date)
        TextView date;
        @BindView(R.id.tv_comment_content)
        TextView content;
        /*@BindView(R.id.rl_inner_comment)
        RelativeLayout inner;
        @BindView(R.id.tv_inner_content)
        TextView inner_content;*/
        @BindView(R.id.rl_comment_root)
        LinearLayout root;

        public CommentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
