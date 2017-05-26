package com.shianlife.shian_platform.mvp.dynamic.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicBean;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicResultBean;
import com.shianlife.shian_platform.mvp.dynamic.model.IDynamicModel;
import com.shianlife.shian_platform.mvp.dynamic.presenter.OnDynamicListener;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class DynamicModelImpl implements IDynamicModel {
    @Override
    public void getDynamicData(Context context, DynamicBean params, final OnDynamicListener listener) {
        MHttpManagerFactory.getPHPManager().getDynamicInfo(context, params, new HttpResponseHandler<DynamicResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(DynamicResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
