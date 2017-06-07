package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.GetOnCarBean;
import com.shianlife.shian_platform.mvp.driver.bean.GetOnCarResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IGetOnCarModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.GetOnCarModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IGetOnCarPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IGetOnCarView;

/**
 * Created by zm.
 */

public class GetOnCarPresenterImpl implements IGetOnCarPresenter {
    IGetOnCarView getOnCarView;
    IGetOnCarModel getOnCarModel;

    public GetOnCarPresenterImpl(IGetOnCarView getOnCarView) {
        this.getOnCarView = getOnCarView;
        getOnCarModel = new GetOnCarModelImpl();
    }

    @Override
    public void getOnCar() {
        GetOnCarBean params = new GetOnCarBean();
        getOnCarModel.getOnCar(getOnCarView.getContext(), params, new OnGetDataListener<GetOnCarResultBean>() {
            @Override
            public void getDataSuccess(GetOnCarResultBean result) {
                getOnCarView.getOnCarSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                getOnCarView.getOnCarFail(msg);
            }
        });
    }
}
