package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginOutBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginOutResultBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

/**
 * Created by zm.
 */

public interface SystemManager {

    /**
     * 登陆系统
     *
     * @param context
     * @param params
     * @param handler
     */
    void loginSystem(Context context, SystemLoginBean params, HttpResponseHandler<SystemLoginResultBean> handler);

    /**
     * 退出登陆
     * @param context
     * @param params
     * @param handler
     */
    void loginOutSystem(Context context, SystemLoginOutBean params, HttpResponseHandler<SystemLoginOutResultBean> handler);

    /**
     * 单项系统登陆
     *
     * @param context
     * @param loginKey
     */
    void loginStoreSystem(Context context, String loginKey);
}
