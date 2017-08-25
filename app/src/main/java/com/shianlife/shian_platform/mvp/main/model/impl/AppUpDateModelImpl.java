package com.shianlife.shian_platform.mvp.main.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateBean;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;
import com.shianlife.shian_platform.mvp.main.model.IAppUpDateModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class AppUpDateModelImpl implements IAppUpDateModel {
    @Override
    public void getAppUpDateInfo(Context context, AppUpDateBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getPHPManager().getVersion(context, params, new HttpResponseHandler<AppUpDateResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(AppUpDateResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        }, true);
    }
}
