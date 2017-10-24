package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.HttpResponseHandler;
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

    /**
     * 获取单项订单详情
     *
     * @param context
     * @param params
     * @param handler
     */
    void getStoreOrderDetails(Context context, StoreOrderDetailsBean params, HttpResponseHandler<StoreOrderDetailsResultBean> handler);

    /**
     * 获取执行信息
     *
     * @param context
     * @param params
     * @param handler
     */
    void getPerformInfo(Context context, StoreOrderGetPerformBean params, HttpResponseHandler<StoreOrderGetPerformResultBean> handler);
}
