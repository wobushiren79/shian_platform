package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IAcceptOrderModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class AcceptOrderModelImpl implements IAcceptOrderModel {
    @Override
    public void acceptOrder(Context context, AcceptOrderBean params, final OnGetDataListener<AcceptOrderResultBean> listener) {
        MHttpManagerFactory.getAccountManager().driverAcceptOrder(context, params, new HttpResponseHandler<AcceptOrderResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(AcceptOrderResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
