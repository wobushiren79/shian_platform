package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IRejectOrderModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.RejectOrderModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IRejectOrderPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IRejectOrderView;

/**
 * Created by zm.
 */

public class RejectOrderPresenterImpl implements IRejectOrderPresenter {
    IRejectOrderView rejectOrderView;
    IRejectOrderModel rejectOrderModel;


    public RejectOrderPresenterImpl(IRejectOrderView rejectOrderView) {
        this.rejectOrderView = rejectOrderView;
        rejectOrderModel = new RejectOrderModelImpl();
    }


    @Override
    public void rejectOrder(long orderId) {
        RejectOrderBean params = new RejectOrderBean();
        params.setOrderId(orderId);
        rejectOrderModel.rejectOrder(rejectOrderView.getContext(), params, new OnGetDataListener<RejectOrderResultBean>() {

            @Override
            public void getDataSuccess(RejectOrderResultBean result) {
                rejectOrderView.rejectOrderSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                rejectOrderView.rejectOrderFail(msg);
            }
        });
    }
}
