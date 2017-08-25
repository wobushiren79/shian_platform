package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IWaitServiceListModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.WaitServiceListModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IWaitServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IWaitServiceListView;

/**
 * Created by zm.
 */

public class WaitServiceListPresenterImpl implements IWaitServiceListPresenter {
    IWaitServiceListView waitServiceListView;
    IWaitServiceListModel waitServiceListModel;

    public WaitServiceListPresenterImpl(IWaitServiceListView waitServiceListView) {
        this.waitServiceListView = waitServiceListView;
        waitServiceListModel = new WaitServiceListModelImpl();
    }

    @Override
    public void getWaitServiceListData() {
        WaitServiceListBean params = new WaitServiceListBean();
        params.setPageNum(waitServiceListView.getPageNum());
        params.setPageSize(waitServiceListView.getPageSize());
        waitServiceListModel.getWaitServiceListData(waitServiceListView.getContext(), params, new OnGetDataListener<WaitServiceListResultBean>() {

            @Override
            public void getDataSuccess(WaitServiceListResultBean result) {
                waitServiceListView.getWaitServiceListSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                waitServiceListView.getWaitServiceListFail(msg);
            }
        });
    }
}
