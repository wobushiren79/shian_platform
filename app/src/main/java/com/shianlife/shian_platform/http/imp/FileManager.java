package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.FileHttpResponseHandler;
import com.shianlife.shian_platform.http.base.HttpManager;
import com.shianlife.shian_platform.http.result.HrUploadFile;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadResultBean;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;


public interface FileManager extends HttpManager {
    /**
     * 文件上传
     *
     * @param context
     * @param fileClass 文件分类
     * @param fileName  文件名字
     * @param path      文件路径
     * @param handler
     */
    public void upLoadFile(Context context, String fileClass, String fileName, String path, FileHttpResponseHandler<FileUpLoadResultBean> handler);

    /**
     * 文件下载
     * @param context
     * @param downloadUrl
     * @param responseHandler
     */
    public RequestCall downloadFile(Context context, String downloadUrl, final FileHttpResponseHandler<File> responseHandler);
}
