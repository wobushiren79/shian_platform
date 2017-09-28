package com.shianlife.shian_platform.mvp.userinfo.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralListBean;


/**
 * Created by zm.
 */

public interface IUserInfoIntegralListModel {
    void getIntegralList(Context context, UserInfoIntegralListBean params, OnGetDataListener listener);
}
