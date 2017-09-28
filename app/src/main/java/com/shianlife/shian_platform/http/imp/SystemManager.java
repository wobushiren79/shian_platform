package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginOutBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginOutResultBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.ChangePassWordSMSBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.ChangePassWordSMSResultBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralListBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralListResultBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralResultBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoSignBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoSignResultBean;

/**
 * Created by zm.
 */

public interface SystemManager {

    /**
     * 登陆系统
     *
     * @param context
     * @param params
     * @param handler
     */
    void loginSystem(Context context, SystemLoginBean params, HttpResponseHandler<SystemLoginResultBean> handler);

    /**
     * 退出登陆
     * @param context
     * @param params
     * @param handler
     */
    void loginOutSystem(Context context, SystemLoginOutBean params, HttpResponseHandler<SystemLoginOutResultBean> handler);

    /**
     * 单项系统登陆
     *
     * @param context
     * @param loginKey
     */
    void loginStoreSystem(Context context, String loginKey);


    /**
     * 用户签到
     *
     * @param context
     * @param params
     * @param handler
     */
    void userInfoSign(Context context, UserInfoSignBean params, HttpResponseHandler<UserInfoSignResultBean> handler);

    /**
     * 获取签到积分
     *
     * @param context
     * @param params
     * @param handler
     */
    void getUserInfoIntegral(Context context, UserInfoIntegralBean params, HttpResponseHandler<UserInfoIntegralResultBean> handler);


    /**
     * 获取签到积分列表
     *
     * @param context
     * @param params
     * @param handler
     */
    void getUserInfoListIntegral(Context context, UserInfoIntegralListBean params, HttpResponseHandler<UserInfoIntegralListResultBean> handler);

    /**
     * 通过短信修改密码
     *
     * @param context
     * @param params
     * @param handler
     */
    void changePassWordSMS(Context context, ChangePassWordSMSBean params, HttpResponseHandler<ChangePassWordSMSResultBean> handler);
}
