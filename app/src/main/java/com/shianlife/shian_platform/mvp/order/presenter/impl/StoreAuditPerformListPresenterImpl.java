package com.shianlife.shian_platform.mvp.order.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.mvp.order.model.IStoreAuditPerformListModel;
import com.shianlife.shian_platform.mvp.order.model.impl.StoreAuditPerformListModelImpl;
import com.shianlife.shian_platform.mvp.order.presenter.IStoreAuditPerformListPresenter;
import com.shianlife.shian_platform.mvp.order.view.IStoreAuditPerformListView;

/**
 * Created by zm.
 */

public class StoreAuditPerformListPresenterImpl implements IStoreAuditPerformListPresenter {
    IStoreAuditPerformListView storeAuditPerformListView;
    IStoreAuditPerformListModel storeAuditPerformListModel;

    public StoreAuditPerformListPresenterImpl(IStoreAuditPerformListView storeAuditPerformListView) {
        this.storeAuditPerformListView = storeAuditPerformListView;
        storeAuditPerformListModel = new StoreAuditPerformListModelImpl();
    }


    @Override
    public void getAuditPerformListData() {
        StoreAuditPerformListBean params = new StoreAuditPerformListBean();
        if (storeAuditPerformListView.getOrderId() == null || storeAuditPerformListView.getOrderId() == -1) {
            storeAuditPerformListView.showToast("数据错误，请咨询客服");
            return;
        }
        params.setOrderId(storeAuditPerformListView.getOrderId());
        storeAuditPerformListModel.getAuditPerformList(storeAuditPerformListView.getContext(), params, new OnGetDataListener<StoreAuditPerformListResultBean>() {
            @Override
            public void getDataSuccess(StoreAuditPerformListResultBean result) {
                storeAuditPerformListView.getAuditPerformListSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeAuditPerformListView.getAuditPerformListFail(msg);
            }
        });
    }
}
