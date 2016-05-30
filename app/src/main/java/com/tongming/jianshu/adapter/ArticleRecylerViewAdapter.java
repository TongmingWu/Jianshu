package com.tongming.jianshu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.bean.ArticleList;
import com.tongming.jianshu.view.GlideGircleTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tongming on 2016/5/21.
 */
public class ArticleRecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {


    private Context context;
    private LayoutInflater layoutInflater;
    private List<ArticleList.ResultsBean> list;

    private onRecyclerViewItemClickListener itemClickListener = null;

    public ArticleRecylerViewAdapter(Context context, List<ArticleList.ResultsBean> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }


    public List<ArticleList.ResultsBean> getList(){
        return this.list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_article, parent, false);
        view.setOnClickListener(this);
        return new CusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof CusViewHolder) {
            if (holder instanceof CusViewHolder) {
                ArticleList.ResultsBean bean = list.get(position);
                holder.itemView.setTag(bean.getSlug());
                String time = bean.getDate().split(" ")[1];
                final float scale = context.getResources().getDisplayMetrics().density;
                int width = (int) (220 * scale + 0.5f);
                int height = (int) (110 * scale + 0.5f);

                if (bean.getImg() != null) {
//                    LogUtil.d(ArticleRecylerViewAdapter.class.getSimpleName(), "position = " + position + " img = " + bean.getImg());
                    ImageView imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                            (int) (90 * scale + 0.5f), (int) (90 * scale + 0.5f));
                    params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    params.addRule(RelativeLayout.CENTER_VERTICAL);
                    imageView.setLayoutParams(params);
                    ((CusViewHolder) holder).relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(width,
                            height));
                    Glide.with(context).load(bean.getImg()).into(imageView);
                    ((CusViewHolder) holder).root.addView(imageView);
                } else {
                    //LogUtil.d(ArticleRecylerViewAdapter.class.getSimpleName(), "position = " + position + " img = " + bean.getImg());
                }
                Glide.with(context).load(bean.getAvatar()).transform(new GlideGircleTransform(context)).into(((CusViewHolder) holder).avatar);
                ((CusViewHolder) holder).author.setText(bean.getAuthor());
                ((CusViewHolder) holder).created.setText(time);
                ((CusViewHolder) holder).desc.setText(bean.getTitle());
                ((CusViewHolder) holder).count.setText(bean.getRead()
                        + "次阅读 · " + bean.getComment() + "评论 · " + bean.getFav() + "喜欢");
            }
        }
    }

    @Override
    public void onClick(View v) {
        //点击文章时需要的数据为slug
        if (itemClickListener != null) {
            //使用getTag获取数据
            itemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    public void setOnItemClickListener(onRecyclerViewItemClickListener listener) {
        this.itemClickListener = listener;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static interface onRecyclerViewItemClickListener {
        void onItemClick(View view, String slug);
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
        /*@BindView(R.id.cover)
        ImageView cover;*/
        @BindView(R.id.rl_item_content)
        RelativeLayout relativeLayout;
        @BindView(R.id.rl_root)
        RelativeLayout root;

        public CusViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
