package com.shianlife.shian_platform.mvp.order.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditResultListBean;
import com.shianlife.shian_platform.mvp.order.model.IStoreOrderAuditListModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreOrderAuditListModelImpl implements IStoreOrderAuditListModel {

    @Override
    public void getStoreOrderAuditListData(Context context, StoreOrderAuditListBean params, final OnGetDataListener<StoreOrderAuditResultListBean> listener) {
        MHttpManagerFactory.getStoreManger().getStoreOrderAuditList(context, params, new HttpResponseHandler<StoreOrderAuditResultListBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreOrderAuditResultListBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
