package com.shianlife.shian_platform.http.imp.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.BaseManagerImpl;
import com.shianlife.shian_platform.http.base.HttpRequestExecutor;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.imp.CarManager;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsBean;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

/**
 * Created by zm.
 */

public class CarManagerImpl extends BaseManagerImpl implements CarManager {
    private static CarManagerImpl manager;

    private CarManagerImpl() {
        super();
        baseUrl = Constants.Cemetery_BaseUrl;
    }

    public static CarManagerImpl getInstance() {
        if (manager == null) {
            manager = new CarManagerImpl();
        }
        return manager;
    }

    @Override
    public void loginCemetery(Context context, UserLoginBean params, HttpResponseHandler<UserLoginResultBean> handler) {
        requestPost(context, "doLogin/marketing", UserLoginResultBean.class, params, handler);
    }

    @Override
    public void loginOutCemetery(Context context, HttpResponseHandler<Object> handler) {
        requestPost(context, "doLogout", Object.class, new BaseHttpParams(), handler);
    }

    @Override
    public void getWaitServiceList(Context context, WaitServiceListBean params, HttpResponseHandler<WaitServiceListResultBean> handler) {
        requestPost(context, "driver/service/order/list/wait", WaitServiceListResultBean.class, params, handler);
    }

    @Override
    public void getInServiceList(Context context, InServiceListBean params, HttpResponseHandler<InServiceListResultBean> handler) {
        requestPost(context, "driver/service/order/list/in", InServiceListResultBean.class, params, handler);
    }

    @Override
    public void getSuccessServiceList(Context context, SuccessServiceListBean params, HttpResponseHandler<SuccessServiceListResultBean> handler) {
        requestPost(context, "driver/service/order/list/success", SuccessServiceListResultBean.class, params, handler);
    }

    @Override
    public void getFailServiceList(Context context, FailServiceListBean params, HttpResponseHandler<FailServiceListResultBean> handler) {
        requestPost(context, "driver/service/order/list/fail", FailServiceListResultBean.class, params, handler);
    }

    @Override
    public void driverAcceptOrder(Context context, AcceptOrderBean params, HttpResponseHandler<AcceptOrderResultBean> handler) {
        requestPost(context, "driver/service/order/accept", AcceptOrderResultBean.class, params, handler, true);
    }

    @Override
    public void driverRejectOrder(Context context, RejectOrderBean params, HttpResponseHandler<RejectOrderResultBean> handler) {
        requestPost(context, "driver/service/order/reject", RejectOrderResultBean.class, params, handler, true);
    }

    @Override
    public void saveServiceOngoing(Context context, ServiceOngoingBean params, HttpResponseHandler<ServiceOngoingResultBean> handler) {
        requestPost(context, "driver/service/ongoing", ServiceOngoingResultBean.class, params, handler, true);
    }

    @Override
    public void getDriverOrderDetails(Context context, OrderDetailsBean params, HttpResponseHandler<OrderDetailsResultBean> handler) {
        requestPost(context, "driver/service/order/details", OrderDetailsResultBean.class, params, handler, true);
    }

}
