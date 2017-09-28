package com.shianlife.shian_platform.mvp.userinfo.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoSignBean;

/**
 * Created by zm.
 */

public interface IUserInfoSignModel {
    void userInfoSign(Context context, UserInfoSignBean params, OnGetDataListener listener);
}
