package com.shianlife.shian_platform.mvp.login.presenter;

import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

/**
 * Created by zm.
 */

public interface OnUserLoginListener {
    /**
     * 登陆成功回调
     * @param result
     */
    void loginSuccess(UserLoginResultBean result);


    /**
     * 登陆失败回调
     * @param message
     */
    void loginFail(String message);



}
