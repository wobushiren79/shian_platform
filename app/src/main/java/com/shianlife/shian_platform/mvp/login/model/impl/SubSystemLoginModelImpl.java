package com.shianlife.shian_platform.mvp.login.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.mvp.login.model.ISubSystemLoginModel;

/**
 * Created by zm.
 */

public class SubSystemLoginModelImpl implements ISubSystemLoginModel {
    @Override
    public void subSystemStoreLogin(Context context, String loginKey) {
        MHttpManagerFactory.getSystemManager().loginStoreSystem(context, loginKey);
    }

    @Override
    public void subSystemOrderCenterLogin(Context context, String loginKey) {
        MHttpManagerFactory.getSystemManager().loginOrderCenterSystem(context, loginKey);
    }
}
