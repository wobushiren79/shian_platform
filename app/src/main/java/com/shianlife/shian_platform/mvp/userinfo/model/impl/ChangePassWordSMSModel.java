package com.shianlife.shian_platform.mvp.userinfo.model.impl;

import android.content.Context;


import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.ChangePassWordSMSBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.ChangePassWordSMSResultBean;
import com.shianlife.shian_platform.mvp.userinfo.model.IChangePassWordSMSModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class ChangePassWordSMSModel implements IChangePassWordSMSModel {
    @Override
    public void passWordSMS(Context context, ChangePassWordSMSBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getSystemManager().changePassWordSMS(context, params, new HttpResponseHandler<ChangePassWordSMSResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(ChangePassWordSMSResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
