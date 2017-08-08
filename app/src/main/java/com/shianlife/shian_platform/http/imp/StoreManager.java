package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformResultBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformSubmitBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformSubmitResultBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditResultListBean;

/**
 * Created by zm.
 */

public interface StoreManager {
    /**
     * 获取单项审核商品
     *
     * @param context
     * @param params
     * @param handler
     */
    void getStoreOrderAuditList(Context context, StoreOrderAuditListBean params, HttpResponseHandler<StoreOrderAuditResultListBean> handler);

    /**
     * 获取单项审核执行列表
     *
     * @param context
     * @param params
     * @param handler
     */
    void getStoreAuditPerformList(Context context, StoreAuditPerformListBean params, HttpResponseHandler<StoreAuditPerformListResultBean> handler);


    /**
     * 获取单项审核执行详情
     *
     * @param context
     * @param params
     * @param handler
     */
    void getStoreAuditPerformDetails(Context context, StoreAuditPerformBean params, HttpResponseHandler<StoreAuditPerformResultBean> handler);

    /**
     * 提交审核
     *
     * @param context
     * @param params
     * @param handler
     */
    void submitAuditPerform(Context context, StoreAuditPerformSubmitBean params, HttpResponseHandler<StoreAuditPerformSubmitResultBean> handler);
}
