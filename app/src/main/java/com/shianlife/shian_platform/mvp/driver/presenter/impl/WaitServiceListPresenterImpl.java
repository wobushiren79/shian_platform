package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IWaitServiceListModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.WaitServiceListModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IWaitServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IWaitServiceListView;

import java.util.ArrayList;
import java.util.List;

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
        waitServiceListModel.getWaitServiceListData(waitServiceListView.getContext(), params, new OnGetDataListener<WaitServiceListResultBean>() {

            @Override
            public void getDataSuccess(WaitServiceListResultBean result) {


                WaitServiceListResultBean ceshi = new WaitServiceListResultBean();
                List<WaitServiceListResultBean.WaitServiceItemData> ceshiList = new ArrayList<WaitServiceListResultBean.WaitServiceItemData>();
                for (int i = 0; i < 100; i++) {
                    ceshiList.add(new WaitServiceListResultBean.WaitServiceItemData());
                }
                ceshi.setItems(ceshiList);


                waitServiceListView.getWaitServiceListSuccess(ceshi);
            }

            @Override
            public void getDataFail(String msg) {
                waitServiceListView.getWaitServiceListFail(msg);
            }
        });
    }
}
