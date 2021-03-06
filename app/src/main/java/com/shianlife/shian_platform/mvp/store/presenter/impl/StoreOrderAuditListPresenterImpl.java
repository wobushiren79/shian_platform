package com.shianlife.shian_platform.mvp.store.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderAuditListBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderAuditResultListBean;
import com.shianlife.shian_platform.mvp.store.model.IStoreOrderAuditListModel;
import com.shianlife.shian_platform.mvp.store.model.impl.StoreOrderAuditListModelImpl;
import com.shianlife.shian_platform.mvp.store.presenter.IStoreOrderAuditListPresenter;
import com.shianlife.shian_platform.mvp.store.view.IStoreOrderAuditListView;

/**
 * Created by zm.
 */

public class StoreOrderAuditListPresenterImpl implements IStoreOrderAuditListPresenter {
    IStoreOrderAuditListView storeOrderAuditListView;
    IStoreOrderAuditListModel storeOrderAuditListModel;


    public StoreOrderAuditListPresenterImpl(IStoreOrderAuditListView storeOrderAuditListView) {
        this.storeOrderAuditListView = storeOrderAuditListView;
        storeOrderAuditListModel = new StoreOrderAuditListModelImpl();
    }

    @Override
    public void getStoreOrderAuditListData() {
        StoreOrderAuditListBean params = new StoreOrderAuditListBean();
        StoreOrderAuditListBean.Content content = new StoreOrderAuditListBean.Content();
        content.setOrderStatus(storeOrderAuditListView.getOrderStatus());
        content.setPerformStatus(storeOrderAuditListView.getPerformStatus());

        params.setContent(content);
        params.setPageSize(storeOrderAuditListView.getPagerSize());
        params.setPageNumber(storeOrderAuditListView.getPagerNumber());
        storeOrderAuditListModel.getStoreOrderAuditListData(storeOrderAuditListView.getContext(), params, new OnGetDataListener<StoreOrderAuditResultListBean>() {
            @Override
            public void getDataSuccess(StoreOrderAuditResultListBean result) {
                storeOrderAuditListView.getStoreOrderAuditListSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderAuditListView.getStoreOrderAuditListFail(msg);
            }
        });
    }
}
