package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsBean;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IOrderDetailsModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.OrderDetailsModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IOrderDetailsPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IOrderDetailsView;

/**
 * Created by zm.
 */

public class OrderDetailsPresenterImpl implements IOrderDetailsPresenter {
    IOrderDetailsView orderDetailsView;
    IOrderDetailsModel orderDetailsModel;

    public OrderDetailsPresenterImpl(IOrderDetailsView orderDetailsView) {
        this.orderDetailsView = orderDetailsView;
        orderDetailsModel = new OrderDetailsModelImpl();
    }

    @Override
    public void getOrderDeails() {
        OrderDetailsBean params = new OrderDetailsBean();
        params.setOrderId(orderDetailsView.getOrderId());
        orderDetailsModel.getOrderDetails(orderDetailsView.getContext(), params, new OnGetDataListener<OrderDetailsResultBean>() {
            @Override
            public void getDataSuccess(OrderDetailsResultBean result) {
                orderDetailsView.getOrderDetailsSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                orderDetailsView.getOrderDetailsFail(msg);
            }
        });
    }
}
