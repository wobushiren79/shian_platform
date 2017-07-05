package com.shianlife.shian_platform.http.imp.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.shianlife.shian_platform.base.BaseApplication;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.common.ObjectMapperFactory;
import com.shianlife.shian_platform.http.base.FileHttpResponseHandler;
import com.shianlife.shian_platform.http.imp.FileManager;
import com.shianlife.shian_platform.http.result.HrUploadFile;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadResultBean;
import com.shianlife.shian_platform.ui.activity.LoginActivity;
import com.shianlife.shian_platform.utils.LogUtils;
import com.shianlife.shian_platform.utils.PicUtils;
import com.shianlife.shian_platform.utils.SharePerfrenceUtils;
import com.shianlife.shian_platform.utils.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.codehaus.jackson.JsonNode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Request;


public class FileManagerImpl implements FileManager {
    private static FileManager manager;
    Map<String, String> header = new HashMap<>();


    private FileManagerImpl() {
        header.put("systemType", "2");
    }

    public void setCookie(String cookie) {
        header.put("Cookie", "sid=" + cookie);
    }

    public static FileManager getInstance() {
        if (manager == null) {
            manager = new FileManagerImpl();
        }
        return manager;
    }


    @Override
    public void upLoadFile(final Context context,
                           String fileClass,
                           String fileName,
                           String path,
                           final FileHttpResponseHandler<FileUpLoadResultBean> responseHandler) {
        File file = new File(path);
        file = PicUtils.scaledFile(file);
//        setCookie(Constants.sessionId);
        OkHttpUtils
                .post()
                .addFile(fileClass, fileName, file)
                .addHeader("Cookie", "sid=" + Constants.sessionId)
                .addHeader("systemType", "2")
                .url(Constants.FILE_QINIU_UPDATA)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                        if (responseHandler != null) {
                            responseHandler.onStart();
                        }
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress(progress, total, id);
                        if (responseHandler != null) {
                            responseHandler.onProgress(total, progress);
                        }
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LogUtils.LogTagV(response);
                        dataToJson(context, response, FileUpLoadResultBean.class, responseHandler);
                    }


                    @Override
                    public void onError(Call call, Exception e, int id) {
                        String errorMessage = e.getMessage();
                        LogUtils.LogTagE(errorMessage + "");
                        if (responseHandler != null) {
                            responseHandler.onError(errorMessage);
                        }
                    }
                });
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
    private <T> void dataToJson(Context context, String response, final Class<T> data, FileHttpResponseHandler<T> responseHandler) {
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
                    if (context instanceof Activity) {
                        BaseApplication.getApplication().exitAPP();
                    }
                    Intent in = new Intent(context, LoginActivity.class);
                    context.startActivity(in);
                } else {
                    onErrorCallBack(responseHandler, errorMsg, context);
                }
            } catch (Exception e) {
                onErrorCallBack(responseHandler, "", context);
            }
        }
    }

    /**
     * 异常回调
     *
     * @param response
     * @param error
     * @param context
     */
    private <T> void onErrorCallBack(FileHttpResponseHandler<T> response, String error,
                                     Context context) {
        if (response != null && error != null) {
            response.onError(error);
        }

//        if (response != null && ((context instanceof Activity) && !((Activity) context)
//                .isFinishing()) && error != null) {
//            if (showToast(context, error)) {
//                response.onError(error);
//            }
//        }
    }

    /**
     * 错误提示
     *
     * @param ctx
     * @param msg
     * @return
     */
    private boolean showToast(Context ctx, String msg) {
        boolean flag = true;
//        if (!"".equals(msg))
//            ToastUtils.showToastShort(ctx, msg);
        return flag;
    }
}
