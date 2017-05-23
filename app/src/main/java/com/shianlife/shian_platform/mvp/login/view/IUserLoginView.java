package com.shianlife.shian_platform.mvp.login.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

/**
 * Created by zm.
 */

public interface IUserLoginView {
    /**
     * 获取登陆姓名
     *
     * @return
     */
    String getUserName();

    /**
     * 获取登陆密码
     *
     * @return
     */
    String getPassWord();

    /**
     * 获取上下文对象
     *
     * @return
     */
    Context getContent();


    /**
     * 登陆成功
     *
     * @param result
     */
    void loginSuccess(UserLoginResultBean result);

    /**
     * 登陆失败
     *
     * @param message
     */
    void loginFail(String message);
}
