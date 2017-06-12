package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.HttpManager;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
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
}
