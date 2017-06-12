package com.shianlife.shian_platform.http.imp.impl;


import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.HttpRequestExecutor;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.imp.MAccountManager;
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

public class MAccountManagerImpl implements MAccountManager {

    public HttpRequestExecutor excutor = new HttpRequestExecutor();
    private static MAccountManager manager;

    private MAccountManagerImpl() {
    }


    public static MAccountManager getInstance() {
        if (manager == null) {
            manager = new MAccountManagerImpl();
        }
        return manager;
    }


    @Override
    public void loginCemetery(Context context, UserLoginBean params, HttpResponseHandler<UserLoginResultBean> handler) {
        excutor.requestCemeteryPost(context, "doLogin/marketing", UserLoginResultBean.class, params, handler);
    }

    @Override
    public void loginOutCemetery(Context context, HttpResponseHandler<Object> handler) {
        excutor.requestCemeteryPost(context, "doLogout", Object.class, new BaseHttpParams(), handler);
    }

    @Override
    public void getWaitServiceList(Context context, WaitServiceListBean params, HttpResponseHandler<WaitServiceListResultBean> handler) {
        excutor.requestCemeteryPost(context, "driver/service/wait/order/list", WaitServiceListResultBean.class, params, handler);
    }

    @Override
    public void driverAcceptOrder(Context context, AcceptOrderBean params, HttpResponseHandler<AcceptOrderResultBean> handler) {
        excutor.requestCemeteryPost(context, "driver/service/wait/order/accept", AcceptOrderResultBean.class, params, handler, true);
    }

    @Override
    public void driverRejectOrder(Context context, RejectOrderBean params, HttpResponseHandler<RejectOrderResultBean> handler) {
        excutor.requestCemeteryPost(context, "driver/service/wait/order/reject", RejectOrderResultBean.class, params, handler, true);
    }

}
