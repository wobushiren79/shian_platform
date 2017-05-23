package com.shianlife.shian_platform.mvp.login.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginConfig;
import com.shianlife.shian_platform.mvp.login.presenter.OnUserLoginListener;

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
    void loginCemetery(Context context, UserLoginBean params, OnUserLoginListener listener);

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
