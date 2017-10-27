package com.shianlife.shian_platform.mvp.ordercenter.view;

import com.shianlife.shian_platform.mvp.base.BaseMVPView;
import com.shianlife.shian_platform.mvp.ordercenter.bean.AuditRecordDetails;
import com.shianlife.shian_platform.mvp.ordercenter.bean.AuditorAssignRecord;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.PerformRecordDetails;

import java.util.List;

/**
 * Created by zm.
 */

public interface IOrderCenterDetailsView extends BaseMVPView {

    void getOrderCenterDetailsSuccess(OrderCenterDetailsResultBean resultBean);

    void getOrderCenterDetailsFail(String msg);

    Long getOrderId();

    /**
     * 设置订单编号
     *
     * @param orderCenterNumber
     */
    void setOrderCenterNumber(String orderCenterNumber);

    /**
     * 设置服务地址
     *
     * @param location
     */
    void setOrderCenterServiceLocation(String location);

    /**
     * 设置预约服务时间
     *
     * @param time
     */
    void setOrderCenterPlanTime(String time);

    /**
     * 设置订单备注
     *
     * @param remark
     */
    void setOrderCenterDescribe(String remark);

    /**
     * 设置服务类型
     *
     * @param type
     */
    void setOrderCenterServiceType(String type);

    /**
     * 设置服务目标
     *
     * @param tag
     */
    void setOrderCenterServiceTag(String tag);

    /**
     * 设置服务价格
     *
     * @param price
     */
    void setOrderCenterPrice(String price);

    /**
     * 设置联系人电话
     *
     * @param customerPhone
     */
    void setOrderCenterCustomerPhone(String customerPhone);

    /**
     * 设置联系人姓名
     *
     * @param name
     */
    void setOrderCenterCustomerName(String name);

    /**
     * 设置经办人电话
     *
     * @param agentPhone
     */
    void setOrderCenterAgentPhone(String agentPhone);

    /**
     * 设置经办人
     *
     * @param name
     */
    void setOrderCenterAgentName(String name);

    /**
     * 设置提交记录
     *
     * @param listData
     */
    void setOrderCenterPerformRecordList(List<PerformRecordDetails> listData);

    /**
     * 设置审核记录
     *
     * @param listData
     */
    void setOrderCenterAuditRecordList(List<AuditRecordDetails> listData);

}
