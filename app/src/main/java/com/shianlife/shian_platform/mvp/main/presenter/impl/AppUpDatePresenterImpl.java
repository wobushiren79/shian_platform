package com.shianlife.shian_platform.mvp.main.presenter.impl;

import android.content.DialogInterface;
import android.content.Intent;

import com.shianlife.shian_platform.appenum.APPTypeEnum;
import com.shianlife.shian_platform.appenum.UpDataImportantEnum;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateBean;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;
import com.shianlife.shian_platform.mvp.main.model.IAppUpDateModel;
import com.shianlife.shian_platform.mvp.main.model.impl.AppUpDateModelImpl;
import com.shianlife.shian_platform.mvp.main.presenter.IAppUpDatePresenter;
import com.shianlife.shian_platform.mvp.main.presenter.OnAppUpDateListener;
import com.shianlife.shian_platform.mvp.main.view.IAppUpDateView;
import com.shianlife.shian_platform.service.UpDataService;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

/**
 * Created by zm.
 */

public class AppUpDatePresenterImpl implements IAppUpDatePresenter {
    IAppUpDateView appUpDateView;
    IAppUpDateModel appUpDateModel;

    public AppUpDatePresenterImpl(IAppUpDateView appUpDateView) {
        this.appUpDateView = appUpDateView;
        appUpDateModel = new AppUpDateModelImpl();
    }

    @Override
    public void getAppUpDateInfo() {
        AppUpDateBean params = new AppUpDateBean();
        params.setAppId(APPTypeEnum.PLATFORM.getCode());
        appUpDateModel.getAppUpDateInfo(appUpDateView.getContext(), params, new OnAppUpDateListener() {
            @Override
            public void getAppUpDateSuccess(final BaseDataResult result) {
                appUpDateView.getAppUpDateInfoSuccess(result);
            }

            @Override
            public void getAppUpDateFail(String msg) {
                appUpDateView.getAppUpDateInfoFail(msg);
            }
        });
    }
}
