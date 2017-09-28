package com.shianlife.shian_platform.mvp.userinfo.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.ChangePassWordSMSBean;

/**
 * Created by zm.
 */

public interface IChangePassWordSMSModel {
    void passWordSMS(Context context, ChangePassWordSMSBean params, OnGetDataListener listener);
}
