package com.shianlife.shian_platform.mvp.order.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformSubmitBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformSubmitResultBean;

/**
 * Created by zm.
 */

public interface IStoreAuditPerformSubmitModel {
    void submitAuditPerform(Context context, StoreAuditPerformSubmitBean params, OnGetDataListener<StoreAuditPerformSubmitResultBean> listener);
}
