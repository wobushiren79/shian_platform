package com.shianlife.shian_platform.mvp.userinfo.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoBean;

/**
 * Created by zm.
 */

public interface IUserInfoModel {
    void getUserInfoData(Context context, UserInfoBean params, OnGetDataListener<SystemLoginResultBean.UserObject> listener);
}
