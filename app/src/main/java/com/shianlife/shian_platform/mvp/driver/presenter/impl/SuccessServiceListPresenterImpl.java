package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.ISuccessServiceListModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.SuccessServiceListModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.ISuccessServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.view.ISuccessServiceListView;

/**
 * Created by zm.
 */

public class SuccessServiceListPresenterImpl implements ISuccessServiceListPresenter {
    ISuccessServiceListView successServiceListView;
    ISuccessServiceListModel successServiceListModel;

    public SuccessServiceListPresenterImpl(ISuccessServiceListView successServiceListView) {
        this.successServiceListView = successServiceListView;
        successServiceListModel = new SuccessServiceListModelImpl();
    }

    @Override
    public void getSuccessServiceListData() {
        SuccessServiceListBean params = new SuccessServiceListBean();
        params.setPageNum(successServiceListView.getPageNum());
        params.setPageSize(successServiceListView.getPageSize());
        successServiceListModel.getSuccessServiceListData(successServiceListView.getContext(), params, new OnGetDataListener<SuccessServiceListResultBean>() {
            @Override
            public void getDataSuccess(SuccessServiceListResultBean result) {
                successServiceListView.getSuccessServiceListSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                successServiceListView.getSuccessServiceListFail(msg);
            }
        });
    }
}
