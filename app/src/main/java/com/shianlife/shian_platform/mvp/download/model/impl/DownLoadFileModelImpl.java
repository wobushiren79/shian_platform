package com.shianlife.shian_platform.mvp.download.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.FileHttpResponseHandler;
import com.shianlife.shian_platform.mvp.base.OnDownLoadDataListener;
import com.shianlife.shian_platform.mvp.download.bean.DownLoadFileBean;
import com.shianlife.shian_platform.mvp.download.bean.DownLoadFileResultBean;
import com.shianlife.shian_platform.mvp.download.model.IDownLoadFileModel;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;

/**
 * Created by zm.
 */

public class DownLoadFileModelImpl implements IDownLoadFileModel {

    @Override
    public RequestCall startDownLoadFile(Context context, DownLoadFileBean params, final OnDownLoadDataListener listener) {
        String downloadUrl = params.getDownloadUrl();
        String fileName = params.getFileName();
        RequestCall call = MHttpManagerFactory.getFileManager().downloadFile(context, downloadUrl, fileName, new FileHttpResponseHandler<File>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(File file) {
                DownLoadFileResultBean resultBean = new DownLoadFileResultBean();
                resultBean.setDownloadFile(file);
                listener.getDataSuccess(resultBean);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }

            @Override
            public void onProgress(long total, float progress) {
                listener.downloadInProgress(total, progress);
            }
        });
        return call;
    }

}
