package com.shianlife.shian_platform.mvp.login.presenter.impl;

import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginConfig;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.login.model.IUserLoginModel;
import com.shianlife.shian_platform.mvp.login.model.impl.UserLoginModelImpl;
import com.shianlife.shian_platform.mvp.login.presenter.IUserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.presenter.OnUserLoginListener;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginView;

/**
 * Created by zm.
 */

public class UserLoginPresenter implements IUserLoginPresenter {

    IUserLoginView userLoginView;
    IUserLoginModel userLoginModel;

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        userLoginModel = new UserLoginModelImpl();
    }

    @Override
    public void loginCemetery() {
        UserLoginBean params = new UserLoginBean();
        params.setUsername(userLoginView.getUserName());
        params.setPassword(userLoginView.getPassWord());
        params.setSystemType("2");
        userLoginModel.loginCemetery(userLoginView.getContent(), params, new OnUserLoginListener() {
            @Override
            public void loginSuccess(UserLoginResultBean result) {
                userLoginView.loginSuccess(result);
            }

            @Override
            public void loginFail(String message) {
                userLoginView.loginFail(message);
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
        userLoginModel.saveLoginConfig(userLoginView.getContent(), loginConfig);
    }

    @Override
    public void getLoginConfig() {
        UserLoginConfig loginConfig = userLoginModel.getLoginConfig(userLoginView.getContent());
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
