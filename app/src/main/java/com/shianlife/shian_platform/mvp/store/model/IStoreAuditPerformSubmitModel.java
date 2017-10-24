package com.shianlife.shian_platform.mvp.store.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformSubmitBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformSubmitResultBean;

/**
 * Created by zm.
 */

public interface IStoreAuditPerformSubmitModel {
    void submitAuditPerform(Context context, StoreAuditPerformSubmitBean params, OnGetDataListener<StoreAuditPerformSubmitResultBean> listener);
}
