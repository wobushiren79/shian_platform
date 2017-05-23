package com.shianlife.shian_platform.mvp.login.presenter.impl;

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
        userLoginModel.loginCemetery(userLoginView.getContent(), userLoginView.getUserName(), userLoginView.getPassWord(), new OnUserLoginListener() {
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
}
