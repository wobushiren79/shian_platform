package com.shianlife.shian_platform.mvp.store.presenter.impl;


import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformResultBean;
import com.shianlife.shian_platform.mvp.store.model.IStoreAuditPerformModel;
import com.shianlife.shian_platform.mvp.store.model.impl.StoreAuditPerformModeImpl;
import com.shianlife.shian_platform.mvp.store.presenter.IStoreAuditPerformPresenter;
import com.shianlife.shian_platform.mvp.store.view.IStoreAuditPerformView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zm.
 */

public class StoreAuditPerformPresenterImpl implements IStoreAuditPerformPresenter {
    IStoreAuditPerformView storeAuditPerformView;
    IStoreAuditPerformModel storeAuditPerformModel;

    public StoreAuditPerformPresenterImpl(IStoreAuditPerformView storeAuditPerformView) {
        this.storeAuditPerformView = storeAuditPerformView;
        storeAuditPerformModel = new StoreAuditPerformModeImpl();
    }

    @Override
    public void getAuditPerformDetails() {
        if (storeAuditPerformView.getPerformId() == null || storeAuditPerformView.getPerformId() == -1) {
            storeAuditPerformView.showToast("数据错误");
            return;
        }
        StoreAuditPerformBean params = new StoreAuditPerformBean();
        params.setPerformId(storeAuditPerformView.getPerformId());
        storeAuditPerformModel.getStoreAuditPerformDetails(storeAuditPerformView.getContext(), params, new OnGetDataListener<StoreAuditPerformResultBean>() {
            @Override
            public void getDataSuccess(StoreAuditPerformResultBean result) {
                storeAuditPerformView.getStoreAuditPerformSuccess(result);
                storeAuditPerformView.setAuditPerformContent(result.getCompleteInfo());
                List<String> urls = new ArrayList<>();
                String[] tempUrls = new String[0];
                if (result.getCompletePic() != null) {
                    tempUrls = result.getCompletePic().split(",");
                }
                for (String url : tempUrls) {
                    urls.add(Constants.OSSURL + url);
                }
                storeAuditPerformView.setAuditPerformPic(urls);
            }

            @Override
            public void getDataFail(String msg) {
                storeAuditPerformView.getStoreAuditPerformFail(msg);
            }
        });
    }
}
