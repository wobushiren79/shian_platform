package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginConfig;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.login.presenter.impl.UserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginView;
import com.shianlife.shian_platform.mvp.splash.presenter.impl.SplashPresenterImpl;
import com.shianlife.shian_platform.mvp.splash.view.ISplashView;
import com.shianlife.shian_platform.utils.IntentUtils;

import butterknife.BindView;

public class SplashActivity extends BaseActivity implements ISplashView, IUserLoginView {

    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.iv_title)
    ImageView ivTitle;
    @BindView(R.id.iv_text)
    ImageView ivText;

    private int delayTime = 2;
    private UserLoginConfig loginConfig;
    private SplashPresenterImpl splashPresenter;
    private UserLoginPresenter userLoginPresenter;

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
        loginConfig = new UserLoginConfig();
        splashPresenter = new SplashPresenterImpl(this);
        userLoginPresenter = new UserLoginPresenter(this);
        splashPresenter.delay();
    }


    @Override
    public String getUserName() {
        return loginConfig.getUserName();
    }

    @Override
    public void setUserName(String userName) {
        loginConfig.setUserName(userName);
    }

    @Override
    public String getPassWord() {
        return loginConfig.getPassWord();
    }

    @Override
    public void setPassWord(String passWord) {
        loginConfig.setPassWord(passWord);
    }

    @Override
    public boolean getIsAutoLogin() {
        return loginConfig.isAutoLogin();
    }

    @Override
    public void setIsAutoLogin(boolean isAutoLogin) {
        loginConfig.setAutoLogin(isAutoLogin);
    }

    @Override
    public boolean getIsKeepAccount() {
        return loginConfig.isKeepAccount();
    }

    @Override
    public void setIsKeepAccount(boolean isKeepAccount) {
        loginConfig.setKeepAccount(isKeepAccount);
    }

    @Override
    public void setLoginConfig() {
        IntentUtils.IntentStart(this, LoginActivity.class);
        finish();
    }

    @Override
    public Context getContent() {
        return this;
    }

    @Override
    public void loginSuccess(UserLoginResultBean result) {
        IntentUtils.IntentStart(this, MainActivity.class);
        finish();
    }

    @Override
    public void loginFail(String message) {
        IntentUtils.IntentStart(this, LoginActivity.class);
        finish();
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
        userLoginPresenter.getLoginConfig();
    }
}
