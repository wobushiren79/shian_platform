package com.shianlife.shian_platform.mvp.fileup.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.FileHttpResponseHandler;
import com.shianlife.shian_platform.http.result.HrUploadFile;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadBean;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadResultBean;
import com.shianlife.shian_platform.mvp.fileup.model.IFileUpLoadModel;
import com.shianlife.shian_platform.mvp.fileup.presenter.OnFileUpLoadProgressListener;

/**
 * Created by zm.
 */

public class FileUpLoadModelImpl implements IFileUpLoadModel {
    @Override
    public void fileUpLoad(Context context, FileUpLoadBean params, final OnGetDataListener listener, final OnFileUpLoadProgressListener progressListener) {
        MHttpManagerFactory.getFileManager().upLoadFile(context, params.getFileClass(), params.getFileName(), params.getFilePath(), new FileHttpResponseHandler<FileUpLoadResultBean>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(FileUpLoadResultBean hrUploadFile) {
                listener.getDataSuccess(hrUploadFile);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }

            @Override
            public void onProgress(long total, float progress) {
                progressListener.onProgress(total, progress);
            }
        });
    }
}
