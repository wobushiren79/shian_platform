package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.mvp.splash.presenter.impl.SplashPresenterImpl;
import com.shianlife.shian_platform.mvp.splash.view.ISplashView;

import butterknife.BindView;

public class SplashActivity extends BaseActivity implements ISplashView {

    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.iv_title)
    ImageView ivTitle;
    @BindView(R.id.iv_text)
    ImageView ivText;

    private int delayTime = 2;

    private SplashPresenterImpl splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        splashPresenter = new SplashPresenterImpl(this);
        splashPresenter.delay();
    }


    @Override
    public Context getContent() {
        return this;
    }

    @Override
    public Class<?> getIntentClass() {
        return LoginActivity.class;
    }

    @Override
    public int getDelayTime() {
        return delayTime;
    }

    @Override
    public void delayOver() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
