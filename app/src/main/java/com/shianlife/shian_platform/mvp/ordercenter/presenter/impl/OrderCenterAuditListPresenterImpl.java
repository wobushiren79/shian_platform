package com.shianlife.shian_platform.mvp.ordercenter.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.model.IOrderCenterAuditListModel;
import com.shianlife.shian_platform.mvp.ordercenter.model.impl.OrderCenterAuditListModelImpl;
import com.shianlife.shian_platform.mvp.ordercenter.presenter.IOrderCenterAuditListPresenter;
import com.shianlife.shian_platform.mvp.ordercenter.view.IOrderCenterAuditListView;

/**
 * Created by zm.
 */

public class OrderCenterAuditListPresenterImpl implements IOrderCenterAuditListPresenter {
    private IOrderCenterAuditListView orderCenterAuditListView;
    private IOrderCenterAuditListModel orderCenterAuditListModel;


    public OrderCenterAuditListPresenterImpl(IOrderCenterAuditListView orderCenterAuditListView) {
        this.orderCenterAuditListView = orderCenterAuditListView;
        orderCenterAuditListModel = new OrderCenterAuditListModelImpl();
    }

    @Override
    public void getOrderCenterAuditListData() {
        if (orderCenterAuditListView.getContext() == null) {
            orderCenterAuditListView.showToast("没有上下文对象");
            return;
        }
        if (orderCenterAuditListView.getPageNumber() == null) {
            orderCenterAuditListView.showToast("没有PageNumber");
            return;
        }
        if (orderCenterAuditListView.getPageSize() == null) {
            orderCenterAuditListView.showToast("没有PageSize");
            return;
        }
        if (orderCenterAuditListView.getListType() == null) {
            orderCenterAuditListView.showToast("没有列表类型");
            return;
        }

        OrderCenterAuditListBean params = new OrderCenterAuditListBean();
        params.setPageNumber(orderCenterAuditListView.getPageNumber());
        params.setPageSize(orderCenterAuditListView.getPageSize());
        OrderCenterAuditListBean.Params item = new OrderCenterAuditListBean.Params();
        item.setListType(orderCenterAuditListView.getListType());
        params.setParams(item);
        orderCenterAuditListModel.getAuditListData(orderCenterAuditListView.getContext(), params, new OnGetDataListener<OrderCenterAuditListResultBean>() {
            @Override
            public void getDataSuccess(OrderCenterAuditListResultBean result) {
                orderCenterAuditListView.getOrderCenterAuditListDataSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                orderCenterAuditListView.getOrderCenterAuditListDataFail(msg);
            }
        });
    }
}
