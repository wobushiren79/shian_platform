package com.shianlife.shian_platform.mvp.order.presenter.impl;


import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderGetPerformBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderGetPerformResultBean;
import com.shianlife.shian_platform.mvp.order.model.IStoreOrderGetPerformModel;
import com.shianlife.shian_platform.mvp.order.model.impl.StoreOrderGetPerformModelImpl;
import com.shianlife.shian_platform.mvp.order.presenter.IStoreOrderGetPerformPresenter;
import com.shianlife.shian_platform.mvp.order.view.IStoreOrderGetPerformView;

/**
 * Created by zm.
 */

public class StoreOrderGetPerformPresenterImpl implements IStoreOrderGetPerformPresenter {
    IStoreOrderGetPerformView storeOrderGetPerformView;
    IStoreOrderGetPerformModel storeOrderGetPerformModel;

    public StoreOrderGetPerformPresenterImpl(IStoreOrderGetPerformView storeOrderGetPerformView) {
        this.storeOrderGetPerformView = storeOrderGetPerformView;
        storeOrderGetPerformModel = new StoreOrderGetPerformModelImpl();
    }


    @Override
    public void getPerformInfo(Long performId) {
        StoreOrderGetPerformBean params = new StoreOrderGetPerformBean();
        params.setPerformId(performId);
        storeOrderGetPerformModel.getPerformInfo(storeOrderGetPerformView.getContext(), params, new OnGetDataListener<StoreOrderGetPerformResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderGetPerformResultBean result) {
                storeOrderGetPerformView.getPerformInfoSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderGetPerformView.getPerformInfoFail(msg);
            }
        });
    }
}
