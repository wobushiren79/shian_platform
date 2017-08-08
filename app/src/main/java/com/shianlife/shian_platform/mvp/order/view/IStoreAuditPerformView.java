package com.shianlife.shian_platform.mvp.order.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformResultBean;

import java.util.List;

/**
 * Created by zm.
 */

public interface IStoreAuditPerformView {
    Context getContext();

    void getStoreAuditPerformSuccess(StoreAuditPerformResultBean resultBean);

    void getStoreAuditPerformFail(String msg);

    Long getPerformId();

    void showToast(String msg);

    void setAuditPerformPic(List<String> urls);

    void setAuditPerformContent(String msg);
}
