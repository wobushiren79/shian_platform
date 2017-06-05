package com.shianlife.shian_platform.mvp.fileup.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadBean;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadResultBean;
import com.shianlife.shian_platform.mvp.fileup.presenter.OnFileUpLoadProgressListener;

/**
 * Created by zm.
 */

public interface IFileUpLoadModel {
    /**
     * 文件上传
     *
     * @param context
     * @param params
     * @param listener
     */
    void fileUpLoad(Context context, FileUpLoadBean params, OnGetDataListener<FileUpLoadResultBean> listener, OnFileUpLoadProgressListener progressListener);
}
