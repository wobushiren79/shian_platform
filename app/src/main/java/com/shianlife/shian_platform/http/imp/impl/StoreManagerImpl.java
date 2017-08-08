package com.shianlife.shian_platform.http.imp.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.HttpRequestExecutor;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.imp.StoreManager;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformResultBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformSubmitBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformSubmitResultBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditResultListBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zm.
 */

public class StoreManagerImpl implements StoreManager {
    public HttpRequestExecutor excutor = new HttpRequestExecutor();
    private static StoreManagerImpl manager;
    private String BaseUrl = Constants.StoreURL;

    private StoreManagerImpl() {
    }


    public static StoreManagerImpl getInstance() {
        if (manager == null) {
            manager = new StoreManagerImpl();
        }
        return manager;
    }

    private <T> void requestPost(Context context,
                                 String method,
                                 Class<T> cls,
                                 BaseHttpParams params,
                                 HttpResponseHandler<T> response) {
        excutor.requestPost(context, method, cls, params, response, false, BaseUrl, null);
    }

    private <T> void requestPost(Context context,
                                 String method,
                                 Class<T> cls,
                                 BaseHttpParams params,
                                 HttpResponseHandler<T> response,
                                 boolean isDialog) {
        excutor.requestPost(context, method, cls, params, response, isDialog, BaseUrl, null);
    }


    @Override
    public void getStoreOrderAuditList(Context context, StoreOrderAuditListBean params, HttpResponseHandler<StoreOrderAuditResultListBean> handler) {
        requestPost(context, "api/goods/aduit/list", StoreOrderAuditResultListBean.class, params, handler);
    }

    @Override
    public void getStoreAuditPerformList(Context context, StoreAuditPerformListBean params, HttpResponseHandler<StoreAuditPerformListResultBean> handler) {
        requestPost(context, "api/goods/aduit/aduitPerformByOrderId", StoreAuditPerformListResultBean.class, params, handler);
    }

    @Override
    public void getStoreAuditPerformDetails(Context context, StoreAuditPerformBean params, HttpResponseHandler<StoreAuditPerformResultBean> handler) {
        requestPost(context, "api/goods/aduit/aduitPerformDetailByPerformId", StoreAuditPerformResultBean.class, params, handler);
    }

    @Override
    public void submitAuditPerform(Context context, StoreAuditPerformSubmitBean params, HttpResponseHandler<StoreAuditPerformSubmitResultBean> handler) {
        requestPost(context, "api/goods/aduit/aduitPerformSubmit", StoreAuditPerformSubmitResultBean.class, params, handler);
    }
}
