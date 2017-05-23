package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.HttpManager;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

/**
 * Created by Administrator on 2017/4/3.
 */

public interface MAccountManager extends HttpManager {
    /**
     * 登陸公墓
     *
     * @param context
     * @param params
     * @param handler
     */
    void loginCemetery(Context context, UserLoginBean params, HttpResponseHandler<UserLoginResultBean> handler);
}
