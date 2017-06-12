package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IRejectOrderModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class RejectOrderModelImpl implements IRejectOrderModel {
    @Override
    public void rejectOrder(Context context, RejectOrderBean params, final OnGetDataListener<RejectOrderResultBean> listener) {
        MHttpManagerFactory.getAccountManager().driverRejectOrder(context, params, new HttpResponseHandler<RejectOrderResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(RejectOrderResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
