package com.tongming.jianshu.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseFragment;
import com.tongming.jianshu.bean.UserLatest;
import com.tongming.jianshu.view.LineOption;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/21.
 */
public class UserMoreFragment extends BaseFragment {
    @BindView(R.id.tv_wenji_num)
    TextView wenji;
    @BindView(R.id.tv_zhuanti_num)
    TextView collection;
    @BindView(R.id.tv_guanzhu_num)
    TextView attention;
    @BindView(R.id.tv_fans_num)
    TextView fans;
    @BindView(R.id.tv_address)
    TextView address;
    @BindView(R.id.lo_like)
    LineOption like;
    @BindView(R.id.lo_collection)
    LineOption lo_collection;
    @BindView(R.id.lo_wenji)
    LineOption lo_wenji;

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_more;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {
    }

    public void setInfo(UserLatest latest) {
        wenji.setText("文集 "+latest.getCollections().size());
        collection.setText("专题 "+latest.getBooks().size());
        fans.setText("粉丝 " + latest.getFollower_num());
        attention.setText("关注 "+latest.getSubscription_num());
        address.setText("http://www.jianshu.com/users/"+latest.getSlug()+"/latest_articles");
        like.setNum(latest.getLike_num());
        lo_collection.setNum(latest.getCollection_num()+"");
        lo_wenji.setNum(latest.getNotebook_num()+"");
    }

    @Override
    protected void lazyLoad() {

    }
}
