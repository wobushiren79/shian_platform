package com.shianlife.shian_platform.mvp.userinfo.model.impl;

import android.content.Context;


import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralResultBean;
import com.shianlife.shian_platform.mvp.userinfo.model.IUserInfoIntegralModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class UserInfoIntegralModelImpl implements IUserInfoIntegralModel {
    @Override
    public void getUserInfoIntegral(Context context, UserInfoIntegralBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getSystemManager().getUserInfoIntegral(context, params, new HttpResponseHandler<UserInfoIntegralResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(UserInfoIntegralResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
