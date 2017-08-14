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

    private FileManagerImpl() {

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
        OkHttpUtils
                .post()
                .addFile(fileClass, fileName, file)
                .addHeader("client-Type", "androidapp")
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
                    jumpLogin(context);
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
    }
}
