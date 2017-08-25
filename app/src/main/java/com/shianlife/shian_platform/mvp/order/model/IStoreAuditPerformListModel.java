package com.shianlife.shian_platform.mvp.order.model;

        import android.content.Context;

        import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
        import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListBean;
        import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListResultBean;

/**
 * Created by zm.
 */

public interface IStoreAuditPerformListModel {
    void getAuditPerformList(Context context, StoreAuditPerformListBean params, OnGetDataListener<StoreAuditPerformListResultBean> listener);
}
