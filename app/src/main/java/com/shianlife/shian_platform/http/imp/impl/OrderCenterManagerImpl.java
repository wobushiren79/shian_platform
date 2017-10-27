package com.shianlife.shian_platform.http.imp.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.BaseManagerImpl;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.imp.FileManager;
import com.shianlife.shian_platform.http.imp.OrderCenterManager;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditResultBean;

/**
 * Created by zm.
 */

public class OrderCenterManagerImpl extends BaseManagerImpl implements OrderCenterManager {
    private static OrderCenterManager manager;

    private OrderCenterManagerImpl() {
        super();
        baseUrl = Constants.OrderCenter_BaseUrl;
    }

    public static OrderCenterManager getInstance() {
        if (manager == null) {
            manager = new OrderCenterManagerImpl();
        }
        return manager;
    }

    @Override
    public void getAuditListData(Context context, BaseHttpParams params, HttpResponseHandler<OrderCenterAuditListResultBean> handler) {
        requestPost(context, "api/audit/list", OrderCenterAuditListResultBean.class, params, handler, false);
    }

    @Override
    public void getOrderDetails(Context context, BaseHttpParams params, HttpResponseHandler<OrderCenterDetailsResultBean> handler) {
        requestPost(context, "api/workorder/details", OrderCenterDetailsResultBean.class, params, handler, true);
    }

    @Override
    public void submitAudit(Context context, OrderCenterSubmitAuditBean params, HttpResponseHandler<OrderCenterSubmitAuditResultBean> handler) {
        requestPost(context, "api/audit/dealAudit", OrderCenterSubmitAuditResultBean.class, params, handler, true);
    }

}
