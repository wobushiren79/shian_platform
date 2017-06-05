package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.AdvertisementEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertResultBean;
import com.shianlife.shian_platform.mvp.advert.presenter.IAdvertPresenter;
import com.shianlife.shian_platform.mvp.advert.presenter.impl.AdvertPresenterImpl;
import com.shianlife.shian_platform.mvp.advert.view.IAdvertView;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginConfig;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.login.presenter.IUserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.presenter.impl.UserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginView;
import com.shianlife.shian_platform.utils.IntentUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
public class SplashActivity extends BaseActivity implements IUserLoginView {

    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.iv_title)
    ImageView ivTitle;
    @BindView(R.id.iv_text)
    ImageView ivText;

    private UserLoginConfig loginConfig;
    private IUserLoginPresenter userLoginPresenter;
    private Timer timerIntent;//定时跳转
    private int SLEEPTIME = 2000;//屏幕休眠时间

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
        userLoginPresenter = new UserLoginPresenter(this);
        userLoginPresenter.getLoginConfig();
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
        sleepActivity(LoginAdvertActivity.LOGIN);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loginSuccess(UserLoginResultBean result) {
        sleepActivity(LoginAdvertActivity.MAIN);
    }

    @Override
    public void loginFail(String message) {
        sleepActivity(LoginAdvertActivity.LOGIN);
    }

    /**
     * 休眠2秒
     */
    private void sleepActivity(final int type) {
        timerIntent = new Timer();
        timerIntent.schedule(new TimerTask() {
            @Override
            public void run() {
                jumpActivity(type);
            }
        }, SLEEPTIME);
    }

    private void jumpActivity(int type) {
        new IntentUtils
                .Build(this, LoginAdvertActivity.class)
                .setInt(IntentUtils.INTENT_ADEVERT, type)
                .start();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timerIntent != null)
            timerIntent.cancel();
    }
}
