package com.shianlife.shian_platform.mvp.userinfo.model.impl;

import android.content.Context;


import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoSignBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoSignResultBean;
import com.shianlife.shian_platform.mvp.userinfo.model.IUserInfoSignModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class UserInfoSignModelImpl implements IUserInfoSignModel {
    @Override
    public void userInfoSign(Context context, UserInfoSignBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getSystemManager().userInfoSign(context, params, new HttpResponseHandler<UserInfoSignResultBean>() {

            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(UserInfoSignResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }

        });
    }
}
