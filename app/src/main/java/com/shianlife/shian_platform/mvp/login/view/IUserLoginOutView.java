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
    void loginSuccess(UserLoginResultBean result);

    /**
     * 退出登陆失败
     *
     * @param message
     */
    void loginFail(String message);
}
