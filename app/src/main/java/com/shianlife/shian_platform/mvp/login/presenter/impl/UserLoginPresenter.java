package com.shianlife.shian_platform.mvp.login.presenter.impl;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginConfig;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.login.model.IUserLoginModel;
import com.shianlife.shian_platform.mvp.login.model.impl.UserLoginModelImpl;
import com.shianlife.shian_platform.mvp.login.presenter.IUserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginOutView;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginView;

/**
 * Created by zm.
 */

public class UserLoginPresenter implements IUserLoginPresenter {

    IUserLoginView userLoginView;
    IUserLoginOutView userLoginOutView;
    IUserLoginModel userLoginModel;

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        userLoginModel = new UserLoginModelImpl();
    }

    public UserLoginPresenter(IUserLoginOutView userLoginOutView) {
        this.userLoginOutView = userLoginOutView;
        userLoginModel = new UserLoginModelImpl();
    }

    @Override
    public void loginCemetery() {
        UserLoginBean params = new UserLoginBean();
        params.setUsername(userLoginView.getUserName());
        params.setPassword(userLoginView.getPassWord());
        params.setSystemType("2");
        params.setChannelId(Constants.ChannelId);
        userLoginModel.loginCemetery(userLoginView.getContext(), params, new OnGetDataListener<UserLoginResultBean>() {
            @Override
            public void getDataSuccess(UserLoginResultBean result) {
                userLoginView.loginSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                userLoginView.loginFail(msg);
            }


        });
    }

    @Override
    public void loginOutCemetery() {
        userLoginModel.loginOutCemetery(userLoginOutView.getContent(), new OnGetDataListener<Object>() {
            @Override
            public void getDataSuccess(Object result) {
                userLoginOutView.loginOutSuccess(null);
            }

            @Override
            public void getDataFail(String msg) {
                userLoginOutView.loginOutFail(msg);
            }
        });
    }

    @Override
    public void saveLoginConfig() {
        UserLoginConfig loginConfig = new UserLoginConfig();
        loginConfig.setUserName(userLoginView.getUserName());
        loginConfig.setPassWord(userLoginView.getPassWord());
        loginConfig.setAutoLogin(userLoginView.getIsAutoLogin());
        loginConfig.setKeepAccount(userLoginView.getIsKeepAccount());
        userLoginModel.saveLoginConfig(userLoginView.getContext(), loginConfig);
    }

    @Override
    public void getLoginConfig() {
        UserLoginConfig loginConfig = userLoginModel.getLoginConfig(userLoginView.getContext());
        if (loginConfig.isKeepAccount()) {
            userLoginView.setUserName(loginConfig.getUserName());
            userLoginView.setPassWord(loginConfig.getPassWord());
            userLoginView.setIsAutoLogin(loginConfig.isAutoLogin());
            userLoginView.setIsKeepAccount(loginConfig.isKeepAccount());
        }
        if (loginConfig.isAutoLogin()) {
            userLoginView.setUserName(loginConfig.getUserName());
            userLoginView.setPassWord(loginConfig.getPassWord());
            userLoginView.setIsAutoLogin(loginConfig.isKeepAccount());
            loginCemetery();
        }
        if (!loginConfig.isAutoLogin())
            userLoginView.setLoginConfig();
    }
}
