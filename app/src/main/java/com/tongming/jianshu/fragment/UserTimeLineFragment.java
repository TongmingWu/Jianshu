package com.tongming.jianshu.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tongming.jianshu.R;
import com.tongming.jianshu.adapter.TimeLineAdapter;
import com.tongming.jianshu.base.BaseFragment;
import com.tongming.jianshu.bean.UserTimeLine;
import com.tongming.jianshu.presenter.TimeLinePresenterCompl;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/21.
 */
public class UserTimeLineFragment extends BaseFragment implements ITimeLineView {
    @BindView(R.id.rv_timeline)
    RecyclerView recyclerView;

    public static UserTimeLineFragment newInstance(String slug){
        UserTimeLineFragment fragment = new UserTimeLineFragment();
        Bundle bundle = new Bundle();
        bundle.putString("slug",slug);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_timeline;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    @Override
    protected void lazyLoad() {
        if (!isVisible || !isPrepared) {
            return;
        }
        if (!flag) {
            TimeLinePresenterCompl compl = new TimeLinePresenterCompl(this);
            compl.getTimeLine(getArguments().getString("slug"));
        }
    }

    @Override
    public void onGetTimeLine(UserTimeLine timeLine) {
        TimeLineAdapter adapter = new TimeLineAdapter(timeLine,getActivity());
        recyclerView.setAdapter(adapter);
    }
}
