package com.shianlife.shian_platform.mvp.ordercenter.view;

import com.shianlife.shian_platform.mvp.base.BaseMVPView;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditResultBean;

/**
 * Created by zm.
 */

public interface IOrderCenterSubmitAuditView extends BaseMVPView {
    void submitOrderCenterAuditSuccess(OrderCenterSubmitAuditResultBean resultBean);

    void submitOrderCenterAuditFail(String msg);

    Long getOrderId();

    String getAuditSummary();

    String getAuditPic();

}
