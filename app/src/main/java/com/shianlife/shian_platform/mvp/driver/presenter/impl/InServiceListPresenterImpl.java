package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IInServiceListModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.InServiceListModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IInServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IInServiceListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zm.
 */

public class InServiceListPresenterImpl implements IInServiceListPresenter {
    IInServiceListView inServiceListView;
    IInServiceListModel inServiceListModel;

    public InServiceListPresenterImpl(IInServiceListView inServiceListView) {
        this.inServiceListView = inServiceListView;
        inServiceListModel = new InServiceListModelImpl();
    }

    @Override
    public void getInServiceListData() {
        InServiceListBean params = new InServiceListBean();
        inServiceListModel.getInServiceListData(inServiceListView.getContext(), params, new OnGetDataListener<InServiceListResultBean>() {
            @Override
            public void getDataSuccess(InServiceListResultBean result) {
                InServiceListResultBean ceshi = new InServiceListResultBean();
                List<InServiceListResultBean.InServiceItemData> ceshiList = new ArrayList<InServiceListResultBean.InServiceItemData>();
                for (int i = 0; i < 100; i++) {
                    ceshiList.add(new InServiceListResultBean.InServiceItemData());
                }
                ceshi.setItems(ceshiList);
                inServiceListView.getInServiceListSuccess(ceshi);
            }

            @Override
            public void getDataFail(String msg) {
                inServiceListView.getInServiceListFail(msg);
            }
        });
    }
}
