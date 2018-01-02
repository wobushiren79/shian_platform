package com.shianlife.shian_platform.mvp.login.presenter.impl;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.login.model.ISubSystemLoginModel;
import com.shianlife.shian_platform.mvp.login.model.impl.SubSystemLoginModelImpl;
import com.shianlife.shian_platform.mvp.login.presenter.ISubSystemLoginPresenter;
import com.shianlife.shian_platform.mvp.login.view.ISubSystemLoginView;

/**
 * Created by zm.
 */

public class SubSystemLoginPresenterImpl implements ISubSystemLoginPresenter {

    ISubSystemLoginView subSystemLoginView;
    ISubSystemLoginModel subSystemLoginModel;

    public SubSystemLoginPresenterImpl(ISubSystemLoginView subSystemLoginView) {
        this.subSystemLoginView = subSystemLoginView;
        subSystemLoginModel = new SubSystemLoginModelImpl();
    }

    @Override
    public void loginStoreSystem() {
        subSystemLoginModel.subSystemStoreLogin(subSystemLoginView.getContext(), Constants.System_Ki4so_Client_Ec, new OnGetDataListener() {
            @Override
            public void getDataSuccess(Object result) {
                subSystemLoginView.loginGoodsSuccess();
            }

            @Override
            public void getDataFail(String msg) {
                subSystemLoginView.loginGoodsFail();
            }
        });
    }

    @Override
    public void loginOrderCenterSystem() {
        subSystemLoginModel.subSystemOrderCenterLogin(subSystemLoginView.getContext(), Constants.System_Ki4so_Client_Ec, new OnGetDataListener() {
            @Override
            public void getDataSuccess(Object result) {
                subSystemLoginView.loginOrderCenterSuccess();
            }

            @Override
            public void getDataFail(String msg) {
                subSystemLoginView.loginOrderCenterFail();
            }
        });
    }

    @Override
    public void loginCemeterySystem() {
        subSystemLoginModel.subSystemCemeteryLogin(subSystemLoginView.getContext(), Constants.System_Ki4so_Client_Ec, new OnGetDataListener() {
            @Override
            public void getDataSuccess(Object result) {
                subSystemLoginView.loginCemeterySuccess();
            }

            @Override
            public void getDataFail(String msg) {
                subSystemLoginView.loginCemeteryFail();
            }
        });
    }
}
