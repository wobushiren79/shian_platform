package com.shianlife.shian_platform.mvp.login.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.login.presenter.OnUserLoginListener;

/**
 * Created by zm.
 */

public interface IUserLoginModel {
    void loginCemetery(Context context, String userName, String passWord, OnUserLoginListener listener);
}
