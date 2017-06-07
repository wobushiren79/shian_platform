package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.ArriveDestinationBean;
import com.shianlife.shian_platform.mvp.driver.bean.ArriveDestinationResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IArriveDestinationModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.ArriveDestinationModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IArriveDestinationPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IArriveDestinationView;

/**
 * Created by zm.
 */

public class ArriveDestinationPresenterImpl implements IArriveDestinationPresenter {
    IArriveDestinationView arriveDestinationView;
    IArriveDestinationModel arriveDestinationModel;

    public ArriveDestinationPresenterImpl(IArriveDestinationView arriveDestinationView) {
        this.arriveDestinationView = arriveDestinationView;
        arriveDestinationModel = new ArriveDestinationModelImpl();
    }

    @Override
    public void arriveDestination() {
        ArriveDestinationBean params = new ArriveDestinationBean();
        arriveDestinationModel.arriveDestination(arriveDestinationView.getContext(), params, new OnGetDataListener<ArriveDestinationResultBean>() {
            @Override
            public void getDataSuccess(ArriveDestinationResultBean result) {
                arriveDestinationView.arriveDestinationSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                arriveDestinationView.arriveDestinationFail(msg);
            }
        });
    }
}
