package com.example.hfs.simpleapp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hfs.simpleapp.App;

import butterknife.ButterKnife;

/**
 * Created by HFS on 2016/12/11.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected Activity mContext;
    private T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        mContext = this;

        if (mPresenter != null)
            mPresenter.attachView(this);
        App.getInstance().addActivity(this);

        initData(savedInstanceState);
        initView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
        ButterKnife.unbind(this);
        App.getInstance().removeActivity(this);
    }

    /**
     * 设置Toolbar
     * @param toolbar
     * @param title
     */
    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public abstract void initData(Bundle savedInstanceState);

    public abstract void initView();

    public abstract int getLayoutId();
}
