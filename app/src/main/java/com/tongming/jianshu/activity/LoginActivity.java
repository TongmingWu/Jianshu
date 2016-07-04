package com.tongming.jianshu.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tongming.jianshu.R;
import com.tongming.jianshu.base.BaseActivity;
import com.tongming.jianshu.bean.LoginUser;
import com.tongming.jianshu.presenter.LoginPresenterCompl;
import com.tongming.jianshu.util.ToastUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/7/2.
 */
public class LoginActivity extends BaseActivity implements ILoginView {
    @BindView(R.id.et_count)
    EditText count;
    @BindView(R.id.et_pwd)
    EditText pwd;
    @BindView(R.id.btn_login)
    Button login;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ProgressDialog mDialog;
    private SharedPreferences sp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews() {
        sp = getSharedPreferences("config", MODE_PRIVATE);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        String spCount = sp.getString("count", "");
        if (!TextUtils.isEmpty(spCount)) {
            count.setText(spCount);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = "";
                String name = "";
                final String countText = count.getText() + "";
                Pattern p = Pattern.compile("(^(13\\d|15[^4,\\D]|17[13678]|18\\d)\\d{8}|170[^346,\\D]\\d{7})$");
                Matcher matcher = p.matcher(countText);
                if (matcher.find()) {
                    mobile = countText;
                } else {
                    name = countText;
                }
                final String pwdText = pwd.getText() + "";
                if (TextUtils.isEmpty(countText)) {
                    ToastUtil.showToast(LoginActivity.this, "帐号不能为空!");
                } else if (TextUtils.isEmpty(pwdText)) {
                    ToastUtil.showToast(LoginActivity.this, "密码不能为空!");
                } else {
                    LoginPresenterCompl compl = new LoginPresenterCompl(LoginActivity.this);
                    compl.doLogin(mobile, name, pwdText);
                    mDialog = new ProgressDialog(LoginActivity.this);
                    mDialog.setMessage("登录中...");
                    mDialog.show();
                    sp.edit().putString("count", countText).commit();
                }
            }
        });
    }

    @Override
    public void onSuccess(LoginUser user) {
        mDialog.dismiss();
        ToastUtil.showToast(LoginActivity.this, "登录成功");
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra("user", user);
        LoginActivity.this.setResult(200, intent);
        sp.edit().putBoolean("isLogin", true).commit();
        finish();
    }

    @Override
    public void onFail(int type) {
        mDialog.dismiss();
        ToastUtil.showToast(LoginActivity.this, "登录失败");
    }
}
