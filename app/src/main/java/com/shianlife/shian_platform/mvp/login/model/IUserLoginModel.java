package com.shianlife.shian_platform.mvp.login.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginOutBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginOutResultBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginConfig;

/**
 * Created by zm.
 */

public interface IUserLoginModel {
    /**
     * 登陆公墓系统
     *
     * @param context
     * @param params
     * @param listener
     */
    void loginCemetery(Context context, UserLoginBean params, OnGetDataListener listener);

    /**
     * 退出公墓登陆
     *
     * @param context
     * @param listener
     */
    void loginOutCemetery(Context context, OnGetDataListener listener);

    /**
     * 登陆平台
     *
     * @param context
     * @param params
     * @param listener
     */
    void loginSystem(Context context, SystemLoginBean params, OnGetDataListener<SystemLoginResultBean> listener);

    /**
     * 退出登陆平台
     *
     * @param context
     * @param params
     * @param listener
     */
    void loginOutSystem(Context context, SystemLoginOutBean params, OnGetDataListener<SystemLoginOutResultBean> listener);

    /**
     * 保存登陆设置
     *
     * @param context
     * @param loginConfig
     */
    void saveLoginConfig(Context context, UserLoginConfig loginConfig);

    /**
     * 获取登陆设置
     *
     * @param context
     * @return
     */
    UserLoginConfig getLoginConfig(Context context);
}
