package com.shianlife.shian_platform.http.base;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.common.ObjectMapperFactory;
import com.shianlife.shian_platform.custom.dialog.CustomDialog;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadResultBean;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;
import com.shianlife.shian_platform.mvp.login.presenter.IUserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.presenter.impl.UserLoginPresenterImpl;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginView;
import com.shianlife.shian_platform.ui.activity.LoginActivity;
import com.shianlife.shian_platform.utils.CheckUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.LogUtils;
import com.shianlife.shian_platform.utils.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.HeadBuilder;
import com.zhy.http.okhttp.builder.PostStringBuilder;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import org.codehaus.jackson.JsonNode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Administrator on 2017/4/3.
 */

public class HttpRequestExecutor implements IUserLoginView {
    private CustomDialog dialog;
    private Context context;
    private IUserLoginPresenter userLoginPresenter;

    /**
     * get请求
     *
     * @param context
     * @param method
     * @param data
     * @param params
     * @param responseHandler
     * @param <T>
     */
    public <T> void requestGet(final Context context,
                               final String method,
                               final Class<T> data,
                               final BaseHttpParams params,
                               final HttpResponseHandler<T> responseHandler,
                               final boolean isShowDialog,
                               final String baseUrl,
                               final Map<String, String> header) {
        this.context = context;
        if (checkNetWorkAndDialog(context, responseHandler, isShowDialog)) return;

        LogUtils.LogTagI(baseUrl + "/" + method);
        LogUtils.LogTagE(params.getContentJson());

        GetBuilder getBuilder = OkHttpUtils.get();
        getBuilder.url(baseUrl + "/" + method);
        getBuilder.addHeader("client-Type", "wechatapp");
        if (header != null)
            getBuilder.headers(header);
        getBuilder.params(params.getMapParams());
        RequestCall requestCall = getBuilder.build();
        requestCall.execute(new StringCallback() {
            @Override
            public void onBefore(Request request, int id) {
                super.onBefore(request, id);
                if (responseHandler != null) {
                    responseHandler.onStart(request, id);
                }
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                String errorMessage = e.getMessage();
                onErrorCallBack(responseHandler, errorMessage, context);
                if (dialog != null)
                    dialog.cancel();
                dialog = null;
            }

            @Override
            public void onResponse(String response, int id) {
                LogUtils.LogTagI(response);
                dataToJson(context, response, data, responseHandler);
                if (dialog != null)
                    dialog.cancel();
                dialog = null;
            }

        });
    }


    /**
     * POST请求
     *
     * @param context
     * @param method
     * @param data
     * @param params
     * @param responseHandler
     * @param <T>
     */
    public <T> void requestPost(final Context context,
                                final String method,
                                final Class<T> data,
                                final BaseHttpParams params,
                                final HttpResponseHandler<T> responseHandler,
                                final boolean isShowDialog,
                                final String baseUrl,
                                final Map<String, String> header) {
        this.context = context;
        if (checkNetWorkAndDialog(context, responseHandler, isShowDialog)) return;

        LogUtils.LogTagI(baseUrl + "/" + method);
        LogUtils.LogTagE(params.getContentJson());

        PostStringBuilder getBuilder = OkHttpUtils.postString();
        getBuilder.url(baseUrl + "/" + method);
        if (header != null)
            getBuilder.headers(header);
        getBuilder.mediaType(MediaType.parse("application/json; charset=utf-8"));
        getBuilder.content(params.getContentJson());
        getBuilder.addHeader("client-Type", "wechatapp");
        RequestCall requestCall = getBuilder.build();
        requestCall.execute(new StringCallback() {
            @Override
            public void onBefore(Request request, int id) {
                super.onBefore(request, id);
                if (responseHandler != null) {
                    responseHandler.onStart(request, id);
                }
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                String errorMessage = e.getMessage();
                onErrorCallBack(responseHandler, errorMessage, context);
                if (dialog != null)
                    dialog.cancel();
                dialog = null;
            }

            @Override
            public void onResponse(String response, int id) {
                LogUtils.LogTagI(response);
                dataToJson(context, response, data, responseHandler);
                if (dialog != null)
                    dialog.cancel();
                dialog = null;
            }

        });

    }


