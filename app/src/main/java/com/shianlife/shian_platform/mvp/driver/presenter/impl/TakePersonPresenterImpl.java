package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.TakePersonBean;
import com.shianlife.shian_platform.mvp.driver.bean.TakePersonResultBean;
import com.shianlife.shian_platform.mvp.driver.model.ITakePersonModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.TakePersonModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.ITakePersonPresenter;
import com.shianlife.shian_platform.mvp.driver.view.ITakePersonView;

/**
 * Created by zm.
 */

public class TakePersonPresenterImpl implements ITakePersonPresenter {

    ITakePersonView takePersonView;
    ITakePersonModel takePersonModel;

    public TakePersonPresenterImpl(ITakePersonView takePersonView) {
        this.takePersonView = takePersonView;
        takePersonModel = new TakePersonModelImpl();
    }

    @Override
    public void takePerson() {
        TakePersonBean params = new TakePersonBean();
        takePersonModel.takePerson(takePersonView.getContext(), params, new OnGetDataListener<TakePersonResultBean>() {
            @Override
            public void getDataSuccess(TakePersonResultBean result) {
                takePersonView.takePersonSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                takePersonView.takePersonFail(msg);
            }
        });
    }
}
