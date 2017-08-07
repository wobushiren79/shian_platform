package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditResultListBean;

/**
 * Created by zm.
 */

public interface StoreManager {
    /**
     * 获取单项审核商品
     * @param context
     * @param params
     * @param handler
     */
    void getStoreOrderAuditList(Context context, StoreOrderAuditListBean params, HttpResponseHandler<StoreOrderAuditResultListBean> handler);

    /**
     * 获取单项审核执行列表
     * @param context
     * @param params
     * @param handler
     */
    void getStoreAuditPerformList(Context context, StoreAuditPerformListBean params, HttpResponseHandler<StoreAuditPerformListResultBean> handler);
}
