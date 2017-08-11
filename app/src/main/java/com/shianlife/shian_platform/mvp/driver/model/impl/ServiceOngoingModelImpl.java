package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IServiceOngoingModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class ServiceOngoingModelImpl implements IServiceOngoingModel {
    @Override
    public void saveServiceOngoing(Context context, ServiceOngoingBean params, final OnGetDataListener<ServiceOngoingResultBean> listener) {
        MHttpManagerFactory.getCarManager().saveServiceOngoing(context, params, new HttpResponseHandler<ServiceOngoingResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(ServiceOngoingResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
