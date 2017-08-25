package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IFailServiceListModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.FailServiceListModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IFailServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IFailServiceListView;

/**
 * Created by zm.
 */

public class FailServiceListPresenterImpl implements IFailServiceListPresenter {

    IFailServiceListView failServiceListView;
    IFailServiceListModel failServiceListModel;

    public FailServiceListPresenterImpl(IFailServiceListView failServiceListView) {
        this.failServiceListView = failServiceListView;
        failServiceListModel = new FailServiceListModelImpl();
    }

    @Override
    public void getFailServiceListData() {
        FailServiceListBean params = new FailServiceListBean();
        params.setPageNum(failServiceListView.getPageNum());
        params.setPageSize(failServiceListView.getPageSize());
        failServiceListModel.getFailServiceListData(failServiceListView.getContext(), params, new OnGetDataListener<FailServiceListResultBean>() {
            @Override
            public void getDataSuccess(FailServiceListResultBean result) {
                failServiceListView.getFailServiceListDataSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                failServiceListView.getFailServiceListDataFail(msg);
            }
        });
    }
}
