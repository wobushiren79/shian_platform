package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.ReturnCarBean;
import com.shianlife.shian_platform.mvp.driver.bean.ReturnCarResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IReturnCarModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.ReturnCarModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IReturnCarPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IReturnCarView;

/**
 * Created by zm.
 */

public class ReturnCarPresenterImpl implements IReturnCarPresenter {
    IReturnCarView returnCarView;
    IReturnCarModel returnCarModel;

    public ReturnCarPresenterImpl(IReturnCarView returnCarView) {
        this.returnCarView = returnCarView;
        returnCarModel = new ReturnCarModelImpl();
    }

    @Override
    public void returnCar() {
        ReturnCarBean params = new ReturnCarBean();
        returnCarModel.returnCar(returnCarView.getContext(), params, new OnGetDataListener<ReturnCarResultBean>() {
            @Override
            public void getDataSuccess(ReturnCarResultBean result) {
                returnCarView.returnCarSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                returnCarView.returnCarFail(msg);
            }
        });
    }
}
