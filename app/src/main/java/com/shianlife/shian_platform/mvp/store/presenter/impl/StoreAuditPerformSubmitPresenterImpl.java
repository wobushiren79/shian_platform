package com.shianlife.shian_platform.mvp.store.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformSubmitBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformSubmitResultBean;
import com.shianlife.shian_platform.mvp.store.model.IStoreAuditPerformSubmitModel;
import com.shianlife.shian_platform.mvp.store.model.impl.StoreAuditPerformSubmitModelImpl;
import com.shianlife.shian_platform.mvp.store.presenter.IStoreAuditPerformSubmitPresenter;
import com.shianlife.shian_platform.mvp.store.view.IStoreAuditPerformSubmitView;

/**
 * Created by zm.
 */

public class StoreAuditPerformSubmitPresenterImpl implements IStoreAuditPerformSubmitPresenter {
    IStoreAuditPerformSubmitModel storeAuditPerformSubmitModel;
    IStoreAuditPerformSubmitView storeAuditPerformSubmitView;

    public StoreAuditPerformSubmitPresenterImpl(IStoreAuditPerformSubmitView storeAuditPerformSubmitView) {
        this.storeAuditPerformSubmitView = storeAuditPerformSubmitView;
        storeAuditPerformSubmitModel = new StoreAuditPerformSubmitModelImpl();
    }

    @Override
    public void submitAuditPerform() {
        StoreAuditPerformSubmitBean params = new StoreAuditPerformSubmitBean();
        if (storeAuditPerformSubmitView.getPerformId() == null || storeAuditPerformSubmitView.getPerformId() == -1) {
            storeAuditPerformSubmitView.showToast("数据错误");
            return;
        }
        if (storeAuditPerformSubmitView.getAuditInfo().isEmpty()) {
            storeAuditPerformSubmitView.showToast("审核评价不能为空");
            return;
        }
        if (storeAuditPerformSubmitView.getAuditResult() == null || storeAuditPerformSubmitView.getAuditResult() == -1) {
            storeAuditPerformSubmitView.showToast("数据错误");
            return;
        }

        params.setPerformId(storeAuditPerformSubmitView.getPerformId());
        params.setAuditInfo(storeAuditPerformSubmitView.getAuditInfo());
        params.setAuditResult(storeAuditPerformSubmitView.getAuditResult());

        storeAuditPerformSubmitModel.submitAuditPerform(storeAuditPerformSubmitView.getContext(), params, new OnGetDataListener<StoreAuditPerformSubmitResultBean>() {
            @Override
            public void getDataSuccess(StoreAuditPerformSubmitResultBean result) {
                storeAuditPerformSubmitView.submitAuditPerformSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeAuditPerformSubmitView.submitAuditPerformFail(msg);
            }
        });
    }
}
