package com.shianlife.shian_platform.mvp.login.presenter.impl;

import com.shianlife.shian_platform.common.Constants;
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
        subSystemLoginModel.subSystemStoreLogin(subSystemLoginView.getContext(), Constants.System_Ki4so_Client_Ec);
    }

    @Override
    public void loginOrderCenterSystem() {
        subSystemLoginModel.subSystemOrderCenterLogin(subSystemLoginView.getContext(), Constants.System_Ki4so_Client_Ec);
    }
}
