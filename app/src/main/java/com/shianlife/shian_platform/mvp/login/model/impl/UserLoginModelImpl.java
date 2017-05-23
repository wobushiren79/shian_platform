package com.shianlife.shian_platform.mvp.login.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.login.model.IUserLoginModel;
import com.shianlife.shian_platform.mvp.login.presenter.OnUserLoginListener;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class UserLoginModelImpl implements IUserLoginModel {


    @Override
    public void loginCemetery(Context context, String userName, String passWord, final OnUserLoginListener listener) {
        UserLoginBean params = new UserLoginBean();
        params.setUsername(userName);
        params.setPassword(passWord);
        params.setSystemType("2");
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


}
