package com.shianlife.shian_platform.mvp.userinfo.model.impl;

import android.content.Context;


import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralListBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralListResultBean;
import com.shianlife.shian_platform.mvp.userinfo.model.IUserInfoIntegralListModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class UserInfoIntegralListModelImpl implements IUserInfoIntegralListModel {

    @Override
    public void getIntegralList(Context context, UserInfoIntegralListBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getSystemManager().getUserInfoListIntegral(context, params, new HttpResponseHandler<UserInfoIntegralListResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(UserInfoIntegralListResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
