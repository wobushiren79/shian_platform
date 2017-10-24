package com.shianlife.shian_platform.mvp.ordercenter.presenter.impl;

import com.shianlife.shian_platform.appenum.WorkOrderTypeStatusEnum;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ordercenter.bean.AuditRecordDetails;
import com.shianlife.shian_platform.mvp.ordercenter.bean.CustomerInfo;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.PerformRecordDetails;
import com.shianlife.shian_platform.mvp.ordercenter.bean.WorkOrder;
import com.shianlife.shian_platform.mvp.ordercenter.model.IOrderCenterDetailsModel;
import com.shianlife.shian_platform.mvp.ordercenter.model.impl.OrderCenterDetailsModelImpl;
import com.shianlife.shian_platform.mvp.ordercenter.presenter.IOrderCenterDetailsPresenter;
import com.shianlife.shian_platform.mvp.ordercenter.view.IOrderCenterDetailsView;

import java.util.List;

/**
 * Created by zm.
 */

public class OrderCenterDetailsPresenterImpl implements IOrderCenterDetailsPresenter {

    private IOrderCenterDetailsView orderCenterDetailsView;
    private IOrderCenterDetailsModel orderCenterDetailsModel;

    public OrderCenterDetailsPresenterImpl(IOrderCenterDetailsView orderCenterDetailsView) {
        this.orderCenterDetailsView = orderCenterDetailsView;
        orderCenterDetailsModel = new OrderCenterDetailsModelImpl();
    }

    @Override
    public void getOrderCenterDetails() {
        if (orderCenterDetailsView.getContext() == null) {
            orderCenterDetailsView.showToast("没有上下文对象");
            return;
        }
        if (orderCenterDetailsView.getOrderId() == null) {
            orderCenterDetailsView.showToast("订单ID为空");
            return;
        }
        OrderCenterDetailsBean params = new OrderCenterDetailsBean();
        params.setOrderId(orderCenterDetailsView.getOrderId());
        orderCenterDetailsModel.getOrderCenterDetails(orderCenterDetailsView.getContext(), params, new OnGetDataListener<OrderCenterDetailsResultBean>() {
            @Override
            public void getDataSuccess(OrderCenterDetailsResultBean result) {
                orderCenterDetailsView.getOrderCenterDetailsSuccess(result);
                WorkOrder workOrder = result.getWorkOrder();
                CustomerInfo customerInfo = result.getCustomerInfo();
                List<AuditRecordDetails> listAuditRecord = result.getListAuditRecord();
                List<PerformRecordDetails> listPerformRecord = result.getListPerformRecord();
                if (workOrder != null) {
                    //設置訂單
                    if (workOrder.getOrderNumber() != null)
                        orderCenterDetailsView.setOrderCenterNumber(workOrder.getOrderNumber());
                    //预约时间
                    if (workOrder.getAppointmentTime() != null)
                        orderCenterDetailsView.setOrderCenterPlanTime(workOrder.getAppointmentTime());
                    //订单备注
                    if (workOrder.getOrderRemark() != null)
                        orderCenterDetailsView.setOrderCenterRemark(workOrder.getOrderRemark());
                    //服务类型
                    if (workOrder.getOrderType() != null)
                        orderCenterDetailsView.setOrderCenterServiceType(WorkOrderTypeStatusEnum.getValueText(workOrder.getOrderType()));
                    //金额
                    if (workOrder.getOrderMoney() != null)
                        orderCenterDetailsView.setOrderCenterPrice((workOrder.getOrderMoney() / 100f) + "");
                }
                if (customerInfo != null) {

                    //服务地址
                    if (customerInfo.getAddress() != null)
                        orderCenterDetailsView.setOrderCenterServiceLocation(customerInfo.getAddress());

                    //服务对象
                    if (customerInfo.getServiceTarget() != null)
                        orderCenterDetailsView.setOrderCenterServiceTag(customerInfo.getServiceTarget());

                    //联系人信息
                    if (customerInfo.getContactName() != null)
                        orderCenterDetailsView.setOrderCenterCustomerName(customerInfo.getContactName());
                    if (customerInfo.getContactPhone() != null)
                        orderCenterDetailsView.setOrderCenterCustomerPhone(customerInfo.getContactPhone());

                    //经办人信息
                    if (customerInfo.getAgentName() != null)
                        orderCenterDetailsView.setOrderCenterAgentName(customerInfo.getAgentName());
                    if (customerInfo.getAgentPhone() != null)
                        orderCenterDetailsView.setOrderCenterAgentPhone(customerInfo.getAgentPhone());

                }

                if (listAuditRecord != null) {
                    orderCenterDetailsView.setOrderCenterAuditRecordList(listAuditRecord);
                }
                if (listPerformRecord != null) {
                    orderCenterDetailsView.setOrderCenterPerformRecordList(listPerformRecord);
                }
            }

            @Override
            public void getDataFail(String msg) {
                orderCenterDetailsView.getOrderCenterDetailsFail(msg);
            }
        });

    }
}
