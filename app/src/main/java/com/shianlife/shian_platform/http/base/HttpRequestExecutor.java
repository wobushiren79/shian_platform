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
import com.shianlife.shian_platform.ui.activity.LoginActivity;
import com.shianlife.shian_platform.utils.CheckUtils;
import com.shianlife.shian_platform.utils.LogUtils;
import com.shianlife.shian_platform.utils.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostStringBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import org.codehaus.jackson.JsonNode;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Request;


/**
 * Created by Administrator on 2017/4/3.
 */

public class HttpRequestExecutor {
    CustomDialog dialog;

    /**
     * PHP接口get请求
     *
     * @param context
     * @param method
     * @param data
     * @param params
     * @param responseHandler
     * @param <T>
     */
    public <T> void requestPHPGet(final Context context,
                                  final String method,
                                  final Class<T> data,
                                  final BaseHttpParams params,
                                  final HttpResponseHandler<T> responseHandler,
                                  final boolean isShowDialog) {
        String baseUrl = Constants.PHP_URL;
        String cookie = "";
        Map<String, String> header = setHeader(cookie);
        requestGet(context, method, data, params, responseHandler, isShowDialog, baseUrl, header);
    }

    public <T> void requestGet(final Context context,
                               final String method,
                               final Class<T> data,
                               final BaseHttpParams params,
                               final HttpResponseHandler<T> responseHandler,
                               final boolean isShowDialog,
                               final String baseUrl,
                               final Map<String, String> header) {
        if (checkNetWorkAndDialog(context, responseHandler, isShowDialog)) return;

        LogUtils.LogTagI(baseUrl + "/" + method);
        LogUtils.LogTagE(params.getContentJson());

        GetBuilder getBuilder = OkHttpUtils.get();
        getBuilder.url(baseUrl + "/" + method);
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
    public <T> void requestCemeteryPost(final Context context,
                                        final String method,
                                        final Class<T> data,
                                        final BaseHttpParams params,
                                        final HttpResponseHandler<T> responseHandler) {
        boolean isShowDialog = false;
        String baseUrl = Constants.CEMETERY_URL;
        String cookie = "";
        if (!method.contains("doLogin/marketing") && Constants.userCemetery != null) {
            cookie = Constants.userCemetery.getSessionId();
        }
        Map<String, String> header = setHeader(cookie);
        requestPost(context, method, data, params, responseHandler, isShowDialog, baseUrl, header);
    }


    public <T> void requestPost(final Context context,
                                final String method,
                                final Class<T> data,
                                final BaseHttpParams params,
                                final HttpResponseHandler<T> responseHandler,
                                final boolean isShowDialog,
                                final String baseUrl,
                                final Map<String, String> header) {
        if (checkNetWorkAndDialog(context, responseHandler, isShowDialog)) return;

        LogUtils.LogTagI(baseUrl + "/" + method);
        LogUtils.LogTagE(params.getContentJson());

        PostStringBuilder getBuilder = OkHttpUtils.postString();
        getBuilder.url(baseUrl + "/" + method);
        getBuilder.headers(header);
        getBuilder.content(params.getContentJson());
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
     * 设置头
     *
     * @return
     */
    @NonNull
    private Map<String, String> setHeader(String cookie) {
        Map<String, String> header = new HashMap<>();
        header.put("systemType", "2");
        header.put("Content-Type", "application/json");
        if (cookie != null && !cookie.isEmpty()) {
            header.put("Cookie", "sid=" + cookie);
        }
        return header;
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
        if (response != null && ((context instanceof Activity) && !((Activity) context)
                .isFinishing()) && error != null) {
            if (showToast(context, error)) {
                response.onError(error);
            }
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
                String code = node.findValue("code").toString();
                String errorMsg = node.findValue("message").toString();
                if ("1000".equals(code)) {
                    JsonNode jn = node.findValue("content");
                    if (jn == null)
                        responseHandler.onSuccess(null);
                    else {
                        T result = ObjectMapperFactory.getInstance().readValue(
                                jn, data);
                        responseHandler.onSuccess(result);
                    }
                } else if ("1009".equals(code)) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                } else {
                    onErrorCallBack(responseHandler, errorMsg, context);
                }
            } catch (Exception e) {
                onErrorCallBack(responseHandler, "", context);
            }
        }
    }

}
