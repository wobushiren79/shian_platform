package com.shianlife.shian_platform.mvp.login.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginConfig;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.login.model.IUserLoginModel;
import com.shianlife.shian_platform.mvp.login.presenter.OnUserLoginListener;
import com.shianlife.shian_platform.utils.SharePerfrenceUtils;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class UserLoginModelImpl implements IUserLoginModel {


    @Override
    public void loginCemetery(Context context, UserLoginBean params, final OnUserLoginListener listener) {
        MHttpManagerFactory.getAccountManager().loginCemetery(context, params, new HttpResponseHandler<UserLoginResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(UserLoginResultBean result) {
                Constants.userCemetery = result;
                listener.loginSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.loginFail(message);
            }
        });
    }

    @Override
    public void loginOutCemetery(Context context, final OnUserLoginListener listener) {
        MHttpManagerFactory.getAccountManager().loginOutCemetery(context, new HttpResponseHandler<Object>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(Object result) {
                listener.loginSuccess(null);
            }

            @Override
            public void onError(String message) {
                listener.loginFail(message);
            }
        });
    }

    @Override
    public void saveLoginConfig(Context context, UserLoginConfig loginConfig) {
        SharePerfrenceUtils.setLoginShare(context, loginConfig.getUserName(), loginConfig.getPassWord(), loginConfig.isKeepAccount(), loginConfig.isAutoLogin());
    }

    @Override
    public UserLoginConfig getLoginConfig(Context context) {
        return SharePerfrenceUtils.getLoginShare(context);
    }


}
