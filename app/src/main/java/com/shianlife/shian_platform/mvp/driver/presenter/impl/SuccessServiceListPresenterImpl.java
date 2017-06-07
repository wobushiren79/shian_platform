package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.ISuccessServiceListModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.SuccessServiceListModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.ISuccessServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.view.ISuccessServiceListView;

import java.util.ArrayList;
import java.util.List;

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
        successServiceListModel.getSuccessServiceListData(successServiceListView.getContext(), params, new OnGetDataListener<SuccessServiceListResultBean>() {
            @Override
            public void getDataSuccess(SuccessServiceListResultBean result) {
                SuccessServiceListResultBean ceshi = new SuccessServiceListResultBean();
                List<SuccessServiceListResultBean.SuccessServiceItemData> ceshiList = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    ceshiList.add(new SuccessServiceListResultBean.SuccessServiceItemData());
                }
                ceshi.setItems(ceshiList);
                successServiceListView.getSuccessServiceListSuccess(ceshi);
            }

            @Override
            public void getDataFail(String msg) {
                successServiceListView.getSuccessServiceListFail(msg);
            }
        });
    }
}
