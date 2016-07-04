package com.tongming.jianshu.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseFragment;
import com.tongming.jianshu.bean.LoginUser;
import com.tongming.jianshu.util.LogUtil;
import com.tongming.jianshu.view.GlideGircleTransform;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/5/25.
 */
public class MineFragment extends BaseFragment {
    private static final String TAG = MineFragment.class.getSimpleName();
    @BindView(R.id.rl_login)
    RelativeLayout login;
    @BindView(R.id.mine_avatar)
    ImageView avatar;
    @BindView(R.id.mine_nickname)
    TextView nickname;
    private SharedPreferences sp;

    public static MineFragment newInstance(LoginUser user) {
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("user", user);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initViews() {
        sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        final boolean isLogin = sp.getBoolean("isLogin", false);
        if (isLogin) {
            LoginUser user = getArguments().getParcelable("user");
            Glide.with(this)
                    .load(user.getLatest().getAvatar())
                    .transform(new GlideGircleTransform(getActivity()))
                    .into(avatar);
            nickname.setText(user.getLatest().getNickname());
        }
        //登录注册功能尚未完成
        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                            getActivity()
                    ).toBundle());
                } else {
                    LoginUser user = getArguments().getParcelable("user");
                    Intent intent = new Intent(getActivity(), UserActivity.class);
                    intent.putExtra("slug", user.getUser_slug());
                    startActivityForResult(intent, 200, ActivityOptions.makeSceneTransitionAnimation(
                            getActivity()
                    ).toBundle());
                }
            }
        });*/
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.d(TAG, "收到");
        LoginUser user = data.getParcelableExtra("user");
        nickname.setText(user.getLatest().getNickname());
        Glide.with(this)
                .load(user.getLatest().getAvatar())
                .transform(new GlideGircleTransform(getActivity()))
                .into(avatar);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
