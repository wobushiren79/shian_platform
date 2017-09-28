package com.shianlife.shian_platform.mvp.userinfo.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralBean;

/**
 * Created by zm.
 */

public interface IUserInfoIntegralModel {
    void getUserInfoIntegral(Context context, UserInfoIntegralBean params, OnGetDataListener listener);
}
