package com.shianlife.shian_platform.mvp.login.model;

import android.content.Context;

/**
 * Created by zm.
 */

public interface ISubSystemLoginModel {
    void subSystemStoreLogin(Context context, String loginKey);

    void subSystemOrderCenterLogin(Context context, String loginKey);

    void subSystemCemeteryLogin(Context context, String loginKey);
}
