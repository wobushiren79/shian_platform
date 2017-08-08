package com.shianlife.shian_platform.mvp.order.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformSubmitResultBean;

/**
 * Created by zm.
 */

public interface IStoreAuditPerformSubmitView {
    Context getContext();

    void submitAuditPerformSuccess(StoreAuditPerformSubmitResultBean resultBean);

    void submitAuditPerformFail(String msg);

    Long getPerformId();

    String getAuditInfo();

    Integer getAuditResult();

    void showToast(String msg);
}
