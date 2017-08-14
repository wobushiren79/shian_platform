package com.shianlife.shian_platform.mvp.login.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.login.bean.SystemLoginOutResultBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

/**
 * Created by zm.
 */

public interface IUserLoginOutView {
    /**
     * 获取上下文对象
     *
     * @return
     */
    Context getContext();


    /**
     * 退出公墓成功
     *
     * @param result
     */
    void loginOutCemeterySuccess(Object result);

    /**
     * 退出公墓失败
     *
     * @param message
     */
    void loginOutCemeteryFail(String message);


    /**
     * 退出平臺成功
     *
     * @param result
     */
    void loginOutSystemSuccess(SystemLoginOutResultBean result);

    /**
     * 退出平臺失败
     *
     * @param message
     */
    void loginOutSystemFail(String message);
}
