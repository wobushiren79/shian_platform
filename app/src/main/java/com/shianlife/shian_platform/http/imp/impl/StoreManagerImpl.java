package com.shianlife.shian_platform.http.imp.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.base.BaseManagerImpl;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.imp.StoreManager;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformListBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformResultBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformSubmitBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformSubmitResultBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderAuditListBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderAuditResultListBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderDetailsBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderDetailsResultBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderGetPerformBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderGetPerformResultBean;

/**
 * Created by zm.
 */

public class StoreManagerImpl extends BaseManagerImpl implements StoreManager {
    private static StoreManagerImpl manager;

    private StoreManagerImpl() {
        super();
        baseUrl = Constants.Store_BaseUrl;
    }

    public static StoreManagerImpl getInstance() {
        if (manager == null) {
            manager = new StoreManagerImpl();
        }
        return manager;
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
        requestPost(context, "api/goods/aduit/aduitPerformDetailByPerformId", StoreAuditPerformResultBean.class, params, handler, true);
    }

    @Override
    public void submitAuditPerform(Context context, StoreAuditPerformSubmitBean params, HttpResponseHandler<StoreAuditPerformSubmitResultBean> handler) {
        requestPost(context, "api/goods/aduit/aduitPerformSubmit", StoreAuditPerformSubmitResultBean.class, params, handler, true);
    }

    @Override
    public void getStoreOrderDetails(Context context, StoreOrderDetailsBean params, HttpResponseHandler<StoreOrderDetailsResultBean> handler) {
        requestPost(context, "api/goods/order/findOrderDetailById", StoreOrderDetailsResultBean.class, params, handler, true);
    }

    @Override
    public void getPerformInfo(Context context, StoreOrderGetPerformBean params, HttpResponseHandler<StoreOrderGetPerformResultBean> handler) {
        requestPost(context, "api/goods/perform/findPerformInfoByPerformId", StoreOrderGetPerformResultBean.class, params, handler, true);
    }
}
