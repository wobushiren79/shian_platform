package com.shianlife.shian_platform.mvp.store.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformSubmitResultBean;

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
