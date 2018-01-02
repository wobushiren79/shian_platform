package com.shianlife.shian_platform.mvp.download.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnDownLoadDataListener;
import com.shianlife.shian_platform.mvp.download.bean.DownLoadFileBean;
import com.zhy.http.okhttp.request.RequestCall;


/**
 * Created by zm.
 */

public interface IDownLoadFileModel {
    RequestCall startDownLoadFile(Context context, DownLoadFileBean params, OnDownLoadDataListener listener);
}
