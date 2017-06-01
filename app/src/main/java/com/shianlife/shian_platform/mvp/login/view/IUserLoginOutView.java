package com.shianlife.shian_platform.mvp.login.view;

import android.content.Context;

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
    Context getContent();


    /**
     * 退出登陆成功
     *
     * @param result
     */
    void loginOutSuccess(Object result);

    /**
     * 退出登陆失败
     *
     * @param message
     */
    void loginOutFail(String message);
}
