package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsResultBean;

/**
 * Created by zm.
 */

public interface OrderCenterManager {

    /**
     * 获取审核列表
     *
     * @param context
     * @param params
     * @param handler
     */
    public void getAuditListData(Context context, BaseHttpParams params, HttpResponseHandler<OrderCenterAuditListResultBean> handler);

    /**
     * 获取订单详情
     *
     * @param context
     * @param params
     * @param handler
     */
    public void getOrderDetails(Context context, BaseHttpParams params, HttpResponseHandler<OrderCenterDetailsResultBean> handler);
}
