package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IAcceptOrderModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.AcceptOrderModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IAcceptOrderPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IAcceptOrderView;

/**
 * Created by zm.
 */

public class AcceptOrderPresenterImpl implements IAcceptOrderPresenter {
    IAcceptOrderView acceptOrderView;
    IAcceptOrderModel acceptOrderModel;

    public AcceptOrderPresenterImpl(IAcceptOrderView acceptOrderView) {
        this.acceptOrderView = acceptOrderView;
        acceptOrderModel = new AcceptOrderModelImpl();
    }


    @Override
    public void acceptOrder(long orderId) {
        AcceptOrderBean params = new AcceptOrderBean();
        params.setOrderId(orderId);
        acceptOrderModel.acceptOrder(acceptOrderView.getContext(), params, new OnGetDataListener<AcceptOrderResultBean>() {

            @Override
            public void getDataSuccess(AcceptOrderResultBean result) {
                acceptOrderView.acceptOrderSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                acceptOrderView.acceptOrderFail(msg);
            }
        });
    }
}
