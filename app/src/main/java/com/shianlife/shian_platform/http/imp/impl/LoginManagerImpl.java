package com.shianlife.shian_platform.http.imp.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.HttpRequestExecutor;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.imp.LoginManager;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;

/**
 * Created by zm.
 */

public class LoginManagerImpl implements LoginManager {
    public HttpRequestExecutor excutor = new HttpRequestExecutor();
    private static LoginManagerImpl manager;
    private String BaseUrl = Constants.Login_BaseUrl;

    private LoginManagerImpl() {
    }


    public static LoginManagerImpl getInstance() {
        if (manager == null) {
            manager = new LoginManagerImpl();
        }
        return manager;
    }

    private <T> void requestPost(Context context,
                                 String method,
                                 Class<T> cls,
                                 BaseHttpParams params,
                                 HttpResponseHandler<T> response) {
        excutor.requestPost(context, method, cls, params, response, false, BaseUrl, null);
    }

    private <T> void requestPost(Context context,
                                 String method,
                                 Class<T> cls,
                                 BaseHttpParams params,
                                 HttpResponseHandler<T> response,
                                 boolean isDialog) {
        excutor.requestPost(context, method, cls, params, response, isDialog, BaseUrl, null);
    }

    @Override
    public void loginSystem(Context context, SystemLoginBean params, HttpResponseHandler<SystemLoginResultBean> handler) {
        requestPost(context, "api/login", SystemLoginResultBean.class, params, handler);
    }
}
