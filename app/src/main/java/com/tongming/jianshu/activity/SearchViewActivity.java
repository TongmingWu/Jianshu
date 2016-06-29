package com.tongming.jianshu.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tongming.jianshu.R;
import com.tongming.jianshu.adapter.QueryAdapter;
import com.tongming.jianshu.base.BaseActivity;

import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;

/**
 * Created by Tongming on 2016/6/27.
 */
public class SearchViewActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView back;
    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.iv_clear)
    ImageView iv_clear;
    @BindView(R.id.lv_search)
    ListView listView;
    @BindView(R.id.tv_clear)
    TextView clear;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private Set<String> querySet;
    private QueryAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.view_search;
    }

    @Override
    public void initViews() {
        sp = getSharedPreferences("config", MODE_PRIVATE);
        querySet = sp.getStringSet("query", null);
        editor = sp.edit();
        if (querySet == null) {
            querySet = new HashSet<>();
        } else {
            if (querySet.size() != 0) {
                adapter = new QueryAdapter(querySet, this);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        et_search.setText((String) querySet.toArray()[position]);
                    }
                });
            } else {
                clear.setVisibility(View.GONE);
            }
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    if (iv_clear.getVisibility() == View.VISIBLE) {
                        iv_clear.setVisibility(View.GONE);
                    }
                } else {
                    if (iv_clear.getVisibility() == View.GONE) {
                        iv_clear.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //在这里可以实现提示操作
            }
        });
        //弹出软键盘
        et_search.setFocusable(true);
        et_search.setFocusableInTouchMode(true);
        et_search.requestFocus();
        InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        manager.showSoftInput(et_search, 0);
        //清除操作
        iv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_search.setText("");
            }
        });
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = et_search.getText() + "";
                querySet.add(query);
                editor.putStringSet("query", querySet).commit();
                Intent intent = new Intent(SearchViewActivity.this, SearchActivity.class);
                intent.putExtra("query", query);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(SearchViewActivity.this).toBundle());
            }
        });
        //清除搜索记录
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                querySet.clear();
                editor.putStringSet("query", querySet).commit();
                adapter.notifyDataSetChanged();
            }
        });
    }
}
