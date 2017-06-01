package com.shianlife.shian_platform.mvp.dynamic.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicBean;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicResultBean;
import com.shianlife.shian_platform.mvp.dynamic.model.IDynamicModel;
import com.shianlife.shian_platform.mvp.dynamic.model.impl.DynamicModelImpl;
import com.shianlife.shian_platform.mvp.dynamic.presenter.IDynamicPresenter;
import com.shianlife.shian_platform.mvp.dynamic.view.IDynamicView;

/**
 * Created by zm.
 */

public class DynamicPresenterImpl implements IDynamicPresenter {
    IDynamicView dynamicView;
    IDynamicModel dynamicModel;

    public DynamicPresenterImpl(IDynamicView dynamicView) {
        this.dynamicView = dynamicView;
        dynamicModel = new DynamicModelImpl();
    }

    @Override
    public void getDynamicData() {
        DynamicBean params = new DynamicBean();
        params.setNumber(dynamicView.getPagerSize());
        params.setPagerNumber(dynamicView.getPagerNum());
        dynamicModel.getDynamicData(dynamicView.getContext(), params, new OnGetDataListener<DynamicResultBean>() {

            @Override
            public void getDataSuccess(DynamicResultBean result) {
                dynamicView.showData(result);
            }

            @Override
            public void getDataFail(String msg) {
                dynamicView.showMsg(msg);
            }
        });
    }
}
