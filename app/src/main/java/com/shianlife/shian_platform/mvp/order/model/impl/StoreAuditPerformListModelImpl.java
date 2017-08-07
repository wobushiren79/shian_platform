package com.shianlife.shian_platform.mvp.order.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.mvp.order.model.IStoreAuditPerformListModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreAuditPerformListModelImpl implements IStoreAuditPerformListModel {
    @Override
    public void getAuditPerformList(Context context, StoreAuditPerformListBean params, final OnGetDataListener<StoreAuditPerformListResultBean> listener) {
        MHttpManagerFactory.getStoreManger().getStoreAuditPerformList(context, params, new HttpResponseHandler<StoreAuditPerformListResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreAuditPerformListResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
