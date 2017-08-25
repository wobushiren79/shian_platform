package com.shianlife.shian_platform.mvp.fileup.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadBean;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadResultBean;
import com.shianlife.shian_platform.mvp.fileup.model.IFileUpLoadModel;
import com.shianlife.shian_platform.mvp.fileup.model.impl.FileUpLoadModelImpl;
import com.shianlife.shian_platform.mvp.fileup.presenter.IFileUpLoadPresenter;
import com.shianlife.shian_platform.mvp.fileup.presenter.OnFileUpLoadProgressListener;
import com.shianlife.shian_platform.mvp.fileup.view.IFileUpLoadView;

/**
 * Created by zm.
 */

public class FileUpLoadPresenterImpl implements IFileUpLoadPresenter {
    IFileUpLoadView fileUpLoadView;
    IFileUpLoadModel fileUpLoadModel;

    public FileUpLoadPresenterImpl(IFileUpLoadView fileUpLoadView) {
        this.fileUpLoadView = fileUpLoadView;
        fileUpLoadModel = new FileUpLoadModelImpl();
    }

    @Override
    public void fileUpLoad() {
        FileUpLoadBean params = new FileUpLoadBean();
        params.setFileClass(fileUpLoadView.getFileClass());
        params.setFileName(fileUpLoadView.getFileName());
        params.setFilePath(fileUpLoadView.getFilePath());
        fileUpLoadModel.fileUpLoad(fileUpLoadView.getContext(), params, new OnGetDataListener<FileUpLoadResultBean>() {
            @Override
            public void getDataSuccess(FileUpLoadResultBean result) {
                fileUpLoadView.fileUpLoadSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                fileUpLoadView.fileUpLoadFail(msg);
            }
        }, new OnFileUpLoadProgressListener() {
            @Override
            public void onProgress(long total, float progress) {
                fileUpLoadView.fileUpLoadProgress(total, progress);
            }
        });
    }
}
