package com.shianlife.shian_platform.mvp.ordercenter.view;

import com.shianlife.shian_platform.mvp.base.BaseMVPView;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListResultBean;

/**
 * Created by zm.
 */

public interface IOrderCenterAuditListView extends BaseMVPView {
    void getOrderCenterAuditListDataSuccess(OrderCenterAuditListResultBean resultBean);

    void getOrderCenterAuditListDataFail(String msg);

    Integer getPageNumber();

    Integer getPageSize();

    Integer getListType();
}