    /**
     * 检测网络和弹窗
     *
     * @param context
     * @param responseHandler
     * @param isShowDialog
     * @param <T>
     * @return
     */
    private <T> boolean checkNetWorkAndDialog(Context context, HttpResponseHandler<T> responseHandler, boolean isShowDialog) {
        if (!CheckUtils.isNetworkConnected(context)) {
            onErrorCallBack(responseHandler, context.getString(R.string.network_state), context);
            return true;
        }
        if (isShowDialog && dialog == null) {
            dialog = new CustomDialog(context);
            dialog.show();
        }
        return false;
    }


    /**
     * 异常回调
     *
     * @param response
     * @param error
     * @param context
     */
    private <T> void onErrorCallBack(HttpResponseHandler<T> response, String error,
                                     Context context) {
        if (response != null && error != null) {
//            if (showToast(context, error)) {
            response.onError(error);
            if (error.contains("405") || error.contains("503")) {
                jumpLogin(context);
            }
//            }
        }
    }

    /**
     * 错误提示
     *
     * @param context
     * @param msg
     * @return
     */
    private boolean showToast(Context context, String msg) {
        boolean flag = true;
        if (!"".equals(msg))
            ToastUtils.showToastShort(context, msg);
        return flag;
    }

    /**
     * 数据处理
     *
     * @param context
     * @param response
     * @param data
     * @param responseHandler
     * @param <T>
     */
    private <T> void dataToJson(Context context, String response, final Class<T> data, HttpResponseHandler<T> responseHandler) {
        if (response != null) {
            try {
                JsonNode node = ObjectMapperFactory.getInstance().readTree(new String(response));
                if (node.findValue("code") == null || node.findValue("code").toString().equals("1500")) {
//                    onErrorCallBack(responseHandler, "会话失效，请重新登陆", context);
//                    jumpLogin(context);
                    userLoginPresenter = new UserLoginPresenterImpl(HttpRequestExecutor.this, null);
                    userLoginPresenter.getLoginConfig();
                    return;
                }
                String code = node.findValue("code").toString();
                String errorMsg = node.findValue("message").toString();
                if ("1000".equals(code)) {
                    JsonNode jn = node.findValue("content");
                    if (jn == null)
                        responseHandler.onSuccess(null);
                    else {
                        T result;
                        try {
                            result = ObjectMapperFactory.getInstance().readValue(jn, data);
                        } catch (Exception e) {
                            result = null;
                            e.printStackTrace();
                        }
                        if (result == null) {
                            responseHandler.onSuccess(null);
                        } else {
                            responseHandler.onSuccess(result);
                        }
                    }
                } else if ("1009".equals(code) || "9999".equals(code)) {
//                    jumpLogin(context);
                    userLoginPresenter = new UserLoginPresenterImpl(HttpRequestExecutor.this, null);
                    userLoginPresenter.getLoginConfig();
                } else {
                    onErrorCallBack(responseHandler, errorMsg, context);
                }
            } catch (Exception e) {
                onErrorCallBack(responseHandler, "", context);
            }
        }
    }

    private void jumpLogin(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    //---------会话失效之后的自动登陆----------------------
    private String userName;
    private String passWord;
    private boolean isAutoLogin;
    private boolean isKeepAccount;

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassWord() {
        return passWord;
    }

    @Override
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean getIsAutoLogin() {
        return isAutoLogin;
    }

    @Override
    public void setIsAutoLogin(boolean isAutoLogin) {
        this.isAutoLogin = isAutoLogin;
    }

    @Override
    public boolean getIsKeepAccount() {
        return isKeepAccount;
    }

    @Override
    public void setIsKeepAccount(boolean isKeepAccount) {
        this.isKeepAccount = isKeepAccount;
        userLoginPresenter.loginSystem();
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void loginSystemSuccess(SystemLoginResultBean result) {
        ToastUtils.showToastShort(context, "已重新登陆，请再次操作");
    }

    @Override
    public void loginSystemFail(String message) {
        jumpLogin(context);
    }
}
