package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.HttpManager;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
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
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

/**
 * Created by Administrator on 2017/4/3.
 */

public interface MAccountManager extends HttpManager {
    /**
     * 登陸公墓
     *
     * @param context
     * @param params
     * @param handler
     */
    void loginCemetery(Context context, UserLoginBean params, HttpResponseHandler<UserLoginResultBean> handler);

    /**
     * 登陸公墓
     *
     * @param context
     * @param handler
     */
    void loginOutCemetery(Context context, HttpResponseHandler<Object> handler);


    /**
     * 获取待服务列表
     *
     * @param context
     * @param params
     * @param handler
     */
    void getWaitServiceList(Context context, WaitServiceListBean params, HttpResponseHandler<WaitServiceListResultBean> handler);

    /**
     * 获取服务中列表
     *
     * @param context
     * @param params
     * @param handler
     */
    void getInServiceList(Context context, InServiceListBean params, HttpResponseHandler<InServiceListResultBean> handler);

    /**
     * 获取服务成功列表
     *
     * @param context
     * @param params
     * @param handler
     */
    void getSuccessServiceList(Context context, SuccessServiceListBean params, HttpResponseHandler<SuccessServiceListResultBean> handler);


    /**
     * 获取服务取消列表
     *
     * @param context
     * @param params
     * @param handler
     */
    void getFailServiceList(Context context, FailServiceListBean params, HttpResponseHandler<FailServiceListResultBean> handler);

    /**
     * 司机接单
     *
     * @param context
     * @param params
     * @param handler
     */
    void driverAcceptOrder(Context context, AcceptOrderBean params, HttpResponseHandler<AcceptOrderResultBean> handler);


    /**
     * 司机拒单
     *
     * @param context
     * @param params
     * @param handler
     */
    void driverRejectOrder(Context context, RejectOrderBean params, HttpResponseHandler<RejectOrderResultBean> handler);


    /**
     * 保存服務步驟
     *
     * @param context
     * @param params
     * @param handler
     */
    void saveServiceOngoing(Context context, ServiceOngoingBean params, HttpResponseHandler<ServiceOngoingResultBean> handler);

    /**
     * 获取司机订单详情
     *
     * @param context
     * @param params
     * @param handler
     */
    void getDriverOrderDetails(Context context, OrderDetailsBean params, HttpResponseHandler<OrderDetailsResultBean> handler);
}
