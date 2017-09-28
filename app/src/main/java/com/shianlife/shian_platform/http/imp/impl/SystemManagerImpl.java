package com.shianlife.shian_platform.http.imp.impl;

import android.content.Context;
import android.util.Log;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.dialog.CustomDialog;
import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.BaseManagerImpl;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.imp.SystemManager;
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
import com.shianlife.shian_platform.utils.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import okhttp3.Call;

/**
 * Created by zm.
 */

public class SystemManagerImpl extends BaseManagerImpl implements SystemManager {
    private static SystemManagerImpl manager;
    private CustomDialog customDialog;

    private SystemManagerImpl() {
        super();
        baseUrl = Constants.Login_BaseUrl;
    }


    public static SystemManagerImpl getInstance() {
        if (manager == null) {
            manager = new SystemManagerImpl();
        }
        return manager;
    }


    @Override
    public void loginSystem(Context context, SystemLoginBean params, HttpResponseHandler<SystemLoginResultBean> handler) {
        requestPost(context, "applogin", SystemLoginResultBean.class, params, handler);
    }

    @Override
    public void loginOutSystem(Context context, SystemLoginOutBean params, HttpResponseHandler<SystemLoginOutResultBean> handler) {
        requestPost(context, "app_logout", SystemLoginOutResultBean.class, params, handler);
    }

    @Override
    public void loginStoreSystem(final Context context, String loginKey) {
        String storeUrl = Constants.Login_Store_Url + "?" + loginKey;
        loginSubSystem(context, storeUrl);
    }

    @Override
    public void userInfoSign(Context context, UserInfoSignBean params, HttpResponseHandler<UserInfoSignResultBean> handler) {
        requestPost(context, "api/credit/checkin", UserInfoSignResultBean.class, params, handler, true);
    }

    @Override
    public void getUserInfoIntegral(Context context, UserInfoIntegralBean params, HttpResponseHandler<UserInfoIntegralResultBean> handler) {
        requestPost(context, "api/credit/getCredit", UserInfoIntegralResultBean.class, params, handler);
    }

    @Override
    public void getUserInfoListIntegral(Context context, UserInfoIntegralListBean params, HttpResponseHandler<UserInfoIntegralListResultBean> handler) {
        requestPost(context, "api/credit/queryUserCreditLogsForPage", UserInfoIntegralListResultBean.class, params, handler);
    }

    @Override
    public void changePassWordSMS(Context context, ChangePassWordSMSBean params, HttpResponseHandler<ChangePassWordSMSResultBean> handler) {
        requestPost(context, "api/usersInfo/forgetKeys", ChangePassWordSMSResultBean.class, params, handler, true);
    }

    private void loginSubSystem(final Context context, String storeUrl) {
        if (customDialog == null || !customDialog.isShowing()) {
            customDialog = new CustomDialog(context);
            customDialog.show();
        }
        Log.v("tag", "storeUrl:" + storeUrl);
        GetBuilder getBuilder = OkHttpUtils.get();
        getBuilder.url(storeUrl);
        getBuilder.addHeader("client-Type", "wechatapp");
        RequestCall requestCall = getBuilder.build();
        requestCall.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                ToastUtils.showToastShort(context, e.getMessage());
                customDialog.cancel();
                if (customDialog != null)
                    customDialog.cancel();
//                Utils.jumpLogin(context);
            }

            @Override
            public void onResponse(String response, int id) {
                Log.v("tag", "storeResponse:" + response);
                if (customDialog != null)
                    customDialog.cancel();
            }
        });
    }


}
