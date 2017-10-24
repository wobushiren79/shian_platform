package com.shianlife.shian_platform.mvp.ordercenter.bean;

import java.util.List;

/**
 * Created by zm.
 */

public class OrderCenterDetails {
    private WorkOrder workOrder;//订单数据
    private CustomerInfo customerInfo;//客戶資料

    private List<PerformRecordDetails> listPerformRecord;//执行处理记录
    private List<AuditRecordDetails> listAuditRecord;//审核处理记录
    private List<OrderStatusChange> listOrderStatusChange;//订单变化记录

    private String performerName;//执行人员名称
    private String performerPhone;

    private String auditorName;//审核人员名称
    private String auditorPhone;

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<PerformRecordDetails> getListPerformRecord() {
        return listPerformRecord;
    }

    public void setListPerformRecord(List<PerformRecordDetails> listPerformRecord) {
        this.listPerformRecord = listPerformRecord;
    }

    public List<AuditRecordDetails> getListAuditRecord() {
        return listAuditRecord;
    }

    public void setListAuditRecord(List<AuditRecordDetails> listAuditRecord) {
        this.listAuditRecord = listAuditRecord;
    }

    public List<OrderStatusChange> getListOrderStatusChange() {
        return listOrderStatusChange;
    }

    public void setListOrderStatusChange(List<OrderStatusChange> listOrderStatusChange) {
        this.listOrderStatusChange = listOrderStatusChange;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getPerformerPhone() {
        return performerPhone;
    }

    public void setPerformerPhone(String performerPhone) {
        this.performerPhone = performerPhone;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getAuditorPhone() {
        return auditorPhone;
    }

    public void setAuditorPhone(String auditorPhone) {
        this.auditorPhone = auditorPhone;
    }
}
