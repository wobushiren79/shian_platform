package com.shianlife.shian_platform.mvp.order.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.OrderShowResultBean;
import com.shianlife.shian_platform.mvp.order.model.IOrderShowModel;
import com.shianlife.shian_platform.mvp.order.model.impl.OrderShowModelImpl;
import com.shianlife.shian_platform.mvp.order.presenter.IOrderShowPresenter;
import com.shianlife.shian_platform.mvp.order.view.IOrderShowView;

/**
 * Created by zm.
 */

public class OrderShowPresenterImpl implements IOrderShowPresenter {
    IOrderShowModel orderShowModel;
    IOrderShowView orderShowView;

    public OrderShowPresenterImpl(IOrderShowView orderShowView) {
        this.orderShowView = orderShowView;
        orderShowModel = new OrderShowModelImpl();
    }


    @Override
    public void getOrderShowItem() {
        orderShowModel.getOrderShowItems(new OnGetDataListener<OrderShowResultBean>() {
            @Override
            public void getDataSuccess(OrderShowResultBean result) {
                orderShowView.showOrderItems(result);
            }

            @Override
            public void getDataFail(String msg) {

            }
        });
    }
}
