package com.shianlife.shian_platform.mvp.login.presenter;

import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

/**
 * Created by zm.
 */

public interface OnUserLoginListener {
    void loginSuccess(UserLoginResultBean result);

    void loginFail(String message);
}
