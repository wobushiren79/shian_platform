package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IAcceptOrderModel;
import com.shianlife.shian_platform.mvp.driver.model.IRejectOrderModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.AcceptOrderModelImpl;
import com.shianlife.shian_platform.mvp.driver.model.impl.RejectOrderModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IRejectOrderPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IAcceptOrderView;
import com.shianlife.shian_platform.mvp.driver.view.IRejectOrderView;

/**
 * Created by zm.
 */

public class RejectOrderPresenterImpl implements IRejectOrderPresenter{
    IRejectOrderView rejectOrderView;
    IRejectOrderModel rejectOrderModel;


    public RejectOrderPresenterImpl(IRejectOrderView rejectOrderView) {
        this.rejectOrderView = rejectOrderView;
        rejectOrderModel = new RejectOrderModelImpl();
    }


    @Override
    public void rejectOrder() {
        RejectOrderBean params = new RejectOrderBean();
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
