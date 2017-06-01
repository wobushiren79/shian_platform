package com.shianlife.shian_platform.mvp.main.presenter.impl;

import com.shianlife.shian_platform.appenum.APPTypeEnum;
import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateBean;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;
import com.shianlife.shian_platform.mvp.main.model.IAppUpDateModel;
import com.shianlife.shian_platform.mvp.main.model.impl.AppUpDateModelImpl;
import com.shianlife.shian_platform.mvp.main.presenter.IAppUpDatePresenter;
import com.shianlife.shian_platform.mvp.main.view.IAppUpDateView;

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
        appUpDateModel.getAppUpDateInfo(appUpDateView.getContext(), params, new OnGetDataListener<AppUpDateResultBean>() {
            @Override
            public void getDataSuccess(AppUpDateResultBean result) {
                appUpDateView.getAppUpDateInfoSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                appUpDateView.getAppUpDateInfoFail(msg);
            }
        });
    }
}
