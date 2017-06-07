package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IFailServiceListModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.FailServiceListModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IFailServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IFailServiceListView;

import java.util.ArrayList;
import java.util.List;

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
        failServiceListModel.getFailServiceListData(failServiceListView.getContext(), params, new OnGetDataListener<FailServiceListResultBean>() {
            @Override
            public void getDataSuccess(FailServiceListResultBean result) {
                FailServiceListResultBean ceshi = new FailServiceListResultBean();
                List<FailServiceListResultBean.FailServiceItemData> ceshiList = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    ceshiList.add(new FailServiceListResultBean.FailServiceItemData());
                }
                ceshi.setItems(ceshiList);
                failServiceListView.getFailServiceListDataSuccess(ceshi);
            }

            @Override
            public void getDataFail(String msg) {
                failServiceListView.getFailServiceListDataFail(msg);
            }
        });
    }
}
